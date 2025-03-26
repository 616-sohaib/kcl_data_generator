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

public class TutorialImpl extends SmartObject implements metamodel.Tutorial {

    protected java.lang.String name = null;
    protected metamodel.Assistant givenBy = null;
    protected int duration = 0;
    protected metamodel.Timeslot timeslot = null;
    protected metamodel.Lecturer lecturer = null;
    protected java.lang.String skillType = null;
    protected java.lang.String type = null;
    protected java.lang.String campus = null;
    protected int requiredNumberOfTas = 0;
    protected LinkedSmartESet<metamodel.Week> weeks = new LinkedSmartESet<metamodel.Week>(this, MetamodelPackage.Literals.TUTORIAL__WEEKS);
	
	protected TutorialImpl() {
		super(MetamodelPackage.Literals.TUTORIAL);
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
    public metamodel.Assistant getGivenBy() {
    	return this.givenBy;
    }
    
    @Override
    public void setGivenBy(metamodel.Assistant value) {
    	
    	Object oldValue = this.givenBy;
    	
    	if(value == null && oldValue == null)
    		return;
    		
    	if(value != null && value.equals(oldValue))
    		return;
    		
    	
    	
    		        this.givenBy = value;
    		        
    	
    	
    	        	sendNotification(SmartEMFNotification.createSetNotification(this, MetamodelPackage.Literals.TUTORIAL__GIVEN_BY, oldValue, value, -1));
    	        	
    	        	if(MetamodelPackage.Literals.TUTORIAL__GIVEN_BY.getEOpposite() != null) {
    	        		if(oldValue != null) {
    	        			((SmartObject) oldValue).eInverseRemove(this, MetamodelPackage.Literals.TUTORIAL__GIVEN_BY.getEOpposite());
    	        		}
    	        		if(value != null) {
    	        		    ((SmartObject) value).eInverseAdd(this, MetamodelPackage.Literals.TUTORIAL__GIVEN_BY.getEOpposite());
    	        		}
    	        	}
    }
    
    
    @Override
    public int getDuration() {
    	return this.duration;
    }
    
    @Override
    public void setDuration(int value) {
    	Object oldValue = this.duration;
    	this.duration = value;
    	
    	        	sendNotification(SmartEMFNotification.createSetNotification(this, MetamodelPackage.Literals.TUTORIAL__DURATION, oldValue, value, -1));
    }
    
    
    @Override
    public metamodel.Timeslot getTimeslot() {
    	return this.timeslot;
    }
    
    @Override
    public void setTimeslot(metamodel.Timeslot value) {
    	
    	Object oldValue = this.timeslot;
    	
    	if(value == null && oldValue == null)
    		return;
    		
    	if(value != null && value.equals(oldValue))
    		return;
    		
    	
    	
    		        this.timeslot = value;
    		        
    	
    	
    	        	sendNotification(SmartEMFNotification.createSetNotification(this, MetamodelPackage.Literals.TUTORIAL__TIMESLOT, oldValue, value, -1));
    	        	
    	        	if(MetamodelPackage.Literals.TUTORIAL__TIMESLOT.getEOpposite() != null) {
    	        		if(oldValue != null) {
    	        			((SmartObject) oldValue).eInverseRemove(this, MetamodelPackage.Literals.TUTORIAL__TIMESLOT.getEOpposite());
    	        		}
    	        		if(value != null) {
    	        		    ((SmartObject) value).eInverseAdd(this, MetamodelPackage.Literals.TUTORIAL__TIMESLOT.getEOpposite());
    	        		}
    	        	}
    }
    
    
    @Override
    public metamodel.Lecturer getLecturer() {
    	return this.lecturer;
    }
    
    @Override
    public void setLecturer(metamodel.Lecturer value) {
    	
    	Object oldValue = this.lecturer;
    	
    	if(value == null && oldValue == null)
    		return;
    		
    	if(value != null && value.equals(oldValue))
    		return;
    		
    	
    	
    		        this.lecturer = value;
    		        
    	
    	
    	        	sendNotification(SmartEMFNotification.createSetNotification(this, MetamodelPackage.Literals.TUTORIAL__LECTURER, oldValue, value, -1));
    	        	
    	        	if(MetamodelPackage.Literals.TUTORIAL__LECTURER.getEOpposite() != null) {
    	        		if(oldValue != null) {
    	        			((SmartObject) oldValue).eInverseRemove(this, MetamodelPackage.Literals.TUTORIAL__LECTURER.getEOpposite());
    	        		}
    	        		if(value != null) {
    	        		    ((SmartObject) value).eInverseAdd(this, MetamodelPackage.Literals.TUTORIAL__LECTURER.getEOpposite());
    	        		}
    	        	}
    }
    
    
    @Override
    public java.lang.String getSkillType() {
    	return this.skillType;
    }
    
    @Override
    public void setSkillType(java.lang.String value) {
    	Object oldValue = this.skillType;
    	this.skillType = value;
    	
    	        	sendNotification(SmartEMFNotification.createSetNotification(this, MetamodelPackage.Literals.TUTORIAL__SKILL_TYPE, oldValue, value, -1));
    }
    
    
    @Override
    public java.lang.String getType() {
    	return this.type;
    }
    
    @Override
    public void setType(java.lang.String value) {
    	Object oldValue = this.type;
    	this.type = value;
    	
    	        	sendNotification(SmartEMFNotification.createSetNotification(this, MetamodelPackage.Literals.TUTORIAL__TYPE, oldValue, value, -1));
    }
    
    
    @Override
    public java.lang.String getCampus() {
    	return this.campus;
    }
    
    @Override
    public void setCampus(java.lang.String value) {
    	Object oldValue = this.campus;
    	this.campus = value;
    	
    	        	sendNotification(SmartEMFNotification.createSetNotification(this, MetamodelPackage.Literals.TUTORIAL__CAMPUS, oldValue, value, -1));
    }
    
    
    @Override
    public int getRequiredNumberOfTas() {
    	return this.requiredNumberOfTas;
    }
    
    @Override
    public void setRequiredNumberOfTas(int value) {
    	Object oldValue = this.requiredNumberOfTas;
    	this.requiredNumberOfTas = value;
    	
    	        	sendNotification(SmartEMFNotification.createSetNotification(this, MetamodelPackage.Literals.TUTORIAL__REQUIRED_NUMBER_OF_TAS, oldValue, value, -1));
    }
    
    
    @Override
    public LinkedSmartESet<metamodel.Week> getWeeks() {
    	return this.weeks;
    }
    
    @Override
    public void setWeeks(LinkedSmartESet<metamodel.Week> value) {
    	throw new UnsupportedOperationException("Set methods for SmartEMF collections are not supported.");
    }
    

    @Override
    public void eSet(EStructuralFeature eFeature, Object newValue){
    	if (MetamodelPackage.Literals.NAMED_ELEMENT__NAME.equals(eFeature)) {
    		setName((java.lang.String) newValue); 
    		return;
    	}
    	if (MetamodelPackage.Literals.TUTORIAL__GIVEN_BY.equals(eFeature)) {
    		setGivenBy((metamodel.Assistant) newValue); 
    		return;
    	}
    	if (MetamodelPackage.Literals.TUTORIAL__DURATION.equals(eFeature)) {
    		setDuration((int) newValue); 
    		return;
    	}
    	if (MetamodelPackage.Literals.TUTORIAL__TIMESLOT.equals(eFeature)) {
    		setTimeslot((metamodel.Timeslot) newValue); 
    		return;
    	}
    	if (MetamodelPackage.Literals.TUTORIAL__LECTURER.equals(eFeature)) {
    		setLecturer((metamodel.Lecturer) newValue); 
    		return;
    	}
    	if (MetamodelPackage.Literals.TUTORIAL__SKILL_TYPE.equals(eFeature)) {
    		setSkillType((java.lang.String) newValue); 
    		return;
    	}
    	if (MetamodelPackage.Literals.TUTORIAL__TYPE.equals(eFeature)) {
    		setType((java.lang.String) newValue); 
    		return;
    	}
    	if (MetamodelPackage.Literals.TUTORIAL__CAMPUS.equals(eFeature)) {
    		setCampus((java.lang.String) newValue); 
    		return;
    	}
    	if (MetamodelPackage.Literals.TUTORIAL__REQUIRED_NUMBER_OF_TAS.equals(eFeature)) {
    		setRequiredNumberOfTas((int) newValue); 
    		return;
    	}
    	if (MetamodelPackage.Literals.TUTORIAL__WEEKS.equals(eFeature)) {
    		setWeeks((LinkedSmartESet<metamodel.Week>) newValue); 
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
    	if (MetamodelPackage.Literals.TUTORIAL__GIVEN_BY.equals(eFeature)) {
    		setGivenBy((metamodel.Assistant)null); 
    		return;
    	}
    	if (MetamodelPackage.Literals.TUTORIAL__DURATION.equals(eFeature)) {
    		setDuration((int)0); 
    		return;
    	}
    	if (MetamodelPackage.Literals.TUTORIAL__TIMESLOT.equals(eFeature)) {
    		setTimeslot((metamodel.Timeslot)null); 
    		return;
    	}
    	if (MetamodelPackage.Literals.TUTORIAL__LECTURER.equals(eFeature)) {
    		setLecturer((metamodel.Lecturer)null); 
    		return;
    	}
    	if (MetamodelPackage.Literals.TUTORIAL__SKILL_TYPE.equals(eFeature)) {
    		setSkillType((java.lang.String)null); 
    		return;
    	}
    	if (MetamodelPackage.Literals.TUTORIAL__TYPE.equals(eFeature)) {
    		setType((java.lang.String)null); 
    		return;
    	}
    	if (MetamodelPackage.Literals.TUTORIAL__CAMPUS.equals(eFeature)) {
    		setCampus((java.lang.String)null); 
    		return;
    	}
    	if (MetamodelPackage.Literals.TUTORIAL__REQUIRED_NUMBER_OF_TAS.equals(eFeature)) {
    		setRequiredNumberOfTas((int)0); 
    		return;
    	}
    	if (MetamodelPackage.Literals.TUTORIAL__WEEKS.equals(eFeature)) {
    		getWeeks().clear(); 
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
			b.append("duration: ");
			b.append(getDuration());b.append(", ");
			b.append("skillType: ");
			b.append(getSkillType());b.append(", ");
			b.append("type: ");
			b.append(getType());b.append(", ");
			b.append("campus: ");
			b.append(getCampus());b.append(", ");
			b.append("requiredNumberOfTas: ");
			b.append(getRequiredNumberOfTas());
		}
		b.append(")");
		return b.toString();
    }

 	@Override
    public Object eGet(EStructuralFeature eFeature){
    	if (MetamodelPackage.Literals.NAMED_ELEMENT__NAME.equals(eFeature))
    		return getName();
    	if (MetamodelPackage.Literals.TUTORIAL__GIVEN_BY.equals(eFeature))
    		return getGivenBy();
    	if (MetamodelPackage.Literals.TUTORIAL__DURATION.equals(eFeature))
    		return getDuration();
    	if (MetamodelPackage.Literals.TUTORIAL__TIMESLOT.equals(eFeature))
    		return getTimeslot();
    	if (MetamodelPackage.Literals.TUTORIAL__LECTURER.equals(eFeature))
    		return getLecturer();
    	if (MetamodelPackage.Literals.TUTORIAL__SKILL_TYPE.equals(eFeature))
    		return getSkillType();
    	if (MetamodelPackage.Literals.TUTORIAL__TYPE.equals(eFeature))
    		return getType();
    	if (MetamodelPackage.Literals.TUTORIAL__CAMPUS.equals(eFeature))
    		return getCampus();
    	if (MetamodelPackage.Literals.TUTORIAL__REQUIRED_NUMBER_OF_TAS.equals(eFeature))
    		return getRequiredNumberOfTas();
    	if (MetamodelPackage.Literals.TUTORIAL__WEEKS.equals(eFeature))
    		return getWeeks();
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
	    	}
	    	
	    	@Override
	    	/**
	    	* This method sets the resource and only generates REMOVING_ADAPTER notifications (no ADD messages)
	    	*/
    protected void setResourceOfContainmentsSilently(Resource r) { 		
	    	}
}
