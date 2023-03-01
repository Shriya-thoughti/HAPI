package ca.uhn.fhir.jpa.starter;

import ca.uhn.fhir.interceptor.api.Hook;
import ca.uhn.fhir.interceptor.api.Interceptor;

import org.hl7.fhir.instance.model.api.IBaseConformance;
import org.hl7.fhir.r4.model.CapabilityStatement;
import org.hl7.fhir.r4.model.DateTimeType;

import ca.uhn.fhir.interceptor.api.*;

public class CapabilityStatementInterceptor {
	
	 private static final org.slf4j.Logger ourLog = org.slf4j.LoggerFactory.getLogger(SimpleServerLogging.class);


	@Interceptor
	public class CapabilityStatementCustomizer {

	   @Hook(Pointcut.SERVER_CAPABILITY_STATEMENT_GENERATED)
	   public void customize(IBaseConformance theCapabilityStatement) {

	      // Cast to the appropriate version
	  //    CapabilityStatement cs = (CapabilityStatement) theCapabilityStatement;

	      // Customize the CapabilityStatement as desired
	  //    cs
	  //       .getSoftware()
	  //       .setName("Acme FHIR Server")
	  //       .setVersion("1.0")
	  //       .setReleaseDateElement(new DateTimeType("2021-02-06"));
	  //    ourLog.info("Modifying the capability statement");
	  //    System.out.println("CAPABILITYSTATEMENT");
	//      System.out.println(cs.getSoftware().getName());

	   }

	}

}
