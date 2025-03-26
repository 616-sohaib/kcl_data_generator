package metamodel;

import metamodel.MetamodelPackage;

import org.emoflon.smartemf.runtime.notification.SmartEMFNotification;
import org.emoflon.smartemf.runtime.SmartObject;
import org.emoflon.smartemf.runtime.collections.*;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

public interface Day extends EObject, metamodel.NamedElement {
	
    public java.lang.String getName();
    
    public void setName(java.lang.String value);
    
    public LinkedSmartESet<metamodel.Timeslot> getTimeslots();
    
    public void setTimeslots(LinkedSmartESet<metamodel.Timeslot> value);
    
    public metamodel.Week getWeek();
    
    public void setWeek(metamodel.Week value);
    

}
