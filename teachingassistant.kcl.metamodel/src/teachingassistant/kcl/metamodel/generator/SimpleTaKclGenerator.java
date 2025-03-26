package teachingassistant.kcl.metamodel.generator;
import metamodel.Tutorial;

import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

import org.emoflon.smartemf.runtime.SmartObject;

import metamodel.Day;
import metamodel.Department;
import metamodel.Lecturer;
import metamodel.Week;
import teachingassistant.kcl.metamodel.export.ModelToJsonExporter;

public class SimpleTaKclGenerator extends TeachingAssistantKclGenerator {

    // Configuration for KCL Informatics department scenario 

    // Modules and Lecturers
    int NUMBER_OF_LECTURERS = 7;  // 7 modules (each module led by a lecturer (we can think of these as module leaders))
    int LECTURERS_MINIMUM_NUMBER_OF_ASSISTANTS = 1;
    int LECTURERS_MAXIMUM_NUMBER_OF_ASSISTANTS = 8;

    // Assistants 
    int NUMBER_OF_ASSISTANTS = 10;
    int ASSISTANTS_MAXIMUM_NUMBER_OF_DAYS_PER_WEEK = 3;
    int ASSISTANTS_MINIMUM_NUMBER_OF_HOURS_PER_WEEK = 0;
    int ASSISTANTS_MAXIMUM_NUMBER_OF_HOURS_PER_WEEK = 20; // Max 20 hours/week per TA 
    int ASSISTANTS_MAXIMUM_HOURS_TOTAL = 312;             // Total hours cap
    int ASSISTANTS_MINIMUM_NUMBER_OF_BLOCKED_DAYS = 0;
    int ASSISTANTS_MAXIMUM_NUMBER_OF_BLOCKED_DAYS = 1;

    // Timeslots
    int NUMBER_OF_TIMESLOTS_PER_WEEK = 10;  // 5 days * 2 slots per day

    
    // We ll explicitly add Week_23 to Week_26 (4 weeks) where we use king's week numbering
    
    /**
     * Runs the scenario generation and writes an XMI and JSON file to the output path.
     * @param args not used
     */
    public static void main(final String[] args) {
        final SimpleTaKclGenerator gen = new SimpleTaKclGenerator(0);
        final String instanceFolderPath = gen.prepareFolder();
        final Department model = gen.constructModel();
        try {
            save(model, instanceFolderPath + "/kcl_department.xmi");
        } catch (final IOException e) {
            e.printStackTrace();
        }
        final ModelToJsonExporter exporter = new ModelToJsonExporter(model);
        exporter.modelToJson(instanceFolderPath + "/kcl_department.json");
        System.out.println("=> Scenario generation finished.");
    }

    public SimpleTaKclGenerator(final int seed) {
        rand = new Random(seed);
    }

    public Department constructModel() {
    	// 1) Creating the Department 
        this.root = factory.createDepartment();
        root.setName("Informatics");
        // 2) We create academic weeks 23–26 (each with Monday–Friday)
        for (int weekNum = 23; weekNum <= 26; weekNum++) {
            addWeekWithDays("Week_" + weekNum);
        }

        // 2. Creating Lecturers and corresponding Modules
        String[] moduleCodes = {"4CCS1FCOM", "4CCS1DBS", "4CCS1PRP", "5CCS2OS", "5CCS2SEG", "6CCS3ML", "6CCS3ALG"};
        String[] moduleTitles = {
            "Foundations of Computing", 
            "Database Systems", 
            "Programming Practice", 
            "Operating Systems", 
            "Software Engineering", 
            "Machine Learning", 
            "Algorithms"
        };
        // Each module gets one lecturer (module leader)
        for (int i = 0; i < NUMBER_OF_LECTURERS; i++) {
            String lectName = "Lecturer_" + (i+1);
            String moduleCode = moduleCodes[i];
            String moduleTitle = moduleTitles[i];
            // Creating lecturer with skillType = module code (we link them to the module's subject)
            addLecturer(lectName, moduleCode);
            // assigning a random maximum number of TAs the lecturer (module) can have (1–8)
            int maxTAs = getRandInt(LECTURERS_MINIMUM_NUMBER_OF_ASSISTANTS, LECTURERS_MAXIMUM_NUMBER_OF_ASSISTANTS);
            lecturers.get(lectName).setMaximumNumberOfTas(maxTAs);
            // we create the Module and link it with this lecturer
            addModule(moduleCode, moduleTitle, lecturers.get(lectName), maxTAs);
        }
        
        


        // 3. Creating TAs with varying availability and module approval preferences
        for (int i = 0; i < NUMBER_OF_ASSISTANTS; i++) {
            String taName = "Assistant_" + (i+1);
            // to make it realistic, we randomize each TA's max hours per week (e.g., between 6 and 20 hours)
            int randomMaxHours = getRandInt(6, ASSISTANTS_MAXIMUM_NUMBER_OF_HOURS_PER_WEEK);
            addAssistant(taName, ASSISTANTS_MINIMUM_NUMBER_OF_HOURS_PER_WEEK, randomMaxHours,
                         ASSISTANTS_MAXIMUM_NUMBER_OF_DAYS_PER_WEEK, ASSISTANTS_MAXIMUM_HOURS_TOTAL);
            // Assign each TA a preference/approval for each module (skillType == module code).
            // At kings we do it this was: 2 = preferred, 1 = approved, 0 = unapproved
            for (final String moduleCode : modules.keySet()) {
                int prefLevel = getRandInt(0, 2);
                addSkillToAssistant(taName, moduleCode, prefLevel);
            }
            // we then randomly assign days off for each TA (0 or 1per week)
            Set<Day> blockedDates = new HashSet<>();
            int numberOfBlockedDays = getRandInt(ASSISTANTS_MINIMUM_NUMBER_OF_BLOCKED_DAYS, ASSISTANTS_MAXIMUM_NUMBER_OF_BLOCKED_DAYS);
            int counter = 0;
            while (counter < numberOfBlockedDays) {
                Day randomDay = getRandomDay();
                if (blockedDates.add(randomDay)) {
                    counter++;
                }
            }
            assistants.get(taName).getBlockedDates().addAll(blockedDates);
        }
        root.getAssistants().addAll(assistants.values());

        // 4. We Create timeslots for each week 
        int totalWeeks = 26 - 23 + 1;  // 4 weeks (23,24,25,26)
        for (int wIndex = 0; wIndex < totalWeeks; wIndex++) {
            for (int j = 0; j < NUMBER_OF_TIMESLOTS_PER_WEEK; j++) {
                int timeslotId = (wIndex * NUMBER_OF_TIMESLOTS_PER_WEEK) + j;
                addTimeslot(timeslotId);
                Week weekObj = weeks.get("Week_" + (23 + wIndex));
                Day dayObj = weekObj.getDays().get(j % 5);
                dayObj.getTimeslots().add(timeslots.get(timeslotId));
            }
        }
        root.getTimeslots().addAll(timeslots.values());


        // 5. creating 40 sessions (Tutorials/Labs) across the 7 modules with appropriate metadata
        for (String moduleCode : modules.keySet()) {
            // we first determine how many tutorial and lab groups for this module
            int tutGroups = 0;
            int labGroups = 0;
            // Assign different module structures: some have both tutorial and lab groups / others only one type
            switch (moduleCode) {
                case "4CCS1FCOM": // Module 1: both types
                case "4CCS1DBS":  // Module 2: both type
                    tutGroups = 4;
                    labGroups = 4;
                    break;
                case "4CCS1PRP":  //Module 3: both types
                    tutGroups = 3;
                    labGroups = 3;
                    break;
                case "5CCS2OS":   // Module 4: tutorials only
                    tutGroups = 5;
                    labGroups = 0;
                    break;
                case "5CCS2SEG":  //Module 5: labs only
                    tutGroups = 0;
                    labGroups = 5;
                    break;
                case "6CCS3ML":   // Module 6 tutorials only
                    tutGroups = 4;
                    labGroups = 0;
                    break;
                case "6CCS3ALG":  // Module 7: labs only
                    tutGroups = 0;
                    labGroups = 4;
                    break;
            }
            // We then decide a campus for all sessions of this module (either Strand or Waterloo (I'm not sure whether Guy's has informatics sessions)
            String campus = (getRandInt(0, 1) == 0) ? "Strand" : "Waterloo";
            // Deciding which weeks the module's sessions run (example weeks 23–26)
            int durationInWeeks = getRandInt(1, 4);  // length of the session ( here from 1 to 4 weeks)
            int startWeekNum = getRandInt(23, 26 - durationInWeeks + 1);
            int endWeekNum = startWeekNum + durationInWeeks - 1;
            // Create tutorial sessions for this module
            for (int t = 1; t <= tutGroups; t++) {
                String sessionName = moduleCode + "_Tutorial_Group" + t;
                
                int slotId = getRandInt(0, 9);  // choosing a timeslot (0–9 corresponds to Week_23 Mon to Fri slots)
                addTutorial(sessionName, moduleCode, 1, slotId);
                Tutorial session = tutorials.get(sessionName);
                session.setType("Tutorial");
                session.setCampus(campus);
                session.setRequiredNumberOfTas(1);
                // We also need to assign the weeks this session occurs (example weeks 23 through endWeekNum)
                for (int wk = startWeekNum; wk <= endWeekNum; wk++) {
                    session.getWeeks().add(weeks.get("Week_" + wk));
                }
                // Link session to its lecturer and module
                Lecturer moduleLecturer = modules.get(moduleCode).getLecturer();
                moduleLecturer.getTutorials().add(session);
                session.setLecturer(moduleLecturer);
                modules.get(moduleCode).getTutorials().add(session);
            }
            // we create lab sessions for this module
            for (int l = 1; l <= labGroups; l++) {
                String sessionName = moduleCode + "_Lab_Group" + l;
                // Labs 2 hours duration, random timeslot  (note that above, tutorials were 1hour duration and 1TA)
                int slotId = getRandInt(0, 9);
                addTutorial(sessionName, moduleCode, 2, slotId);
                Tutorial session = tutorials.get(sessionName);
                session.setType("Lab");
                session.setCampus(campus);
                // Some labs may require 2 TAs if large; we decide randomly with 50% chance
                session.setRequiredNumberOfTas(getRandInt(0, 1) == 1 ? 2 : 1);
                for (int wk = startWeekNum; wk <= endWeekNum; wk++) {
                    session.getWeeks().add(weeks.get("Week_" + wk));
                }
                Lecturer moduleLecturer = modules.get(moduleCode).getLecturer();
                moduleLecturer.getTutorials().add(session);
                session.setLecturer(moduleLecturer);
                modules.get(moduleCode).getTutorials().add(session);
            }
        }
        
        for (metamodel.Module mod : modules.values()) {
            root.getModules().add(mod);
        }
        root.getTutorials().addAll(tutorials.values());
        root.getLecturers().addAll(lecturers.values());
        root.getDays().addAll(days.values());
        root.getWeeks().addAll(weeks.values());


        
        return root;
    }

    @Override
    public void populateTutorialsToLecturers() {
        // All tutorials have been explicitly associated with lecturers and modules in constructModel
    }

    private Day getRandomDay() {
        int randomDayIndex = getRandInt(0, days.size() - 1);
        int counter = 0;
        Iterator<Day> it = days.values().iterator();
        Day d = null;
        while (it.hasNext()) {
            d = it.next();
            counter++;
            if (counter == randomDayIndex) {
                break;
            }
        }
        return d;
    }
}
