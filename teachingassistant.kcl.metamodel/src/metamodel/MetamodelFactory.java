package metamodel;

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

import org.eclipse.emf.ecore.EFactory;

public interface MetamodelFactory extends EFactory {

	MetamodelFactory eINSTANCE = metamodel.impl.MetamodelFactoryImpl.init();
	
	Department createDepartment();
	
	Assistant createAssistant();
	
	Tutorial createTutorial();
	
	Skill createSkill();
	
	Timeslot createTimeslot();
	
	Lecturer createLecturer();
	
	Day createDay();
	
	Week createWeek();
	
	Module createModule();
	
	
	MetamodelPackage getMetamodelPackage();

}
