package metamodel;

import metamodel.MetamodelPackage;

import org.emoflon.smartemf.runtime.notification.SmartEMFNotification;
import org.emoflon.smartemf.runtime.SmartObject;
import org.emoflon.smartemf.runtime.collections.*;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

public interface Tutorial extends EObject, metamodel.NamedElement {
	
    public java.lang.String getName();
    
    public void setName(java.lang.String value);
    
    public metamodel.Assistant getGivenBy();
    
    public void setGivenBy(metamodel.Assistant value);
    
    public int getDuration();
    
    public void setDuration(int value);
    
    public metamodel.Timeslot getTimeslot();
    
    public void setTimeslot(metamodel.Timeslot value);
    
    public metamodel.Lecturer getLecturer();
    
    public void setLecturer(metamodel.Lecturer value);
    
    public java.lang.String getSkillType();
    
    public void setSkillType(java.lang.String value);
    
    public java.lang.String getType();
    
    public void setType(java.lang.String value);
    
    public java.lang.String getCampus();
    
    public void setCampus(java.lang.String value);
    
    public int getRequiredNumberOfTas();
    
    public void setRequiredNumberOfTas(int value);
    
    public LinkedSmartESet<metamodel.Week> getWeeks();
    
    public void setWeeks(LinkedSmartESet<metamodel.Week> value);
    

}
