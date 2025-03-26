package teachingassistant.kcl.metamodel.export;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import metamodel.Assistant;
import metamodel.Day;
import metamodel.Department;
import metamodel.Lecturer;
import metamodel.Skill;
import metamodel.Timeslot;
import metamodel.Tutorial;
import metamodel.Week;
import metamodel.Module;

public class ModelToJsonExporter {
    private Department model;

    public ModelToJsonExporter(final Department model) {
        this.model = model;
    }

    public void modelToJson(final String outputPath) {
        JsonArray assistantsJson = new JsonArray();
        for (final Assistant a : model.getAssistants()) {
            assistantsJson.add(convertAssistantToJson(a));
        }
        
        JsonArray tutorialsJson = flattenTutorialsFromModules();
        
        JsonArray timeslotsJson = flattenTimeslotsFromDays();
        
        JsonArray lecturersJson = new JsonArray();
        for (final Lecturer l : model.getLecturers()) {
            lecturersJson.add(lecturerToJson(l));
        }
        JsonArray modulesJson = new JsonArray();
        for (final Module m : model.getModules()) {
            modulesJson.add(convertModuleToJson(m));
        }
        JsonArray daysJson = new JsonArray();
        for (final Day d : model.getDays()) {
            daysJson.add(convertDayToJson(d));
        }
        JsonArray weeksJson = new JsonArray();
        for (final Week w : model.getWeeks()) {
            weeksJson.add(convertWeekToJson(w));
        }
        
        JsonObject json = new JsonObject();
        json.addProperty("department", model.getName());
        json.add("assistants", assistantsJson);
        json.add("tutorials", tutorialsJson);
        json.add("timeslots", timeslotsJson);
        json.add("lecturers", lecturersJson);
        json.add("modules", modulesJson);
        json.add("days", daysJson);
        json.add("weeks", weeksJson);
        
        FileUtils.writeFileFromJson(outputPath, json);
    }

    private JsonArray flattenTutorialsFromModules() {
        JsonArray flatTutorials = new JsonArray();
        Set<String> seen = new HashSet<>();
        for (Module m : model.getModules()) {
            for (Tutorial t : m.getTutorials()) {
                if (seen.add(t.getName())) { 
                    flatTutorials.add(convertTutorialToJson(t));
                }
            }
        }
        return flatTutorials;
    }
    
    private JsonArray flattenTimeslotsFromDays() {
        JsonArray flatTimeslots = new JsonArray();
        Set<Integer> seen = new HashSet<>();
        for (Day d : model.getDays()) {
            d.getTimeslots().forEach(ts -> {
                if (seen.add(ts.getId())) {
                    flatTimeslots.add(convertTimeslotToJson(ts));
                }
            });
        }
        return flatTimeslots;
    }

    private JsonObject convertAssistantToJson(final Assistant assistant) {
        JsonObject assistantJson = new JsonObject();
        assistantJson.addProperty("name", assistant.getName());
        assistantJson.addProperty("minimumHoursPerWeek", assistant.getMinimumHoursPerWeek());
        assistantJson.addProperty("maximumHoursPerWeek", assistant.getMaximumHoursPerWeek());
        assistantJson.addProperty("maximumDaysPerWeek", assistant.getMaximumDaysPerWeek());
        assistantJson.addProperty("maximumHoursTotal", assistant.getMaximumHoursTotal());
        JsonArray skills = new JsonArray();
        assistant.getSkills().forEach(s -> skills.add(convertSkillToJson(s)));
        assistantJson.add("skills", skills);
        JsonArray blockedDates = new JsonArray();
        assistant.getBlockedDates().forEach(day -> blockedDates.add(day.getName()));
        assistantJson.add("blockedDates", blockedDates);
        return assistantJson;
    }

    private JsonObject convertSkillToJson(final Skill skill) {
        JsonObject skillJson = new JsonObject();
        skillJson.addProperty("name", skill.getName());
        skillJson.addProperty("preference", skill.getPreference());
        return skillJson;
    }

    private JsonObject convertWeekToJson(final Week week) {
        JsonObject weekJson = new JsonObject();
        weekJson.addProperty("name", week.getName());
        JsonArray days = new JsonArray();
        week.getDays().forEach(d -> days.add(d.getName()));
        weekJson.add("days", days);
        return weekJson;
    }

    private JsonObject convertDayToJson(final Day day) {
        JsonObject dayJson = new JsonObject();
        dayJson.addProperty("name", day.getName());
        JsonArray timeslots = new JsonArray();
        day.getTimeslots().forEach(ts -> timeslots.add(ts.getId()));
        dayJson.add("timeslots", timeslots);
        dayJson.addProperty("week", day.getWeek().getName());
        return dayJson;
    }

    private JsonObject convertTimeslotToJson(final Timeslot timeslot) {
        JsonObject timeslotJson = new JsonObject();
        timeslotJson.addProperty("id", timeslot.getId());
        timeslotJson.addProperty("day", timeslot.getDay().getName());
        timeslotJson.addProperty("name", timeslot.getName());
        return timeslotJson;
    }

    private JsonObject convertTutorialToJson(final Tutorial tutorial) {
        JsonObject tutorialJson = new JsonObject();
        tutorialJson.addProperty("name", tutorial.getName());
        if (tutorial.getGivenBy() != null) {
            tutorialJson.addProperty("givenBy", tutorial.getGivenBy().getName());
        }
        tutorialJson.addProperty("duration", tutorial.getDuration());
        tutorialJson.addProperty("timeslot", tutorial.getTimeslot().getId());
        tutorialJson.addProperty("lecturer", tutorial.getLecturer().getName());
        tutorialJson.addProperty("skillType", tutorial.getSkillType());
        tutorialJson.addProperty("type", tutorial.getType());
        tutorialJson.addProperty("campus", tutorial.getCampus());
        tutorialJson.addProperty("requiredNumberOfTas", tutorial.getRequiredNumberOfTas());
        JsonArray weeks = new JsonArray();
        tutorial.getWeeks().forEach(w -> weeks.add(w.getName()));
        tutorialJson.add("weeks", weeks);
        return tutorialJson;
    }

    private JsonObject lecturerToJson(final Lecturer lecturer) {
        JsonObject lecturerJson = new JsonObject();
        lecturerJson.addProperty("name", lecturer.getName());
        JsonArray tutorials = new JsonArray();
        lecturer.getTutorials().forEach(t -> tutorials.add(t.getName()));
        lecturerJson.add("tutorials", tutorials);
        lecturerJson.addProperty("skillTypeName", lecturer.getSkillTypeName());
        lecturerJson.addProperty("maximumNumberOfTas", lecturer.getMaximumNumberOfTas());
        return lecturerJson;
    }

    private JsonObject convertModuleToJson(final Module module) {
        JsonObject moduleJson = new JsonObject();
        moduleJson.addProperty("code", module.getCode());
        moduleJson.addProperty("name", module.getName());
        moduleJson.addProperty("lecturer", module.getLecturer().getName());
        moduleJson.addProperty("maximumNumberOfTas", module.getMaximumNumberOfTas());
        JsonArray sessions = new JsonArray();
        module.getTutorials().forEach(t -> sessions.add(t.getName()));
        moduleJson.add("sessions", sessions);
        return moduleJson;
    }
}

class FileUtils {
    public static void writeFileFromJson(String path, JsonObject json) {
        try (FileWriter file = new FileWriter(path)) {
            file.write(json.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
