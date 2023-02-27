package ca.uhn.fhir.jpa.starter;

import javax.servlet.http.HttpServletResponse;

import org.hibernate.search.util.common.logging.impl.LoggerFactory;
import org.hl7.fhir.instance.model.api.IBaseResource;

import ca.uhn.fhir.interceptor.api.*;
import ca.uhn.fhir.rest.api.server.RequestDetails;
import ca.uhn.fhir.rest.server.servlet.ServletRequestDetails;
import ca.uhn.fhir.rest.server.servlet.ServletRestfulResponse;
import ca.uhn.fhir.rest.api.server.ResponseDetails;

public class SimpleServerLogging {
	

	 private static final org.slf4j.Logger ourLog = org.slf4j.LoggerFactory.getLogger(SimpleServerLogging.class);

	   @Hook(Pointcut.SERVER_PROCESSING_COMPLETED_NORMALLY)
	   public void logRequests(ServletRequestDetails theRequest) {
		   ourLog.info("INCOMING REQUEST");
	      ourLog.info("Request of type {} with request ID: {}", theRequest.getRestOperationType(), theRequest.getId());
	   }
	   
	   @Hook(Pointcut.SERVER_OUTGOING_RESPONSE)
	   public void logRequests1(ResponseDetails theResponse) {
		   ourLog.info("OUTGOING RESPONSE");
	      ourLog.info("Request of type {} with" ,theResponse.getResponseCode());
	   }
	   
	   @Hook(Pointcut.STORAGE_PRESTORAGE_RESOURCE_CREATED)
	   public void insert(IBaseResource theResource) {
		   System.out.println("RESOURCE CREATED");
	      System.out.println(theResource.getMeta().getVersionId());
	      
	   }


}
