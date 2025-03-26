package metamodel;

import metamodel.MetamodelPackage;

import org.emoflon.smartemf.runtime.notification.SmartEMFNotification;
import org.emoflon.smartemf.runtime.SmartObject;
import org.emoflon.smartemf.runtime.collections.*;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

public interface Assistant extends EObject, metamodel.NamedElement {
	
    public java.lang.String getName();
    
    public void setName(java.lang.String value);
    
    public int getMinimumHoursPerWeek();
    
    public void setMinimumHoursPerWeek(int value);
    
    public int getMaximumHoursPerWeek();
    
    public void setMaximumHoursPerWeek(int value);
    
    public int getMaximumDaysPerWeek();
    
    public void setMaximumDaysPerWeek(int value);
    
    public LinkedSmartESet<metamodel.Skill> getSkills();
    
    public void setSkills(LinkedSmartESet<metamodel.Skill> value);
    
    public int getMaximumHoursTotal();
    
    public void setMaximumHoursTotal(int value);
    
    public LinkedSmartESet<metamodel.Day> getBlockedDates();
    
    public void setBlockedDates(LinkedSmartESet<metamodel.Day> value);
    

}
