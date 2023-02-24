package ca.uhn.fhir.jpa.starter.resourceprovider;

import org.hl7.fhir.dstu2.model.IdType;
//import org.hl7.fhir.dstu2.model.Patient;

import ca.uhn.fhir.model.dstu2.resource.Patient;

//import org.hl7.fhir.r5.model.IdType;
//import org.hl7.fhir.r5.model.Patient;

import ca.uhn.fhir.rest.annotation.IdParam;
import ca.uhn.fhir.rest.annotation.Read;
import ca.uhn.fhir.rest.server.IResourceProvider;

//package ca.uhn.fhir.jpa.starter.resourceprovider;

//import org.hl7.fhir.dstu2.model.IdType;

//import org.hl7.fhir.dstu2016may.model.IdType;

//import org.hl7.fhir.dstu2.model.IdType;

//import ca.uhn.fhir.model.dstu2.resource.Patient;

//import org.hl7.fhir.r5.model.Enumerations.AdministrativeGender;
//import org.hl7.fhir.r5.model.IdType;
//import org.hl7.fhir.r5.model.Patient;

//import ca.uhn.fhir.rest.annotation.IdParam;
//import ca.uhn.fhir.rest.annotation.Read;
//import ca.uhn.fhir.rest.server.IResourceProvider;

public class PatientResourceProvider implements IResourceProvider {
	 @Override
	   public Class<Patient> getResourceType() {
	      return Patient.class;
	   }
	 @Read()
	   public Patient getResourceById(@IdParam IdType theId) {
		 Patient retVal = new Patient();
		   
		   // ...populate...
		   retVal.addIdentifier().setSystem("urn:mrns").setValue("12345");
		  // retVal.addName().setFamily("Smith").addGiven("Tester").addGiven("Q");
		   // ...etc...
		   
		   // if you know the version ID of the resource, you should set it and HAPI will 
		   // include it in a Content-Location header
		   retVal.setId(new IdType("Patient", "123", "2"));
		   
		   return retVal;
	   }
	

}
