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

public class DayImpl extends SmartObject implements metamodel.Day {

    protected java.lang.String name = null;
    protected LinkedSmartESet<metamodel.Timeslot> timeslots = new LinkedSmartESet<metamodel.Timeslot>(this, MetamodelPackage.Literals.DAY__TIMESLOTS);
    protected metamodel.Week week = null;
	
	protected DayImpl() {
		super(MetamodelPackage.Literals.DAY);
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
    public LinkedSmartESet<metamodel.Timeslot> getTimeslots() {
    	return this.timeslots;
    }
    
    @Override
    public void setTimeslots(LinkedSmartESet<metamodel.Timeslot> value) {
    	throw new UnsupportedOperationException("Set methods for SmartEMF collections are not supported.");
    }
    
    private void addTimeslotsAsInverse(metamodel.Timeslot value) {
    	if(this.timeslots.addInternal(value, false) == NotifyStatus.SUCCESS_NO_NOTIFICATION) {
    sendNotification(SmartEMFNotification.createAddNotification(this, MetamodelPackage.Literals.DAY__TIMESLOTS, value, -1));
    	} 
    }
    
    private void removeTimeslotsAsInverse(metamodel.Timeslot value) {
    	timeslots.removeInternal(value, false, true);
    }
    
    @Override
    public metamodel.Week getWeek() {
    	return this.week;
    }
    
    @Override
    public void setWeek(metamodel.Week value) {
    	
    	Object oldValue = this.week;
    	
    	if(value == null && oldValue == null)
    		return;
    		
    	if(value != null && value.equals(oldValue))
    		return;
    		
    	
    	
    		        this.week = value;
    		        
    	
    	
    	        	sendNotification(SmartEMFNotification.createSetNotification(this, MetamodelPackage.Literals.DAY__WEEK, oldValue, value, -1));
    	        	
    	
    	        	if(oldValue != null) {
    	        		((SmartObject) oldValue).eInverseRemove(this, MetamodelPackage.Literals.WEEK__DAYS);
    	        	}
    	        	if(value != null) {
    	        		((SmartObject) value).eInverseAdd(this, MetamodelPackage.Literals.WEEK__DAYS);
    	        	}
    }
    
    private void setWeekAsInverse(metamodel.Week value) {
			    
			    Object oldValue = this.week;
			    
			    if(value == null && oldValue == null)
			    	return;
			    	
			    if(value != null && value.equals(oldValue))
			    	return;
			    	
			    
			    
			    	        this.week = value;
			    	        
			    
			    
			            	sendNotification(SmartEMFNotification.createSetNotification(this, MetamodelPackage.Literals.DAY__WEEK, oldValue, value, -1));
			            	
    }

    @Override
    public void eSet(EStructuralFeature eFeature, Object newValue){
    	if (MetamodelPackage.Literals.NAMED_ELEMENT__NAME.equals(eFeature)) {
    		setName((java.lang.String) newValue); 
    		return;
    	}
    	if (MetamodelPackage.Literals.DAY__TIMESLOTS.equals(eFeature)) {
    		setTimeslots((LinkedSmartESet<metamodel.Timeslot>) newValue); 
    		return;
    	}
    	if (MetamodelPackage.Literals.DAY__WEEK.equals(eFeature)) {
    		setWeek((metamodel.Week) newValue); 
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
    	if (MetamodelPackage.Literals.DAY__TIMESLOTS.equals(eFeature)) {
    		getTimeslots().clear(); 
    		return;
    	}
    	if (MetamodelPackage.Literals.DAY__WEEK.equals(eFeature)) {
    		setWeek((metamodel.Week)null); 
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
		}
		b.append(")");
		return b.toString();
    }

 	@Override
    public Object eGet(EStructuralFeature eFeature){
    	if (MetamodelPackage.Literals.NAMED_ELEMENT__NAME.equals(eFeature))
    		return getName();
    	if (MetamodelPackage.Literals.DAY__TIMESLOTS.equals(eFeature))
    		return getTimeslots();
    	if (MetamodelPackage.Literals.DAY__WEEK.equals(eFeature))
    		return getWeek();
    	return eDynamicGet(eFeature);
    }

    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType){
    	throw new UnsupportedOperationException("This method has been deactivated since it is not always safe to use.");
    }
    
    @Override
    public void eInverseAdd(Object otherEnd, EStructuralFeature feature) {
if (MetamodelPackage.Literals.DAY__TIMESLOTS.equals(feature)) {
	addTimeslotsAsInverse((metamodel.Timeslot) otherEnd);
 	return;
			        }	
if (MetamodelPackage.Literals.DAY__WEEK.equals(feature)) {
setWeekAsInverse((metamodel.Week) otherEnd); 
 	return;
			        }	
	    if(feature == null)
	    	return;
	    	
    	eDynamicInverseAdd(otherEnd, feature);
	    	}
    	
    @Override
	    	public void eInverseRemove(Object otherEnd, EStructuralFeature feature) {
if (MetamodelPackage.Literals.DAY__TIMESLOTS.equals(feature)) {
	removeTimeslotsAsInverse((metamodel.Timeslot) otherEnd);
 	return;
			        }
if (MetamodelPackage.Literals.DAY__WEEK.equals(feature)) {
setWeekAsInverse(null); 
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
