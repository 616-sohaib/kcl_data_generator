package metamodel;

import metamodel.MetamodelPackage;

import org.emoflon.smartemf.runtime.notification.SmartEMFNotification;
import org.emoflon.smartemf.runtime.SmartObject;
import org.emoflon.smartemf.runtime.collections.*;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

public interface Lecturer extends EObject, metamodel.NamedElement {
	
    public java.lang.String getName();
    
    public void setName(java.lang.String value);
    
    public LinkedSmartESet<metamodel.Tutorial> getTutorials();
    
    public void setTutorials(LinkedSmartESet<metamodel.Tutorial> value);
    
    public java.lang.String getSkillTypeName();
    
    public void setSkillTypeName(java.lang.String value);
    
    public int getMaximumNumberOfTas();
    
    public void setMaximumNumberOfTas(int value);
    

}
