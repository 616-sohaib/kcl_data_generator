package metamodel;

import metamodel.MetamodelPackage;

import org.emoflon.smartemf.runtime.notification.SmartEMFNotification;
import org.emoflon.smartemf.runtime.SmartObject;
import org.emoflon.smartemf.runtime.collections.*;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

public interface Module extends EObject, metamodel.NamedElement {
	
    public java.lang.String getName();
    
    public void setName(java.lang.String value);
    
    public java.lang.String getCode();
    
    public void setCode(java.lang.String value);
    
    public metamodel.Lecturer getLecturer();
    
    public void setLecturer(metamodel.Lecturer value);
    
    public LinkedSmartESet<metamodel.Tutorial> getTutorials();
    
    public void setTutorials(LinkedSmartESet<metamodel.Tutorial> value);
    
    public int getMaximumNumberOfTas();
    
    public void setMaximumNumberOfTas(int value);
    

}
