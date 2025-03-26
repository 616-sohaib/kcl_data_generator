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

public class TimeslotImpl extends SmartObject implements metamodel.Timeslot {

    protected java.lang.String name = null;
    protected int id = 0;
    protected metamodel.Day day = null;
	
	protected TimeslotImpl() {
		super(MetamodelPackage.Literals.TIMESLOT);
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
    public int getId() {
    	return this.id;
    }
    
    @Override
    public void setId(int value) {
    	Object oldValue = this.id;
    	this.id = value;
    	
    	        	sendNotification(SmartEMFNotification.createSetNotification(this, MetamodelPackage.Literals.TIMESLOT__ID, oldValue, value, -1));
    }
    
    
    @Override
    public metamodel.Day getDay() {
    	return this.day;
    }
    
    @Override
    public void setDay(metamodel.Day value) {
    	
    	Object oldValue = this.day;
    	
    	if(value == null && oldValue == null)
    		return;
    		
    	if(value != null && value.equals(oldValue))
    		return;
    		
    	
    	
    		        this.day = value;
    		        
    	
    	
    	        	sendNotification(SmartEMFNotification.createSetNotification(this, MetamodelPackage.Literals.TIMESLOT__DAY, oldValue, value, -1));
    	        	
    	
    	        	if(oldValue != null) {
    	        		((SmartObject) oldValue).eInverseRemove(this, MetamodelPackage.Literals.DAY__TIMESLOTS);
    	        	}
    	        	if(value != null) {
    	        		((SmartObject) value).eInverseAdd(this, MetamodelPackage.Literals.DAY__TIMESLOTS);
    	        	}
    }
    
    private void setDayAsInverse(metamodel.Day value) {
			    
			    Object oldValue = this.day;
			    
			    if(value == null && oldValue == null)
			    	return;
			    	
			    if(value != null && value.equals(oldValue))
			    	return;
			    	
			    
			    
			    	        this.day = value;
			    	        
			    
			    
			            	sendNotification(SmartEMFNotification.createSetNotification(this, MetamodelPackage.Literals.TIMESLOT__DAY, oldValue, value, -1));
			            	
    }

    @Override
    public void eSet(EStructuralFeature eFeature, Object newValue){
    	if (MetamodelPackage.Literals.NAMED_ELEMENT__NAME.equals(eFeature)) {
    		setName((java.lang.String) newValue); 
    		return;
    	}
    	if (MetamodelPackage.Literals.TIMESLOT__ID.equals(eFeature)) {
    		setId((int) newValue); 
    		return;
    	}
    	if (MetamodelPackage.Literals.TIMESLOT__DAY.equals(eFeature)) {
    		setDay((metamodel.Day) newValue); 
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
    	if (MetamodelPackage.Literals.TIMESLOT__ID.equals(eFeature)) {
    		setId((int)0); 
    		return;
    	}
    	if (MetamodelPackage.Literals.TIMESLOT__DAY.equals(eFeature)) {
    		setDay((metamodel.Day)null); 
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
			b.append("id: ");
			b.append(getId());
		}
		b.append(")");
		return b.toString();
    }

 	@Override
    public Object eGet(EStructuralFeature eFeature){
    	if (MetamodelPackage.Literals.NAMED_ELEMENT__NAME.equals(eFeature))
    		return getName();
    	if (MetamodelPackage.Literals.TIMESLOT__ID.equals(eFeature))
    		return getId();
    	if (MetamodelPackage.Literals.TIMESLOT__DAY.equals(eFeature))
    		return getDay();
    	return eDynamicGet(eFeature);
    }

    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType){
    	throw new UnsupportedOperationException("This method has been deactivated since it is not always safe to use.");
    }
    
    @Override
    public void eInverseAdd(Object otherEnd, EStructuralFeature feature) {
if (MetamodelPackage.Literals.TIMESLOT__DAY.equals(feature)) {
setDayAsInverse((metamodel.Day) otherEnd); 
 	return;
			        }	
	    if(feature == null)
	    	return;
	    	
    	eDynamicInverseAdd(otherEnd, feature);
	    	}
    	
    @Override
	    	public void eInverseRemove(Object otherEnd, EStructuralFeature feature) {
if (MetamodelPackage.Literals.TIMESLOT__DAY.equals(feature)) {
setDayAsInverse(null); 
 	return;
			        }
	    if(feature == null)
	    	return;
	    		    		
    	eDynamicInverseRemove(otherEnd, feature);
	    	}
    
    @Override
    /**
    * This method sets the resource and generates REMOVING_ADAPTER and ADD notifications
    */
    protected void setResourceOfContainments(Consumer<SmartObject> setResourceCall) {
	    	}
	    	
	    	@Override
	    	/**
	    	* This method sets the resource and only generates REMOVING_ADAPTER notifications (no ADD messages)
	    	*/
    protected void setResourceOfContainmentsSilently(Resource r) { 		
	    	}
}
