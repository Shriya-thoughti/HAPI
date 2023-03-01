package ca.uhn.fhir.jpa.starter;
import org.apache.commons.codec.binary.Base64;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ca.uhn.fhir.i18n.Msg;
import ca.uhn.fhir.interceptor.api.*;
import ca.uhn.fhir.rest.api.server.RequestDetails;
import ca.uhn.fhir.rest.server.exceptions.AuthenticationException;

@Interceptor
public class BasicAuthorizationInterceptor {

	@Hook(Pointcut.SERVER_INCOMING_REQUEST_POST_PROCESSED)
	   public boolean incomingRequestPostProcessed(RequestDetails theRequestDetails, HttpServletRequest theRequest, HttpServletResponse theResponse) throws AuthenticationException {
	      String authHeader = theRequest.getHeader("Authorization");

	      // The format of the header must be:
	      // Authorization: Basic [base64 of username:password]
	      if (authHeader == null || authHeader.startsWith("Basic ") == false) {
	         throw new AuthenticationException(Msg.code(642) + "Missing or invalid Authorization header");
	      }

	      String base64 = authHeader.substring("Basic ".length());
	      String base64decoded = new String(Base64.decodeBase64(base64));
	      String[] parts = base64decoded.split(":");

	      String username = parts[0];
	      String password = parts[1];

	    
	      if (!username.equals("thoughti") || !password.equals("password1")) {
	         throw new AuthenticationException(Msg.code(643) + "Invalid username or password");
	      }

	   
	      return true;
	   }

}
