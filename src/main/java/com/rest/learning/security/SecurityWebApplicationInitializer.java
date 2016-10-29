package com.rest.learning.security;

/* 
http://docs.spring.io/spring-security/site/docs/current/reference/html/jc.html#abstractsecuritywebapplicationinitializer-with-spring-mvc
This would simply only register the springSecurityFilterChain Filter for every URL in your application. 
After that we would ensure that WebSecurityConfig was loaded in our existing ApplicationInitializer. 
For example, if we were using Spring MVC it would be added in the getRootConfigClasses()

Spring Security provides a base class AbstractSecurityWebApplicationInitializer that will ensure the springSecurityFilterChain gets registered for you

*/

/*
The below code is equivalent to 
<filter>
	<filter-name>springSecurityFilterChain</filter-name>
	<filter-class>org.springframework.web.filter.DelegatingFilterProxy</filter-class>
</filter>
<filter-mapping>
	<filter-name>springSecurityFilterChain</filter-name>
	<url-pattern>/*</url-pattern>
	<dispatcher>ERROR</dispatcher>
	<dispatcher>REQUEST</dispatcher>
</filter-mapping>

*/
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

public class SecurityWebApplicationInitializer extends AbstractSecurityWebApplicationInitializer {

}
