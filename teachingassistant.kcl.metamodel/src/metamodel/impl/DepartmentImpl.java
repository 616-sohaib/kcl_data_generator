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

public class DepartmentImpl extends SmartObject implements metamodel.Department {

    protected java.lang.String name = null;
    protected LinkedSmartESet<metamodel.Assistant> assistants = new LinkedSmartESet<metamodel.Assistant>(this, MetamodelPackage.Literals.DEPARTMENT__ASSISTANTS);
    protected LinkedSmartESet<metamodel.Tutorial> tutorials = new LinkedSmartESet<metamodel.Tutorial>(this, MetamodelPackage.Literals.DEPARTMENT__TUTORIALS);
    protected LinkedSmartESet<metamodel.Timeslot> timeslots = new LinkedSmartESet<metamodel.Timeslot>(this, MetamodelPackage.Literals.DEPARTMENT__TIMESLOTS);
    protected LinkedSmartESet<metamodel.Lecturer> lecturers = new LinkedSmartESet<metamodel.Lecturer>(this, MetamodelPackage.Literals.DEPARTMENT__LECTURERS);
    protected LinkedSmartESet<metamodel.Day> days = new LinkedSmartESet<metamodel.Day>(this, MetamodelPackage.Literals.DEPARTMENT__DAYS);
    protected LinkedSmartESet<metamodel.Week> weeks = new LinkedSmartESet<metamodel.Week>(this, MetamodelPackage.Literals.DEPARTMENT__WEEKS);
    protected LinkedSmartESet<metamodel.Module> modules = new LinkedSmartESet<metamodel.Module>(this, MetamodelPackage.Literals.DEPARTMENT__MODULES);
	
	protected DepartmentImpl() {
		super(MetamodelPackage.Literals.DEPARTMENT);
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
    public LinkedSmartESet<metamodel.Assistant> getAssistants() {
    	return this.assistants;
    }
    
    @Override
    public void setAssistants(LinkedSmartESet<metamodel.Assistant> value) {
    	throw new UnsupportedOperationException("Set methods for SmartEMF collections are not supported.");
    }
    
    
    @Override
    public LinkedSmartESet<metamodel.Tutorial> getTutorials() {
    	return this.tutorials;
    }
    
    @Override
    public void setTutorials(LinkedSmartESet<metamodel.Tutorial> value) {
    	throw new UnsupportedOperationException("Set methods for SmartEMF collections are not supported.");
    }
    
    
    @Override
    public LinkedSmartESet<metamodel.Timeslot> getTimeslots() {
    	return this.timeslots;
    }
    
    @Override
    public void setTimeslots(LinkedSmartESet<metamodel.Timeslot> value) {
    	throw new UnsupportedOperationException("Set methods for SmartEMF collections are not supported.");
    }
    
    
    @Override
    public LinkedSmartESet<metamodel.Lecturer> getLecturers() {
    	return this.lecturers;
    }
    
    @Override
    public void setLecturers(LinkedSmartESet<metamodel.Lecturer> value) {
    	throw new UnsupportedOperationException("Set methods for SmartEMF collections are not supported.");
    }
    
    
    @Override
    public LinkedSmartESet<metamodel.Day> getDays() {
    	return this.days;
    }
    
    @Override
    public void setDays(LinkedSmartESet<metamodel.Day> value) {
    	throw new UnsupportedOperationException("Set methods for SmartEMF collections are not supported.");
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
    public LinkedSmartESet<metamodel.Module> getModules() {
    	return this.modules;
    }
    
    @Override
    public void setModules(LinkedSmartESet<metamodel.Module> value) {
    	throw new UnsupportedOperationException("Set methods for SmartEMF collections are not supported.");
    }
    

    @Override
    public void eSet(EStructuralFeature eFeature, Object newValue){
    	if (MetamodelPackage.Literals.NAMED_ELEMENT__NAME.equals(eFeature)) {
    		setName((java.lang.String) newValue); 
    		return;
    	}
    	if (MetamodelPackage.Literals.DEPARTMENT__ASSISTANTS.equals(eFeature)) {
    		setAssistants((LinkedSmartESet<metamodel.Assistant>) newValue); 
    		return;
    	}
    	if (MetamodelPackage.Literals.DEPARTMENT__TUTORIALS.equals(eFeature)) {
    		setTutorials((LinkedSmartESet<metamodel.Tutorial>) newValue); 
    		return;
    	}
    	if (MetamodelPackage.Literals.DEPARTMENT__TIMESLOTS.equals(eFeature)) {
    		setTimeslots((LinkedSmartESet<metamodel.Timeslot>) newValue); 
    		return;
    	}
    	if (MetamodelPackage.Literals.DEPARTMENT__LECTURERS.equals(eFeature)) {
    		setLecturers((LinkedSmartESet<metamodel.Lecturer>) newValue); 
    		return;
    	}
    	if (MetamodelPackage.Literals.DEPARTMENT__DAYS.equals(eFeature)) {
    		setDays((LinkedSmartESet<metamodel.Day>) newValue); 
    		return;
    	}
    	if (MetamodelPackage.Literals.DEPARTMENT__WEEKS.equals(eFeature)) {
    		setWeeks((LinkedSmartESet<metamodel.Week>) newValue); 
    		return;
    	}
    	if (MetamodelPackage.Literals.DEPARTMENT__MODULES.equals(eFeature)) {
    		setModules((LinkedSmartESet<metamodel.Module>) newValue); 
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
    	if (MetamodelPackage.Literals.DEPARTMENT__ASSISTANTS.equals(eFeature)) {
    		getAssistants().clear(); 
    		return;
    	}
    	if (MetamodelPackage.Literals.DEPARTMENT__TUTORIALS.equals(eFeature)) {
    		getTutorials().clear(); 
    		return;
    	}
    	if (MetamodelPackage.Literals.DEPARTMENT__TIMESLOTS.equals(eFeature)) {
    		getTimeslots().clear(); 
    		return;
    	}
    	if (MetamodelPackage.Literals.DEPARTMENT__LECTURERS.equals(eFeature)) {
    		getLecturers().clear(); 
    		return;
    	}
    	if (MetamodelPackage.Literals.DEPARTMENT__DAYS.equals(eFeature)) {
    		getDays().clear(); 
    		return;
    	}
    	if (MetamodelPackage.Literals.DEPARTMENT__WEEKS.equals(eFeature)) {
    		getWeeks().clear(); 
    		return;
    	}
    	if (MetamodelPackage.Literals.DEPARTMENT__MODULES.equals(eFeature)) {
    		getModules().clear(); 
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
    	if (MetamodelPackage.Literals.DEPARTMENT__ASSISTANTS.equals(eFeature))
    		return getAssistants();
    	if (MetamodelPackage.Literals.DEPARTMENT__TUTORIALS.equals(eFeature))
    		return getTutorials();
    	if (MetamodelPackage.Literals.DEPARTMENT__TIMESLOTS.equals(eFeature))
    		return getTimeslots();
    	if (MetamodelPackage.Literals.DEPARTMENT__LECTURERS.equals(eFeature))
    		return getLecturers();
    	if (MetamodelPackage.Literals.DEPARTMENT__DAYS.equals(eFeature))
    		return getDays();
    	if (MetamodelPackage.Literals.DEPARTMENT__WEEKS.equals(eFeature))
    		return getWeeks();
    	if (MetamodelPackage.Literals.DEPARTMENT__MODULES.equals(eFeature))
    		return getModules();
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
    	for(Object obj : getAssistants()) {
    		setResourceCall.accept(((SmartObject) obj));
	    		}
    	for(Object obj : getTutorials()) {
    		setResourceCall.accept(((SmartObject) obj));
	    		}
    	for(Object obj : getTimeslots()) {
    		setResourceCall.accept(((SmartObject) obj));
	    		}
    	for(Object obj : getLecturers()) {
    		setResourceCall.accept(((SmartObject) obj));
	    		}
    	for(Object obj : getDays()) {
    		setResourceCall.accept(((SmartObject) obj));
	    		}
    	for(Object obj : getWeeks()) {
    		setResourceCall.accept(((SmartObject) obj));
	    		}
    	for(Object obj : getModules()) {
    		setResourceCall.accept(((SmartObject) obj));
	    		}
	    	}
	    	
	    	@Override
	    	/**
	    	* This method sets the resource and only generates REMOVING_ADAPTER notifications (no ADD messages)
	    	*/
    protected void setResourceOfContainmentsSilently(Resource r) { 		
    	for(Object obj : getAssistants()) {
    		((SmartObject) obj).setResourceSilently(r);
	    		}
    	for(Object obj : getTutorials()) {
    		((SmartObject) obj).setResourceSilently(r);
	    		}
    	for(Object obj : getTimeslots()) {
    		((SmartObject) obj).setResourceSilently(r);
	    		}
    	for(Object obj : getLecturers()) {
    		((SmartObject) obj).setResourceSilently(r);
	    		}
    	for(Object obj : getDays()) {
    		((SmartObject) obj).setResourceSilently(r);
	    		}
    	for(Object obj : getWeeks()) {
    		((SmartObject) obj).setResourceSilently(r);
	    		}
    	for(Object obj : getModules()) {
    		((SmartObject) obj).setResourceSilently(r);
	    		}
	    	}
}
