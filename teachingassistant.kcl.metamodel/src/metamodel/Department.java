package metamodel;

import metamodel.MetamodelPackage;

import org.emoflon.smartemf.runtime.notification.SmartEMFNotification;
import org.emoflon.smartemf.runtime.SmartObject;
import org.emoflon.smartemf.runtime.collections.*;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

public interface Department extends EObject, metamodel.NamedElement {
	
    public java.lang.String getName();
    
    public void setName(java.lang.String value);
    
    public LinkedSmartESet<metamodel.Assistant> getAssistants();
    
    public void setAssistants(LinkedSmartESet<metamodel.Assistant> value);
    
    public LinkedSmartESet<metamodel.Tutorial> getTutorials();
    
    public void setTutorials(LinkedSmartESet<metamodel.Tutorial> value);
    
    public LinkedSmartESet<metamodel.Timeslot> getTimeslots();
    
    public void setTimeslots(LinkedSmartESet<metamodel.Timeslot> value);
    
    public LinkedSmartESet<metamodel.Lecturer> getLecturers();
    
    public void setLecturers(LinkedSmartESet<metamodel.Lecturer> value);
    
    public LinkedSmartESet<metamodel.Day> getDays();
    
    public void setDays(LinkedSmartESet<metamodel.Day> value);
    
    public LinkedSmartESet<metamodel.Week> getWeeks();
    
    public void setWeeks(LinkedSmartESet<metamodel.Week> value);
    
    public LinkedSmartESet<metamodel.Module> getModules();
    
    public void setModules(LinkedSmartESet<metamodel.Module> value);
    

}
