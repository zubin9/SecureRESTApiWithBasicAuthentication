package com.rest.learning.security;

/*
Used by the ExceptionTraslationFilter to commence authentication via the BasicAuthenticationFilter.
Once a user agent is authenticated using BASIC authentication, 
	logout requires that the browser be closed or an unauthorized (401) header be sent. 
	The simplest way of achieving the latter is to call the commence(HttpServletRequest, HttpServletResponse, AuthenticationException) method below. 
	This will indicate to the browser its credentials are no longer authorized, causing it to prompt the user to login again.
	
If authentication is successful, the resulting Authentication object will be placed into the SecurityContextHolder.

If authentication fails and ignoreFailure is false (the default), 
	an AuthenticationEntryPoint implementation is called (unless the ignoreFailure property is set to true). 
	Usually this should be BasicAuthenticationEntryPoint, which will prompt the user to authenticate again via BASIC authentication.

		
BasicAuthenticationFilter: this filter is responsible for processing any request that has a HTTP request header of Authorization 
	with an authentication scheme of Basic and a Base64-encoded username:password token
*/

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;

public class CustomBasicAuthenticationEntryPoint extends BasicAuthenticationEntryPoint {

    @Override
    public void commence(final HttpServletRequest request, 
    		final HttpServletResponse response, 
    		final AuthenticationException authException) throws IOException, ServletException {
    	
    	response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
    	response.addHeader("WWW-Authenticate", "Basic realm=" + getRealmName() + "");
        
        PrintWriter writer = response.getWriter();
        writer.println("HTTP Status 401 : " + authException.getMessage());
    }
    
    @Override
    public void afterPropertiesSet() throws Exception {
        setRealmName("MY_TEST_REALM");
        super.afterPropertiesSet();
    }
}