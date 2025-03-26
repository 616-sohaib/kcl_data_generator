package metamodel.impl;

import metamodel.MetamodelPackage;
import metamodel.MetamodelPackage;

import org.emoflon.smartemf.runtime.*;
import org.emoflon.smartemf.runtime.collections.*;
import org.emoflon.smartemf.persistence.SmartEMFResource;
import org.emoflon.smartemf.runtime.notification.SmartEMFNotification;
import org.emoflon.smartemf.runtime.notification.NotifyStatus;

import java.util.function.Consumer;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;

public class AssistantImpl extends SmartObject implements metamodel.Assistant {

    protected java.lang.String name = null;
    protected int minimumHoursPerWeek = 0;
    protected int maximumHoursPerWeek = 0;
    protected int maximumDaysPerWeek = 0;
    protected LinkedSmartESet<metamodel.Skill> skills = new LinkedSmartESet<metamodel.Skill>(this, MetamodelPackage.Literals.ASSISTANT__SKILLS);
    protected int maximumHoursTotal = 0;
    protected LinkedSmartESet<metamodel.Day> blockedDates = new LinkedSmartESet<metamodel.Day>(this, MetamodelPackage.Literals.ASSISTANT__BLOCKED_DATES);
	
	protected AssistantImpl() {
		super(MetamodelPackage.Literals.ASSISTANT);
	}
	
    
    @Override
    public java.lang.String getName() {
    	return this.name;
    }
    
    @Override
    public void setName(java.lang.String value) {
    	Object oldValue = this.name;
    	this.name = value;
    	
    	        	sendNotification(SmartEMFNotification.createSetNotification(this, MetamodelPackage.Literals.NAMED_ELEMENT__NAME, oldValue, value, -1));
    }
    
    
    @Override
    public int getMinimumHoursPerWeek() {
    	return this.minimumHoursPerWeek;
    }
    
    @Override
    public void setMinimumHoursPerWeek(int value) {
    	Object oldValue = this.minimumHoursPerWeek;
    	this.minimumHoursPerWeek = value;
    	
    	        	sendNotification(SmartEMFNotification.createSetNotification(this, MetamodelPackage.Literals.ASSISTANT__MINIMUM_HOURS_PER_WEEK, oldValue, value, -1));
    }
    
    
    @Override
    public int getMaximumHoursPerWeek() {
    	return this.maximumHoursPerWeek;
    }
    
    @Override
    public void setMaximumHoursPerWeek(int value) {
    	Object oldValue = this.maximumHoursPerWeek;
    	this.maximumHoursPerWeek = value;
    	
    	        	sendNotification(SmartEMFNotification.createSetNotification(this, MetamodelPackage.Literals.ASSISTANT__MAXIMUM_HOURS_PER_WEEK, oldValue, value, -1));
    }
    
    
    @Override
    public int getMaximumDaysPerWeek() {
    	return this.maximumDaysPerWeek;
    }
    
    @Override
    public void setMaximumDaysPerWeek(int value) {
    	Object oldValue = this.maximumDaysPerWeek;
    	this.maximumDaysPerWeek = value;
    	
    	        	sendNotification(SmartEMFNotification.createSetNotification(this, MetamodelPackage.Literals.ASSISTANT__MAXIMUM_DAYS_PER_WEEK, oldValue, value, -1));
    }
    
    
    @Override
    public LinkedSmartESet<metamodel.Skill> getSkills() {
    	return this.skills;
    }
    
    @Override
    public void setSkills(LinkedSmartESet<metamodel.Skill> value) {
    	throw new UnsupportedOperationException("Set methods for SmartEMF collections are not supported.");
    }
    
    
    @Override
    public int getMaximumHoursTotal() {
    	return this.maximumHoursTotal;
    }
    
    @Override
    public void setMaximumHoursTotal(int value) {
    	Object oldValue = this.maximumHoursTotal;
    	this.maximumHoursTotal = value;
    	
    	        	sendNotification(SmartEMFNotification.createSetNotification(this, MetamodelPackage.Literals.ASSISTANT__MAXIMUM_HOURS_TOTAL, oldValue, value, -1));
    }
    
    
    @Override
    public LinkedSmartESet<metamodel.Day> getBlockedDates() {
    	return this.blockedDates;
    }
    
    @Override
    public void setBlockedDates(LinkedSmartESet<metamodel.Day> value) {
    	throw new UnsupportedOperationException("Set methods for SmartEMF collections are not supported.");
    }
    

    @Override
    public void eSet(EStructuralFeature eFeature, Object newValue){
    	if (MetamodelPackage.Literals.NAMED_ELEMENT__NAME.equals(eFeature)) {
    		setName((java.lang.String) newValue); 
    		return;
    	}
    	if (MetamodelPackage.Literals.ASSISTANT__MINIMUM_HOURS_PER_WEEK.equals(eFeature)) {
    		setMinimumHoursPerWeek((int) newValue); 
    		return;
    	}
    	if (MetamodelPackage.Literals.ASSISTANT__MAXIMUM_HOURS_PER_WEEK.equals(eFeature)) {
    		setMaximumHoursPerWeek((int) newValue); 
    		return;
    	}
    	if (MetamodelPackage.Literals.ASSISTANT__MAXIMUM_DAYS_PER_WEEK.equals(eFeature)) {
    		setMaximumDaysPerWeek((int) newValue); 
    		return;
    	}
    	if (MetamodelPackage.Literals.ASSISTANT__SKILLS.equals(eFeature)) {
    		setSkills((LinkedSmartESet<metamodel.Skill>) newValue); 
    		return;
    	}
    	if (MetamodelPackage.Literals.ASSISTANT__MAXIMUM_HOURS_TOTAL.equals(eFeature)) {
    		setMaximumHoursTotal((int) newValue); 
    		return;
    	}
    	if (MetamodelPackage.Literals.ASSISTANT__BLOCKED_DATES.equals(eFeature)) {
    		setBlockedDates((LinkedSmartESet<metamodel.Day>) newValue); 
    		return;
    	}
    	eDynamicSet(eFeature, newValue);
    }
    
    @Override
    public void eUnset(EStructuralFeature eFeature){
    	if (MetamodelPackage.Literals.NAMED_ELEMENT__NAME.equals(eFeature)) {
    		setName((java.lang.String)null); 
    		return;
    	}
    	if (MetamodelPackage.Literals.ASSISTANT__MINIMUM_HOURS_PER_WEEK.equals(eFeature)) {
    		setMinimumHoursPerWeek((int)0); 
    		return;
    	}
    	if (MetamodelPackage.Literals.ASSISTANT__MAXIMUM_HOURS_PER_WEEK.equals(eFeature)) {
    		setMaximumHoursPerWeek((int)0); 
    		return;
    	}
    	if (MetamodelPackage.Literals.ASSISTANT__MAXIMUM_DAYS_PER_WEEK.equals(eFeature)) {
    		setMaximumDaysPerWeek((int)0); 
    		return;
    	}
    	if (MetamodelPackage.Literals.ASSISTANT__SKILLS.equals(eFeature)) {
    		getSkills().clear(); 
    		return;
    	}
    	if (MetamodelPackage.Literals.ASSISTANT__MAXIMUM_HOURS_TOTAL.equals(eFeature)) {
    		setMaximumHoursTotal((int)0); 
    		return;
    	}
    	if (MetamodelPackage.Literals.ASSISTANT__BLOCKED_DATES.equals(eFeature)) {
    		getBlockedDates().clear(); 
    		return;
    	}
    	eDynamicUnset(eFeature);
    }

    @Override
    public String toString(){
		StringBuilder b = new StringBuilder();
		b.append(super.toString());
		b.append(" (");
		if (SmartEMFConfig.simpleStringRepresentations()) {
			b.append(getName());
		} else {
			b.append("name: ");
			b.append(getName());
			b.append(", ");
			b.append("minimumHoursPerWeek: ");
			b.append(getMinimumHoursPerWeek());b.append(", ");
			b.append("maximumHoursPerWeek: ");
			b.append(getMaximumHoursPerWeek());b.append(", ");
			b.append("maximumDaysPerWeek: ");
			b.append(getMaximumDaysPerWeek());b.append(", ");
			b.append("maximumHoursTotal: ");
			b.append(getMaximumHoursTotal());
		}
		b.append(")");
		return b.toString();
    }

 	@Override
    public Object eGet(EStructuralFeature eFeature){
    	if (MetamodelPackage.Literals.NAMED_ELEMENT__NAME.equals(eFeature))
    		return getName();
    	if (MetamodelPackage.Literals.ASSISTANT__MINIMUM_HOURS_PER_WEEK.equals(eFeature))
    		return getMinimumHoursPerWeek();
    	if (MetamodelPackage.Literals.ASSISTANT__MAXIMUM_HOURS_PER_WEEK.equals(eFeature))
    		return getMaximumHoursPerWeek();
    	if (MetamodelPackage.Literals.ASSISTANT__MAXIMUM_DAYS_PER_WEEK.equals(eFeature))
    		return getMaximumDaysPerWeek();
    	if (MetamodelPackage.Literals.ASSISTANT__SKILLS.equals(eFeature))
    		return getSkills();
    	if (MetamodelPackage.Literals.ASSISTANT__MAXIMUM_HOURS_TOTAL.equals(eFeature))
    		return getMaximumHoursTotal();
    	if (MetamodelPackage.Literals.ASSISTANT__BLOCKED_DATES.equals(eFeature))
    		return getBlockedDates();
    	return eDynamicGet(eFeature);
    }

    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType){
    	throw new UnsupportedOperationException("This method has been deactivated since it is not always safe to use.");
    }
    
    @Override
    public void eInverseAdd(Object otherEnd, EStructuralFeature feature) {
	    if(feature == null)
	    	return;
	    	
    	eDynamicInverseAdd(otherEnd, feature);
	    	}
    	
    @Override
	    	public void eInverseRemove(Object otherEnd, EStructuralFeature feature) {
	    if(feature == null)
	    	return;
	    		    		
    	eDynamicInverseRemove(otherEnd, feature);
	    	}
    
    @Override
    /**
    * This method sets the resource and generates REMOVING_ADAPTER and ADD notifications
    */
    protected void setResourceOfContainments(Consumer<SmartObject> setResourceCall) {
    	for(Object obj : getSkills()) {
    		setResourceCall.accept(((SmartObject) obj));
	    		}
	    	}
	    	
	    	@Override
	    	/**
	    	* This method sets the resource and only generates REMOVING_ADAPTER notifications (no ADD messages)
	    	*/
    protected void setResourceOfContainmentsSilently(Resource r) { 		
    	for(Object obj : getSkills()) {
    		((SmartObject) obj).setResourceSilently(r);
	    		}
	    	}
}
