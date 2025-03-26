package metamodel.impl;

import metamodel.NamedElement;
import metamodel.Department;
import metamodel.Assistant;
import metamodel.Tutorial;
import metamodel.Skill;
import metamodel.Timeslot;
import metamodel.Lecturer;
import metamodel.Day;
import metamodel.Week;
import metamodel.Module;


import metamodel.MetamodelFactory;
import metamodel.MetamodelPackage;


import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.emoflon.smartemf.runtime.SmartPackageImpl;

public class MetamodelPackageImpl extends SmartPackageImpl
		implements MetamodelPackage {
			
	private EClass namedElementEClass = null;
	private EAttribute namedElement_nameEAttribute = null;
	private EClass departmentEClass = null;
	private EReference department_assistantsEReference = null;
	private EReference department_tutorialsEReference = null;
	private EReference department_timeslotsEReference = null;
	private EReference department_lecturersEReference = null;
	private EReference department_daysEReference = null;
	private EReference department_weeksEReference = null;
	private EReference department_modulesEReference = null;
	private EClass assistantEClass = null;
	private EAttribute assistant_minimumHoursPerWeekEAttribute = null;
	private EAttribute assistant_maximumHoursPerWeekEAttribute = null;
	private EAttribute assistant_maximumDaysPerWeekEAttribute = null;
	private EReference assistant_skillsEReference = null;
	private EAttribute assistant_maximumHoursTotalEAttribute = null;
	private EReference assistant_blockedDatesEReference = null;
	private EClass tutorialEClass = null;
	private EReference tutorial_givenByEReference = null;
	private EAttribute tutorial_durationEAttribute = null;
	private EReference tutorial_timeslotEReference = null;
	private EReference tutorial_lecturerEReference = null;
	private EAttribute tutorial_skillTypeEAttribute = null;
	private EAttribute tutorial_typeEAttribute = null;
	private EAttribute tutorial_campusEAttribute = null;
	private EAttribute tutorial_requiredNumberOfTasEAttribute = null;
	private EReference tutorial_weeksEReference = null;
	private EClass skillEClass = null;
	private EAttribute skill_preferenceEAttribute = null;
	private EClass timeslotEClass = null;
	private EAttribute timeslot_idEAttribute = null;
	private EReference timeslot_dayEReference = null;
	private EClass lecturerEClass = null;
	private EReference lecturer_tutorialsEReference = null;
	private EAttribute lecturer_skillTypeNameEAttribute = null;
	private EAttribute lecturer_maximumNumberOfTasEAttribute = null;
	private EClass dayEClass = null;
	private EReference day_timeslotsEReference = null;
	private EReference day_weekEReference = null;
	private EClass weekEClass = null;
	private EReference week_daysEReference = null;
	private EClass moduleEClass = null;
	private EAttribute module_codeEAttribute = null;
	private EReference module_lecturerEReference = null;
	private EReference module_tutorialsEReference = null;
	private EAttribute module_maximumNumberOfTasEAttribute = null;
	
	

	private MetamodelPackageImpl() {
		super(eNS_URI, metamodel.MetamodelFactory.eINSTANCE);
	}

	private static boolean isRegistered = false;
	private boolean isCreated = false;
	private boolean isInitialized = false;

	public static MetamodelPackage init() {
		if (isRegistered)
			return (MetamodelPackage) EPackage.Registry.INSTANCE
					.getEPackage(MetamodelPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredMetamodelPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		MetamodelPackageImpl theMetamodelPackage = registeredMetamodelPackage instanceof MetamodelPackageImpl
				? (MetamodelPackageImpl) registeredMetamodelPackage
				: new MetamodelPackageImpl();

		isRegistered = true;

		// Create package meta-data objects
		theMetamodelPackage.createPackageContents();

		// Initialize created meta-data
		theMetamodelPackage.initializePackageContents();
		
		// Inject internal eOpposites to unidirectional references
		theMetamodelPackage.injectDynamicOpposites();
		
		// Inject external references into foreign packages
		theMetamodelPackage.injectExternalReferences();

		// Mark meta-data to indicate it can't be changed
		theMetamodelPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(MetamodelPackage.eNS_URI,
				theMetamodelPackage);
				
		theMetamodelPackage.fetchDynamicEStructuralFeaturesOfSuperTypes();
		return theMetamodelPackage;
	}

	@Override
	public EClass getNamedElement() {
		return namedElementEClass;
	}
	@Override
	public EAttribute getNamedElement_Name() {
		return namedElement_nameEAttribute;	
	}
	@Override
	public EClass getDepartment() {
		return departmentEClass;
	}
	@Override
	public EReference getDepartment_Assistants() {
		return department_assistantsEReference;	
	}
	@Override
	public EReference getDepartment_Tutorials() {
		return department_tutorialsEReference;	
	}
	@Override
	public EReference getDepartment_Timeslots() {
		return department_timeslotsEReference;	
	}
	@Override
	public EReference getDepartment_Lecturers() {
		return department_lecturersEReference;	
	}
	@Override
	public EReference getDepartment_Days() {
		return department_daysEReference;	
	}
	@Override
	public EReference getDepartment_Weeks() {
		return department_weeksEReference;	
	}
	@Override
	public EReference getDepartment_Modules() {
		return department_modulesEReference;	
	}
	@Override
	public EClass getAssistant() {
		return assistantEClass;
	}
	@Override
	public EAttribute getAssistant_MinimumHoursPerWeek() {
		return assistant_minimumHoursPerWeekEAttribute;	
	}
	@Override
	public EAttribute getAssistant_MaximumHoursPerWeek() {
		return assistant_maximumHoursPerWeekEAttribute;	
	}
	@Override
	public EAttribute getAssistant_MaximumDaysPerWeek() {
		return assistant_maximumDaysPerWeekEAttribute;	
	}
	@Override
	public EReference getAssistant_Skills() {
		return assistant_skillsEReference;	
	}
	@Override
	public EAttribute getAssistant_MaximumHoursTotal() {
		return assistant_maximumHoursTotalEAttribute;	
	}
	@Override
	public EReference getAssistant_BlockedDates() {
		return assistant_blockedDatesEReference;	
	}
	@Override
	public EClass getTutorial() {
		return tutorialEClass;
	}
	@Override
	public EReference getTutorial_GivenBy() {
		return tutorial_givenByEReference;	
	}
	@Override
	public EAttribute getTutorial_Duration() {
		return tutorial_durationEAttribute;	
	}
	@Override
	public EReference getTutorial_Timeslot() {
		return tutorial_timeslotEReference;	
	}
	@Override
	public EReference getTutorial_Lecturer() {
		return tutorial_lecturerEReference;	
	}
	@Override
	public EAttribute getTutorial_SkillType() {
		return tutorial_skillTypeEAttribute;	
	}
	@Override
	public EAttribute getTutorial_Type() {
		return tutorial_typeEAttribute;	
	}
	@Override
	public EAttribute getTutorial_Campus() {
		return tutorial_campusEAttribute;	
	}
	@Override
	public EAttribute getTutorial_RequiredNumberOfTas() {
		return tutorial_requiredNumberOfTasEAttribute;	
	}
	@Override
	public EReference getTutorial_Weeks() {
		return tutorial_weeksEReference;	
	}
	@Override
	public EClass getSkill() {
		return skillEClass;
	}
	@Override
	public EAttribute getSkill_Preference() {
		return skill_preferenceEAttribute;	
	}
	@Override
	public EClass getTimeslot() {
		return timeslotEClass;
	}
	@Override
	public EAttribute getTimeslot_Id() {
		return timeslot_idEAttribute;	
	}
	@Override
	public EReference getTimeslot_Day() {
		return timeslot_dayEReference;	
	}
	@Override
	public EClass getLecturer() {
		return lecturerEClass;
	}
	@Override
	public EReference getLecturer_Tutorials() {
		return lecturer_tutorialsEReference;	
	}
	@Override
	public EAttribute getLecturer_SkillTypeName() {
		return lecturer_skillTypeNameEAttribute;	
	}
	@Override
	public EAttribute getLecturer_MaximumNumberOfTas() {
		return lecturer_maximumNumberOfTasEAttribute;	
	}
	@Override
	public EClass getDay() {
		return dayEClass;
	}
	@Override
	public EReference getDay_Timeslots() {
		return day_timeslotsEReference;	
	}
	@Override
	public EReference getDay_Week() {
		return day_weekEReference;	
	}
	@Override
	public EClass getWeek() {
		return weekEClass;
	}
	@Override
	public EReference getWeek_Days() {
		return week_daysEReference;	
	}
	@Override
	public EClass getModule() {
		return moduleEClass;
	}
	@Override
	public EAttribute getModule_Code() {
		return module_codeEAttribute;	
	}
	@Override
	public EReference getModule_Lecturer() {
		return module_lecturerEReference;	
	}
	@Override
	public EReference getModule_Tutorials() {
		return module_tutorialsEReference;	
	}
	@Override
	public EAttribute getModule_MaximumNumberOfTas() {
		return module_maximumNumberOfTasEAttribute;	
	}
	
	

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public metamodel.MetamodelFactory getMetamodelFactory() {
		return (metamodel.MetamodelFactory) getEFactoryInstance();
	}

	public void createPackageContents() {
		if (isCreated)
			return;
		isCreated = true;

		// Create classes and their features
		namedElementEClass = createEClass(NAMED_ELEMENT);
		createEAttribute(namedElementEClass, NAMED_ELEMENT__NAME);
		namedElement_nameEAttribute = (EAttribute) namedElementEClass.getEStructuralFeatures().get(0);
		
		departmentEClass = createEClass(DEPARTMENT);
		createEReference(departmentEClass, DEPARTMENT__ASSISTANTS);
		department_assistantsEReference = (EReference) departmentEClass.getEStructuralFeatures().get(0);
		createEReference(departmentEClass, DEPARTMENT__TUTORIALS);
		department_tutorialsEReference = (EReference) departmentEClass.getEStructuralFeatures().get(1);
		createEReference(departmentEClass, DEPARTMENT__TIMESLOTS);
		department_timeslotsEReference = (EReference) departmentEClass.getEStructuralFeatures().get(2);
		createEReference(departmentEClass, DEPARTMENT__LECTURERS);
		department_lecturersEReference = (EReference) departmentEClass.getEStructuralFeatures().get(3);
		createEReference(departmentEClass, DEPARTMENT__DAYS);
		department_daysEReference = (EReference) departmentEClass.getEStructuralFeatures().get(4);
		createEReference(departmentEClass, DEPARTMENT__WEEKS);
		department_weeksEReference = (EReference) departmentEClass.getEStructuralFeatures().get(5);
		createEReference(departmentEClass, DEPARTMENT__MODULES);
		department_modulesEReference = (EReference) departmentEClass.getEStructuralFeatures().get(6);
		
		assistantEClass = createEClass(ASSISTANT);
		createEAttribute(assistantEClass, ASSISTANT__MINIMUM_HOURS_PER_WEEK);
		assistant_minimumHoursPerWeekEAttribute = (EAttribute) assistantEClass.getEStructuralFeatures().get(0);
		createEAttribute(assistantEClass, ASSISTANT__MAXIMUM_HOURS_PER_WEEK);
		assistant_maximumHoursPerWeekEAttribute = (EAttribute) assistantEClass.getEStructuralFeatures().get(1);
		createEAttribute(assistantEClass, ASSISTANT__MAXIMUM_DAYS_PER_WEEK);
		assistant_maximumDaysPerWeekEAttribute = (EAttribute) assistantEClass.getEStructuralFeatures().get(2);
		createEReference(assistantEClass, ASSISTANT__SKILLS);
		assistant_skillsEReference = (EReference) assistantEClass.getEStructuralFeatures().get(3);
		createEAttribute(assistantEClass, ASSISTANT__MAXIMUM_HOURS_TOTAL);
		assistant_maximumHoursTotalEAttribute = (EAttribute) assistantEClass.getEStructuralFeatures().get(4);
		createEReference(assistantEClass, ASSISTANT__BLOCKED_DATES);
		assistant_blockedDatesEReference = (EReference) assistantEClass.getEStructuralFeatures().get(5);
		
		tutorialEClass = createEClass(TUTORIAL);
		createEReference(tutorialEClass, TUTORIAL__GIVEN_BY);
		tutorial_givenByEReference = (EReference) tutorialEClass.getEStructuralFeatures().get(0);
		createEAttribute(tutorialEClass, TUTORIAL__DURATION);
		tutorial_durationEAttribute = (EAttribute) tutorialEClass.getEStructuralFeatures().get(1);
		createEReference(tutorialEClass, TUTORIAL__TIMESLOT);
		tutorial_timeslotEReference = (EReference) tutorialEClass.getEStructuralFeatures().get(2);
		createEReference(tutorialEClass, TUTORIAL__LECTURER);
		tutorial_lecturerEReference = (EReference) tutorialEClass.getEStructuralFeatures().get(3);
		createEAttribute(tutorialEClass, TUTORIAL__SKILL_TYPE);
		tutorial_skillTypeEAttribute = (EAttribute) tutorialEClass.getEStructuralFeatures().get(4);
		createEAttribute(tutorialEClass, TUTORIAL__TYPE);
		tutorial_typeEAttribute = (EAttribute) tutorialEClass.getEStructuralFeatures().get(5);
		createEAttribute(tutorialEClass, TUTORIAL__CAMPUS);
		tutorial_campusEAttribute = (EAttribute) tutorialEClass.getEStructuralFeatures().get(6);
		createEAttribute(tutorialEClass, TUTORIAL__REQUIRED_NUMBER_OF_TAS);
		tutorial_requiredNumberOfTasEAttribute = (EAttribute) tutorialEClass.getEStructuralFeatures().get(7);
		createEReference(tutorialEClass, TUTORIAL__WEEKS);
		tutorial_weeksEReference = (EReference) tutorialEClass.getEStructuralFeatures().get(8);
		
		skillEClass = createEClass(SKILL);
		createEAttribute(skillEClass, SKILL__PREFERENCE);
		skill_preferenceEAttribute = (EAttribute) skillEClass.getEStructuralFeatures().get(0);
		
		timeslotEClass = createEClass(TIMESLOT);
		createEAttribute(timeslotEClass, TIMESLOT__ID);
		timeslot_idEAttribute = (EAttribute) timeslotEClass.getEStructuralFeatures().get(0);
		createEReference(timeslotEClass, TIMESLOT__DAY);
		timeslot_dayEReference = (EReference) timeslotEClass.getEStructuralFeatures().get(1);
		
		lecturerEClass = createEClass(LECTURER);
		createEReference(lecturerEClass, LECTURER__TUTORIALS);
		lecturer_tutorialsEReference = (EReference) lecturerEClass.getEStructuralFeatures().get(0);
		createEAttribute(lecturerEClass, LECTURER__SKILL_TYPE_NAME);
		lecturer_skillTypeNameEAttribute = (EAttribute) lecturerEClass.getEStructuralFeatures().get(1);
		createEAttribute(lecturerEClass, LECTURER__MAXIMUM_NUMBER_OF_TAS);
		lecturer_maximumNumberOfTasEAttribute = (EAttribute) lecturerEClass.getEStructuralFeatures().get(2);
		
		dayEClass = createEClass(DAY);
		createEReference(dayEClass, DAY__TIMESLOTS);
		day_timeslotsEReference = (EReference) dayEClass.getEStructuralFeatures().get(0);
		createEReference(dayEClass, DAY__WEEK);
		day_weekEReference = (EReference) dayEClass.getEStructuralFeatures().get(1);
		
		weekEClass = createEClass(WEEK);
		createEReference(weekEClass, WEEK__DAYS);
		week_daysEReference = (EReference) weekEClass.getEStructuralFeatures().get(0);
		
		moduleEClass = createEClass(MODULE);
		createEAttribute(moduleEClass, MODULE__CODE);
		module_codeEAttribute = (EAttribute) moduleEClass.getEStructuralFeatures().get(0);
		createEReference(moduleEClass, MODULE__LECTURER);
		module_lecturerEReference = (EReference) moduleEClass.getEStructuralFeatures().get(1);
		createEReference(moduleEClass, MODULE__TUTORIALS);
		module_tutorialsEReference = (EReference) moduleEClass.getEStructuralFeatures().get(2);
		createEAttribute(moduleEClass, MODULE__MAXIMUM_NUMBER_OF_TAS);
		module_maximumNumberOfTasEAttribute = (EAttribute) moduleEClass.getEStructuralFeatures().get(3);
		
		// Create enums
		
		// Create data types
	}

	public void initializePackageContents() {
		if (isInitialized)
			return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);
		
		// Obtain other dependent packages

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		departmentEClass.getESuperTypes().add(this.getNamedElement());
		assistantEClass.getESuperTypes().add(this.getNamedElement());
		tutorialEClass.getESuperTypes().add(this.getNamedElement());
		skillEClass.getESuperTypes().add(this.getNamedElement());
		timeslotEClass.getESuperTypes().add(this.getNamedElement());
		lecturerEClass.getESuperTypes().add(this.getNamedElement());
		dayEClass.getESuperTypes().add(this.getNamedElement());
		weekEClass.getESuperTypes().add(this.getNamedElement());
		moduleEClass.getESuperTypes().add(this.getNamedElement());

		// Initialize classes, features, and operations; add parameters
		initEClass(namedElementEClass, NamedElement.class, "NamedElement", IS_ABSTRACT, !IS_INTERFACE,
			IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNamedElement_Name(), ecorePackage.getEString(),
			"name", null, 0, 1, NamedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE,
			!IS_DERIVED, IS_ORDERED);
		
		initEClass(departmentEClass, Department.class, "Department", !IS_ABSTRACT, !IS_INTERFACE,
			IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDepartment_Assistants(), this.getAssistant(),  null, 
			"assistants", null, 0, -1, Department.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES,
			!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDepartment_Tutorials(), this.getTutorial(),  null, 
			"tutorials", null, 0, -1, Department.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES,
			!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDepartment_Timeslots(), this.getTimeslot(),  null, 
			"timeslots", null, 0, -1, Department.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES,
			!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDepartment_Lecturers(), this.getLecturer(),  null, 
			"lecturers", null, 0, -1, Department.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES,
			!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDepartment_Days(), this.getDay(),  null, 
			"days", null, 0, -1, Department.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES,
			!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDepartment_Weeks(), this.getWeek(),  null, 
			"weeks", null, 0, -1, Department.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES,
			!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDepartment_Modules(), this.getModule(),  null, 
			"modules", null, 0, -1, Department.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES,
			!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
				
		initEClass(assistantEClass, Assistant.class, "Assistant", !IS_ABSTRACT, !IS_INTERFACE,
			IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAssistant_MinimumHoursPerWeek(), ecorePackage.getEInt(),
			"minimumHoursPerWeek", "0", 0, 1, Assistant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE,
			!IS_DERIVED, IS_ORDERED);
		initEAttribute(getAssistant_MaximumHoursPerWeek(), ecorePackage.getEInt(),
			"maximumHoursPerWeek", "0", 0, 1, Assistant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE,
			!IS_DERIVED, IS_ORDERED);
		initEAttribute(getAssistant_MaximumDaysPerWeek(), ecorePackage.getEInt(),
			"maximumDaysPerWeek", "0", 0, 1, Assistant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE,
			!IS_DERIVED, IS_ORDERED);
		initEReference(getAssistant_Skills(), this.getSkill(),  null, 
			"skills", null, 0, -1, Assistant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES,
			!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAssistant_MaximumHoursTotal(), ecorePackage.getEInt(),
			"maximumHoursTotal", "0", 0, 1, Assistant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE,
			!IS_DERIVED, IS_ORDERED);
		initEReference(getAssistant_BlockedDates(), this.getDay(),  null, 
			"blockedDates", null, 0, -1, Assistant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
			!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
				
		initEClass(tutorialEClass, Tutorial.class, "Tutorial", !IS_ABSTRACT, !IS_INTERFACE,
			IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTutorial_GivenBy(), this.getAssistant(),  null, 
			"givenBy", null, 0, 1, Tutorial.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
			!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTutorial_Duration(), ecorePackage.getEInt(),
			"duration", "0", 0, 1, Tutorial.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE,
			!IS_DERIVED, IS_ORDERED);
		initEReference(getTutorial_Timeslot(), this.getTimeslot(),  null, 
			"timeslot", null, 0, 1, Tutorial.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
			!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTutorial_Lecturer(), this.getLecturer(),  null, 
			"lecturer", null, 0, 1, Tutorial.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
			!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTutorial_SkillType(), ecorePackage.getEString(),
			"skillType", null, 0, 1, Tutorial.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE,
			!IS_DERIVED, IS_ORDERED);
		initEAttribute(getTutorial_Type(), ecorePackage.getEString(),
			"type", null, 0, 1, Tutorial.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE,
			!IS_DERIVED, IS_ORDERED);
		initEAttribute(getTutorial_Campus(), ecorePackage.getEString(),
			"campus", null, 0, 1, Tutorial.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE,
			!IS_DERIVED, IS_ORDERED);
		initEAttribute(getTutorial_RequiredNumberOfTas(), ecorePackage.getEInt(),
			"requiredNumberOfTas", "0", 0, 1, Tutorial.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE,
			!IS_DERIVED, IS_ORDERED);
		initEReference(getTutorial_Weeks(), this.getWeek(),  null, 
			"weeks", null, 0, -1, Tutorial.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
			!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
				
		initEClass(skillEClass, Skill.class, "Skill", !IS_ABSTRACT, !IS_INTERFACE,
			IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSkill_Preference(), ecorePackage.getEInt(),
			"preference", "0", 0, 1, Skill.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE,
			!IS_DERIVED, IS_ORDERED);
		
		initEClass(timeslotEClass, Timeslot.class, "Timeslot", !IS_ABSTRACT, !IS_INTERFACE,
			IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTimeslot_Id(), ecorePackage.getEInt(),
			"id", "0", 0, 1, Timeslot.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE,
			!IS_DERIVED, IS_ORDERED);
		initEReference(getTimeslot_Day(), this.getDay(), this.getDay_Timeslots(), 
			"day", null, 0, 1, Timeslot.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
			!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
				
		initEClass(lecturerEClass, Lecturer.class, "Lecturer", !IS_ABSTRACT, !IS_INTERFACE,
			IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLecturer_Tutorials(), this.getTutorial(),  null, 
			"tutorials", null, 0, -1, Lecturer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
			!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLecturer_SkillTypeName(), ecorePackage.getEString(),
			"skillTypeName", null, 0, 1, Lecturer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE,
			!IS_DERIVED, IS_ORDERED);
		initEAttribute(getLecturer_MaximumNumberOfTas(), ecorePackage.getEInt(),
			"maximumNumberOfTas", "0", 0, 1, Lecturer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE,
			!IS_DERIVED, IS_ORDERED);
		
		initEClass(dayEClass, Day.class, "Day", !IS_ABSTRACT, !IS_INTERFACE,
			IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDay_Timeslots(), this.getTimeslot(), this.getTimeslot_Day(), 
			"timeslots", null, 0, -1, Day.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
			!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDay_Week(), this.getWeek(), this.getWeek_Days(), 
			"week", null, 0, 1, Day.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
			!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
				
		initEClass(weekEClass, Week.class, "Week", !IS_ABSTRACT, !IS_INTERFACE,
			IS_GENERATED_INSTANCE_CLASS);
		initEReference(getWeek_Days(), this.getDay(), this.getDay_Week(), 
			"days", null, 0, -1, Week.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
			!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
				
		initEClass(moduleEClass, Module.class, "Module", !IS_ABSTRACT, !IS_INTERFACE,
			IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getModule_Code(), ecorePackage.getEString(),
			"code", null, 0, 1, Module.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE,
			!IS_DERIVED, IS_ORDERED);
		initEReference(getModule_Lecturer(), this.getLecturer(),  null, 
			"lecturer", null, 0, 1, Module.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
			!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModule_Tutorials(), this.getTutorial(),  null, 
			"tutorials", null, 0, -1, Module.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES,
			!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getModule_MaximumNumberOfTas(), ecorePackage.getEInt(),
			"maximumNumberOfTas", "0", 0, 1, Module.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE,
			!IS_DERIVED, IS_ORDERED);
		
		
		// Initialize enums and add enum literals
		
		// Initialize data types
		
		// Create resource
		createResource(eNS_URI);
	}

} 

