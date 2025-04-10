package teachingassistant.kcl.metamodel.generator;
import metamodel.Tutorial;
import org.eclipse.emf.ecore.EReference;
import org.emoflon.smartemf.runtime.SmartObject;

import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

import metamodel.Day;
import metamodel.Department;
import metamodel.Lecturer;
import metamodel.Week;
import teachingassistant.kcl.metamodel.export.ModelToJsonExporter;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emoflon.smartemf.persistence.SmartEMFResourceFactoryImpl;
import org.emoflon.smartemf.runtime.collections.LinkedSmartESet;

import com.google.common.base.Preconditions;

import metamodel.Assistant;
import metamodel.Day;
import metamodel.Department;
import metamodel.Lecturer;
import metamodel.Skill;
import metamodel.Timeslot;
import metamodel.Tutorial;
import metamodel.Week;
import metamodel.MetamodelFactory;
import metamodel.MetamodelPackage;
import metamodel.Module;  

public class TeachingAssistantKclGenerator {
    protected MetamodelFactory factory = MetamodelFactory.eINSTANCE;
    protected Department root;
    protected Map<String, Assistant> assistants = new LinkedHashMap<>();
    protected Map<String, Tutorial> tutorials = new LinkedHashMap<>();
    protected Map<Integer, Timeslot> timeslots = new LinkedHashMap<>();
    protected Map<String, Lecturer> lecturers = new LinkedHashMap<>();
    protected Map<String, Day> days = new LinkedHashMap<>();
    protected Map<String, Week> weeks = new LinkedHashMap<>();
    protected Map<String, Module> modules = new LinkedHashMap<>();  
    protected Random rand;
    protected static List<String> allSkillTypes;
    static {
        allSkillTypes = new ArrayList<String>();
        allSkillTypes.add("Mathematics");
        allSkillTypes.add("Computer_Science");
        allSkillTypes.add("Electrical_Engineering");
        allSkillTypes.add("Finance");
        allSkillTypes.add("Chemistry");
        allSkillTypes.add("Biology");
        allSkillTypes.add("Physics");
        allSkillTypes.add("Mechanics");
        allSkillTypes.add("Psychology");
    }

    public Department generate(final String departmentName) {
        checkNotNull(departmentName, "Name");
        populateTutorialsToLecturers();  // Will be overridden 
        root = factory.createDepartment();
        root.setName(departmentName);
        root.getAssistants().addAll(assistants.values());
        root.getTutorials().addAll(tutorials.values());
        root.getTimeslots().addAll(timeslots.values());
        root.getLecturers().addAll(lecturers.values());
        root.getModules().addAll(modules.values());  
        root.getDays().addAll(days.values());
        root.getWeeks().addAll(weeks.values());
        return root;
    }

    public void addWeekWithDays(final String name) {
        addWeek(name);
        
        weeks.get(name).getDays().add(addDay(name + "_Monday"));
        weeks.get(name).getDays().add(addDay(name + "_Tuesday"));
        weeks.get(name).getDays().add(addDay(name + "_Wednesday"));
        weeks.get(name).getDays().add(addDay(name + "_Thursday"));
        weeks.get(name).getDays().add(addDay(name + "_Friday"));
    }

    public void addTutorial(final String name, final String skillType, final int duration) {
        checkNotNull(name, "Name");
        checkNotNull(skillType, "Type");
        final Tutorial t = factory.createTutorial();
        t.setName(name);
        t.setDuration(duration);
        t.setSkillType(skillType);
        tutorials.put(name, t);
    }

    public void addTutorial(final String name, final String skillType, final int duration, final int timeslot) {
        checkNotNull(timeslot, "Time slot");
        addTutorial(name, skillType, duration);
        tutorials.get(name).setTimeslot(timeslots.get(timeslot));
    }

    public void addAssistant(final String name, final int minHoursPerWeek, final int maxHoursPerWeek) {
        checkNotNull(name, "Name");
        final Assistant a = factory.createAssistant();
        a.setMinimumHoursPerWeek(minHoursPerWeek);
        a.setMaximumHoursPerWeek(maxHoursPerWeek);
        a.setName(name);
        assistants.put(name, a);
    }

    public void addAssistant(final String name, final int minHoursPerWeek, final int maxHoursPerWeek,
                              final int maxDaysPerWeek) {
        addAssistant(name, minHoursPerWeek, maxHoursPerWeek);
        assistants.get(name).setMaximumDaysPerWeek(maxDaysPerWeek);
    }

    public void addAssistant(final String name, final int minHoursPerWeek, final int maxHoursPerWeek,
                              final int maxDaysPerWeek, final int maxHoursTotal) {
        addAssistant(name, minHoursPerWeek, maxHoursPerWeek);
        assistants.get(name).setMaximumDaysPerWeek(maxDaysPerWeek);
        assistants.get(name).setMaximumHoursTotal(maxHoursTotal);
    }

    public void addSkillToAssistant(final String name, final String skillType, final int preference) {
        checkNotNull(name, "Name");
        checkNotNull(skillType, "Type");
        if (!assistants.containsKey(name)) {
            throw new UnsupportedOperationException("Assistant with name <" + name + "> does not exist.");
        }
        final Skill s = createSkill(skillType, preference);
        assistants.get(name).getSkills().add(s);
    }

    private Skill createSkill(final String name, final int preference) {
        if (preference < 0) {
            throw new IllegalArgumentException("Skill preference must not be negative.");
        }
        checkNotNull(name, "SkillType");
        final Skill s = factory.createSkill();
        s.setName(name);
        s.setPreference(preference);
        return s;
    }

    public void addTimeslot(final int id) {
        if (id < 0) {
            throw new IllegalArgumentException("Time slot ID must not be negative.");
        }
        final Timeslot t = factory.createTimeslot();
        t.setName(String.valueOf(id));
        t.setId(id);
        timeslots.put(Integer.valueOf(id), t);
    }

    public void addLecturer(final String name, final String skillType) {
        checkNotNull(name, "Name");
        final Lecturer l = factory.createLecturer();
        l.setName(name);
        l.setSkillTypeName(skillType);
        lecturers.put(name, l);
    }

    public void addLecturer(final String name, final String skillType, final int maximumNumberOfTas) {
        addLecturer(name, skillType);
        lecturers.get(name).setMaximumNumberOfTas(maximumNumberOfTas);
    }

    public void addModule(final String code, final String title, final Lecturer lecturer, final int maxNumberOfTas) {
        checkNotNull(code, "Code");
        checkNotNull(title, "Title");
        final Module module = factory.createModule();
        module.setCode(code);
        module.setName(title);
        if (lecturer != null) {
            module.setLecturer(lecturer);
        }
        module.setMaximumNumberOfTas(maxNumberOfTas);

        modules.put(code, module);
    }



    public void populateTutorialsToLecturers() {
        
        for (final Tutorial t : tutorials.values()) {
            final List<Lecturer> filteredLecturers = lecturers.values().stream()
                    .filter(l -> l.getSkillTypeName().equals(t.getSkillType()))
                    .collect(Collectors.toList());
            final Lecturer randomLecturer = filteredLecturers.get(rand.nextInt(filteredLecturers.size()));
            randomLecturer.getTutorials().add(t);
            t.setLecturer(randomLecturer);
        }
        for (final Lecturer l : lecturers.values()) {
            if (l.getTutorials().isEmpty()) {
                throw new InternalError("=> Lecturer <" + l.getName() + "> did not get any tutorials.");
            }
        }
    }

    public Day addDay(final String name) {
        checkNotNull(name, "Name");
        final Day d = factory.createDay();
        d.setName(name);
        days.put(name, d);
        return d;
    }

    public void addWeek(final String name) {
        checkNotNull(name, "Name");
        final Week w = factory.createWeek();
        w.setName(name);
        weeks.put(name, w);
    }

    protected String prepareFolder() {
        final String projectFolder = System.getProperty("user.dir");
        final String instancesFolder = projectFolder + "/../teachingassistant.kcl.metamodel/instances";
        final File f = new File(instancesFolder);
        if (!f.exists()) {
            f.mkdirs();
        }
        return instancesFolder;
    }

    protected int getRandInt(final int min, final int max) {
        return rand.nextInt((max - min) + 1) + min;
    }

    protected String getRandomSkillType() {
        final int randomIndex = getRandInt(0, allSkillTypes.size() - 1);
        return allSkillTypes.get(randomIndex);
    }

    private static void checkNotNull(final Object o, final String type) {
        if (o == null) {
            throw new IllegalArgumentException(type + " must not be null.");
        }
    }

    public static void save(final Department model, final String path) throws IOException {
        final Resource r = saveAndReturn(model, path);
        r.unload();
    }

    public static Resource saveAndReturn(final Department model, final String path) throws IOException {
        checkNotNull(model, "Model");
        checkNotNull(path, "Path");
        final URI uri = URI.createFileURI(path);
        final ResourceSet rs = new ResourceSetImpl();
        rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi", new SmartEMFResourceFactoryImpl("../"));
        rs.getPackageRegistry().put(MetamodelPackage.eNS_URI, MetamodelPackage.eINSTANCE);
        final Resource r = rs.createResource(uri);
        r.getContents().add(model);
        r.save(null);
        return r;
    }
}
