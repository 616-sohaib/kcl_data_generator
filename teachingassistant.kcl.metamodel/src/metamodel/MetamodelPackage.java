package metamodel;

import java.lang.String;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EEnum;


import org.emoflon.smartemf.runtime.SmartPackage;

public interface MetamodelPackage extends SmartPackage {

	String eNAME = "metamodel";
	String eNS_URI = "platform:/resource/teachingassistant.kcl.metamodel/model/Metamodel.ecore";
	String eNS_PREFIX = "teachingassistant.kcl.metamodel";

	MetamodelPackage eINSTANCE = metamodel.impl.MetamodelPackageImpl.init();

	int NAMED_ELEMENT = 0;
	int NAMED_ELEMENT__NAME = 0;
	int NAMED_ELEMENT_FEATURE_COUNT = 1;
	int NAMED_ELEMENT_OPERATION_COUNT = 0;
	
	int DEPARTMENT = 1;
	int DEPARTMENT__ASSISTANTS = 1;
	int DEPARTMENT__TUTORIALS = 2;
	int DEPARTMENT__TIMESLOTS = 3;
	int DEPARTMENT__LECTURERS = 4;
	int DEPARTMENT__DAYS = 5;
	int DEPARTMENT__WEEKS = 6;
	int DEPARTMENT__MODULES = 7;
	int DEPARTMENT_FEATURE_COUNT = 8;
	int DEPARTMENT_OPERATION_COUNT = 0;
	
	int ASSISTANT = 2;
	int ASSISTANT__MINIMUM_HOURS_PER_WEEK = 8;
	int ASSISTANT__MAXIMUM_HOURS_PER_WEEK = 9;
	int ASSISTANT__MAXIMUM_DAYS_PER_WEEK = 10;
	int ASSISTANT__SKILLS = 11;
	int ASSISTANT__MAXIMUM_HOURS_TOTAL = 12;
	int ASSISTANT__BLOCKED_DATES = 13;
	int ASSISTANT_FEATURE_COUNT = 7;
	int ASSISTANT_OPERATION_COUNT = 0;
	
	int TUTORIAL = 3;
	int TUTORIAL__GIVEN_BY = 14;
	int TUTORIAL__DURATION = 15;
	int TUTORIAL__TIMESLOT = 16;
	int TUTORIAL__LECTURER = 17;
	int TUTORIAL__SKILL_TYPE = 18;
	int TUTORIAL__TYPE = 19;
	int TUTORIAL__CAMPUS = 20;
	int TUTORIAL__REQUIRED_NUMBER_OF_TAS = 21;
	int TUTORIAL__WEEKS = 22;
	int TUTORIAL_FEATURE_COUNT = 10;
	int TUTORIAL_OPERATION_COUNT = 0;
	
	int SKILL = 4;
	int SKILL__PREFERENCE = 23;
	int SKILL_FEATURE_COUNT = 2;
	int SKILL_OPERATION_COUNT = 0;
	
	int TIMESLOT = 5;
	int TIMESLOT__ID = 24;
	int TIMESLOT__DAY = 25;
	int TIMESLOT_FEATURE_COUNT = 3;
	int TIMESLOT_OPERATION_COUNT = 0;
	
	int LECTURER = 6;
	int LECTURER__TUTORIALS = 26;
	int LECTURER__SKILL_TYPE_NAME = 27;
	int LECTURER__MAXIMUM_NUMBER_OF_TAS = 28;
	int LECTURER_FEATURE_COUNT = 4;
	int LECTURER_OPERATION_COUNT = 0;
	
	int DAY = 7;
	int DAY__TIMESLOTS = 29;
	int DAY__WEEK = 30;
	int DAY_FEATURE_COUNT = 3;
	int DAY_OPERATION_COUNT = 0;
	
	int WEEK = 8;
	int WEEK__DAYS = 31;
	int WEEK_FEATURE_COUNT = 2;
	int WEEK_OPERATION_COUNT = 0;
	
	int MODULE = 9;
	int MODULE__CODE = 32;
	int MODULE__LECTURER = 33;
	int MODULE__TUTORIALS = 34;
	int MODULE__MAXIMUM_NUMBER_OF_TAS = 35;
	int MODULE_FEATURE_COUNT = 5;
	int MODULE_OPERATION_COUNT = 0;
	
	

	EClass getNamedElement();
	EAttribute getNamedElement_Name();
	
	EClass getDepartment();
	EReference getDepartment_Assistants();
	EReference getDepartment_Tutorials();
	EReference getDepartment_Timeslots();
	EReference getDepartment_Lecturers();
	EReference getDepartment_Days();
	EReference getDepartment_Weeks();
	EReference getDepartment_Modules();
	
	EClass getAssistant();
	EAttribute getAssistant_MinimumHoursPerWeek();
	EAttribute getAssistant_MaximumHoursPerWeek();
	EAttribute getAssistant_MaximumDaysPerWeek();
	EReference getAssistant_Skills();
	EAttribute getAssistant_MaximumHoursTotal();
	EReference getAssistant_BlockedDates();
	
	EClass getTutorial();
	EReference getTutorial_GivenBy();
	EAttribute getTutorial_Duration();
	EReference getTutorial_Timeslot();
	EReference getTutorial_Lecturer();
	EAttribute getTutorial_SkillType();
	EAttribute getTutorial_Type();
	EAttribute getTutorial_Campus();
	EAttribute getTutorial_RequiredNumberOfTas();
	EReference getTutorial_Weeks();
	
	EClass getSkill();
	EAttribute getSkill_Preference();
	
	EClass getTimeslot();
	EAttribute getTimeslot_Id();
	EReference getTimeslot_Day();
	
	EClass getLecturer();
	EReference getLecturer_Tutorials();
	EAttribute getLecturer_SkillTypeName();
	EAttribute getLecturer_MaximumNumberOfTas();
	
	EClass getDay();
	EReference getDay_Timeslots();
	EReference getDay_Week();
	
	EClass getWeek();
	EReference getWeek_Days();
	
	EClass getModule();
	EAttribute getModule_Code();
	EReference getModule_Lecturer();
	EReference getModule_Tutorials();
	EAttribute getModule_MaximumNumberOfTas();
	
	
	metamodel.MetamodelFactory getMetamodelFactory();

	interface Literals {
		
		EClass NAMED_ELEMENT = eINSTANCE.getNamedElement();
		
		EAttribute NAMED_ELEMENT__NAME = eINSTANCE.getNamedElement_Name();
		
		EClass DEPARTMENT = eINSTANCE.getDepartment();
		
		EReference DEPARTMENT__ASSISTANTS = eINSTANCE.getDepartment_Assistants();
		
		EReference DEPARTMENT__TUTORIALS = eINSTANCE.getDepartment_Tutorials();
		
		EReference DEPARTMENT__TIMESLOTS = eINSTANCE.getDepartment_Timeslots();
		
		EReference DEPARTMENT__LECTURERS = eINSTANCE.getDepartment_Lecturers();
		
		EReference DEPARTMENT__DAYS = eINSTANCE.getDepartment_Days();
		
		EReference DEPARTMENT__WEEKS = eINSTANCE.getDepartment_Weeks();
		
		EReference DEPARTMENT__MODULES = eINSTANCE.getDepartment_Modules();
		
		EClass ASSISTANT = eINSTANCE.getAssistant();
		
		EAttribute ASSISTANT__MINIMUM_HOURS_PER_WEEK = eINSTANCE.getAssistant_MinimumHoursPerWeek();
		
		EAttribute ASSISTANT__MAXIMUM_HOURS_PER_WEEK = eINSTANCE.getAssistant_MaximumHoursPerWeek();
		
		EAttribute ASSISTANT__MAXIMUM_DAYS_PER_WEEK = eINSTANCE.getAssistant_MaximumDaysPerWeek();
		
		EReference ASSISTANT__SKILLS = eINSTANCE.getAssistant_Skills();
		
		EAttribute ASSISTANT__MAXIMUM_HOURS_TOTAL = eINSTANCE.getAssistant_MaximumHoursTotal();
		
		EReference ASSISTANT__BLOCKED_DATES = eINSTANCE.getAssistant_BlockedDates();
		
		EClass TUTORIAL = eINSTANCE.getTutorial();
		
		EReference TUTORIAL__GIVEN_BY = eINSTANCE.getTutorial_GivenBy();
		
		EAttribute TUTORIAL__DURATION = eINSTANCE.getTutorial_Duration();
		
		EReference TUTORIAL__TIMESLOT = eINSTANCE.getTutorial_Timeslot();
		
		EReference TUTORIAL__LECTURER = eINSTANCE.getTutorial_Lecturer();
		
		EAttribute TUTORIAL__SKILL_TYPE = eINSTANCE.getTutorial_SkillType();
		
		EAttribute TUTORIAL__TYPE = eINSTANCE.getTutorial_Type();
		
		EAttribute TUTORIAL__CAMPUS = eINSTANCE.getTutorial_Campus();
		
		EAttribute TUTORIAL__REQUIRED_NUMBER_OF_TAS = eINSTANCE.getTutorial_RequiredNumberOfTas();
		
		EReference TUTORIAL__WEEKS = eINSTANCE.getTutorial_Weeks();
		
		EClass SKILL = eINSTANCE.getSkill();
		
		EAttribute SKILL__PREFERENCE = eINSTANCE.getSkill_Preference();
		
		EClass TIMESLOT = eINSTANCE.getTimeslot();
		
		EAttribute TIMESLOT__ID = eINSTANCE.getTimeslot_Id();
		
		EReference TIMESLOT__DAY = eINSTANCE.getTimeslot_Day();
		
		EClass LECTURER = eINSTANCE.getLecturer();
		
		EReference LECTURER__TUTORIALS = eINSTANCE.getLecturer_Tutorials();
		
		EAttribute LECTURER__SKILL_TYPE_NAME = eINSTANCE.getLecturer_SkillTypeName();
		
		EAttribute LECTURER__MAXIMUM_NUMBER_OF_TAS = eINSTANCE.getLecturer_MaximumNumberOfTas();
		
		EClass DAY = eINSTANCE.getDay();
		
		EReference DAY__TIMESLOTS = eINSTANCE.getDay_Timeslots();
		
		EReference DAY__WEEK = eINSTANCE.getDay_Week();
		
		EClass WEEK = eINSTANCE.getWeek();
		
		EReference WEEK__DAYS = eINSTANCE.getWeek_Days();
		
		EClass MODULE = eINSTANCE.getModule();
		
		EAttribute MODULE__CODE = eINSTANCE.getModule_Code();
		
		EReference MODULE__LECTURER = eINSTANCE.getModule_Lecturer();
		
		EReference MODULE__TUTORIALS = eINSTANCE.getModule_Tutorials();
		
		EAttribute MODULE__MAXIMUM_NUMBER_OF_TAS = eINSTANCE.getModule_MaximumNumberOfTas();
		
		
		
		
	}

} 
