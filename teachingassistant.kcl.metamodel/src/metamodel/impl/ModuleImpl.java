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

public class ModuleImpl extends SmartObject implements metamodel.Module {

    protected java.lang.String name = null;
    protected java.lang.String code = null;
    protected metamodel.Lecturer lecturer = null;
    protected LinkedSmartESet<metamodel.Tutorial> tutorials = new LinkedSmartESet<metamodel.Tutorial>(this, MetamodelPackage.Literals.MODULE__TUTORIALS);
    protected int maximumNumberOfTas = 0;
	
	protected ModuleImpl() {
		super(MetamodelPackage.Literals.MODULE);

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
    public java.lang.String getCode() {
    	return this.code;
    }
    
    @Override
    public void setCode(java.lang.String value) {
    	Object oldValue = this.code;
    	this.code = value;
    	
    	        	sendNotification(SmartEMFNotification.createSetNotification(this, MetamodelPackage.Literals.MODULE__CODE, oldValue, value, -1));
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
    		        
    	
    	
    	        	sendNotification(SmartEMFNotification.createSetNotification(this, MetamodelPackage.Literals.MODULE__LECTURER, oldValue, value, -1));
    	        	
    	        	if(MetamodelPackage.Literals.MODULE__LECTURER.getEOpposite() != null) {
    	        		if(oldValue != null) {
    	        			((SmartObject) oldValue).eInverseRemove(this, MetamodelPackage.Literals.MODULE__LECTURER.getEOpposite());
    	        		}
    	        		if(value != null) {
    	        		    ((SmartObject) value).eInverseAdd(this, MetamodelPackage.Literals.MODULE__LECTURER.getEOpposite());
    	        		}
    	        	}
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
    public int getMaximumNumberOfTas() {
    	return this.maximumNumberOfTas;
    }
    
    @Override
    public void setMaximumNumberOfTas(int value) {
    	Object oldValue = this.maximumNumberOfTas;
    	this.maximumNumberOfTas = value;
    	
    	        	sendNotification(SmartEMFNotification.createSetNotification(this, MetamodelPackage.Literals.MODULE__MAXIMUM_NUMBER_OF_TAS, oldValue, value, -1));
    }
    

    @Override
    public void eSet(EStructuralFeature eFeature, Object newValue){
    	if (MetamodelPackage.Literals.NAMED_ELEMENT__NAME.equals(eFeature)) {
    		setName((java.lang.String) newValue); 
    		return;
    	}
    	if (MetamodelPackage.Literals.MODULE__CODE.equals(eFeature)) {
    		setCode((java.lang.String) newValue); 
    		return;
    	}
    	if (MetamodelPackage.Literals.MODULE__LECTURER.equals(eFeature)) {
    		setLecturer((metamodel.Lecturer) newValue); 
    		return;
    	}
    	if (MetamodelPackage.Literals.MODULE__TUTORIALS.equals(eFeature)) {
    		setTutorials((LinkedSmartESet<metamodel.Tutorial>) newValue); 
    		return;
    	}
    	if (MetamodelPackage.Literals.MODULE__MAXIMUM_NUMBER_OF_TAS.equals(eFeature)) {
    		setMaximumNumberOfTas((int) newValue); 
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
    	if (MetamodelPackage.Literals.MODULE__CODE.equals(eFeature)) {
    		setCode((java.lang.String)null); 
    		return;
    	}
    	if (MetamodelPackage.Literals.MODULE__LECTURER.equals(eFeature)) {
    		setLecturer((metamodel.Lecturer)null); 
    		return;
    	}
    	if (MetamodelPackage.Literals.MODULE__TUTORIALS.equals(eFeature)) {
    		getTutorials().clear(); 
    		return;
    	}
    	if (MetamodelPackage.Literals.MODULE__MAXIMUM_NUMBER_OF_TAS.equals(eFeature)) {
    		setMaximumNumberOfTas((int)0); 
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
			b.append("code: ");
			b.append(getCode());b.append(", ");
			b.append("maximumNumberOfTas: ");
			b.append(getMaximumNumberOfTas());
		}
		b.append(")");
		return b.toString();
    }

 	@Override
    public Object eGet(EStructuralFeature eFeature){
    	if (MetamodelPackage.Literals.NAMED_ELEMENT__NAME.equals(eFeature))
    		return getName();
    	if (MetamodelPackage.Literals.MODULE__CODE.equals(eFeature))
    		return getCode();
    	if (MetamodelPackage.Literals.MODULE__LECTURER.equals(eFeature))
    		return getLecturer();
    	if (MetamodelPackage.Literals.MODULE__TUTORIALS.equals(eFeature))
    		return getTutorials();
    	if (MetamodelPackage.Literals.MODULE__MAXIMUM_NUMBER_OF_TAS.equals(eFeature))
    		return getMaximumNumberOfTas();
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
    	for(Object obj : getTutorials()) {
    		setResourceCall.accept(((SmartObject) obj));
	    		}
	    	}
	    	
	    	@Override
	    	/**
	    	* This method sets the resource and only generates REMOVING_ADAPTER notifications (no ADD messages)
	    	*/
    protected void setResourceOfContainmentsSilently(Resource r) { 		
    	for(Object obj : getTutorials()) {
    		((SmartObject) obj).setResourceSilently(r);
	    		}
	    	}
}
