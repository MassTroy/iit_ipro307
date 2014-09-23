package iit.ipro497.themal.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;

public abstract class AbstractController {
	@Autowired 
	protected AutowireCapableBeanFactory beanFactory;
	@Autowired
	protected HttpServletRequest request;
	
	protected String getPreviousPage() {
		return request.getHeader("referer");
	}
}
