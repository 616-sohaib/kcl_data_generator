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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

public class MetamodelFactoryImpl extends EFactoryImpl implements metamodel.MetamodelFactory {

	public static metamodel.MetamodelFactory init() {
		try {
			MetamodelFactory theMetamodelFactory = (MetamodelFactory) EPackage.Registry.INSTANCE
					.getEFactory(MetamodelPackage.eNS_URI);
			if (theMetamodelFactory != null) {
				return theMetamodelFactory;
			}
		} catch (java.lang.Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new MetamodelFactoryImpl();
	}

	public MetamodelFactoryImpl() {
		super();
	}

	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
		case MetamodelPackage.DEPARTMENT:
			return createDepartment();
		case MetamodelPackage.ASSISTANT:
			return createAssistant();
		case MetamodelPackage.TUTORIAL:
			return createTutorial();
		case MetamodelPackage.SKILL:
			return createSkill();
		case MetamodelPackage.TIMESLOT:
			return createTimeslot();
		case MetamodelPackage.LECTURER:
			return createLecturer();
		case MetamodelPackage.DAY:
			return createDay();
		case MetamodelPackage.WEEK:
			return createWeek();
		case MetamodelPackage.MODULE:
			return createModule();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}
	
	
	@Override
	public metamodel.Department createDepartment() {
		DepartmentImpl department = new DepartmentImpl();
		return department;
	}
	@Override
	public metamodel.Assistant createAssistant() {
		AssistantImpl assistant = new AssistantImpl();
		return assistant;
	}
	@Override
	public metamodel.Tutorial createTutorial() {
		TutorialImpl tutorial = new TutorialImpl();
		return tutorial;
	}
	@Override
	public metamodel.Skill createSkill() {
		SkillImpl skill = new SkillImpl();
		return skill;
	}
	@Override
	public metamodel.Timeslot createTimeslot() {
		TimeslotImpl timeslot = new TimeslotImpl();
		return timeslot;
	}
	@Override
	public metamodel.Lecturer createLecturer() {
		LecturerImpl lecturer = new LecturerImpl();
		return lecturer;
	}
	@Override
	public metamodel.Day createDay() {
		DayImpl day = new DayImpl();
		return day;
	}
	@Override
	public metamodel.Week createWeek() {
		WeekImpl week = new WeekImpl();
		return week;
	}
	@Override
	public metamodel.Module createModule() {
		ModuleImpl module = new ModuleImpl();
		return module;
	}
	

	@Override
	public MetamodelPackage getMetamodelPackage() {
	return (MetamodelPackage) getEPackage();
	}
} 
