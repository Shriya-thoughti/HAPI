package ca.uhn.fhir.jpa.starter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.search.util.common.logging.impl.LoggerFactory;

import ca.uhn.fhir.interceptor.api.Hook;
import ca.uhn.fhir.interceptor.api.Pointcut;
import ca.uhn.fhir.jpa.starter.AppProperties.Logger;
import ca.uhn.fhir.jpa.starter.common.StarterJpaConfig;
import ca.uhn.fhir.rest.client.interceptor.InterceptorOrders;



public class RequestCounterInterceptor {
	 private int myRequestCount;
	 private static final org.slf4j.Logger ourLog = org.slf4j.LoggerFactory.getLogger(RequestCounterInterceptor.class);

	   public int getRequestCount() {
		   //ourLog.info("INCOMING REQ");
	      return myRequestCount;
	   }

	   /**
	    * Override the incomingRequestPreProcessed method, which is called
	    * for each incoming request before any processing is done
	    */
	   @Hook(Pointcut.SERVER_INCOMING_REQUEST_PRE_PROCESSED)
	   public boolean incomingRequestPreProcessed(HttpServletRequest theRequest, HttpServletResponse theResponse) {
	      myRequestCount++;
	      System.out.println("REQUEST COUNT");
	      System.out.println(myRequestCount);
	      return true;
	   }
}
