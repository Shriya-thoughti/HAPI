package ca.uhn.fhir.jpa.starter;

import org.hibernate.search.util.common.logging.impl.LoggerFactory;

import ca.uhn.fhir.interceptor.api.*;
import ca.uhn.fhir.rest.api.server.RequestDetails;
import ca.uhn.fhir.rest.server.servlet.ServletRequestDetails;

public class SimpleServerLogging {
	

	 private static final org.slf4j.Logger ourLog = org.slf4j.LoggerFactory.getLogger(SimpleServerLogging.class);

	   @Hook(Pointcut.SERVER_PROCESSING_COMPLETED_NORMALLY)
	   public void logRequests(ServletRequestDetails theRequest) {
		   ourLog.info("INCOMING REQUEST");
	      ourLog.info("Request of type {} with request ID: {}", theRequest.getRestOperationType(), theRequest.getId());
	   }


}
