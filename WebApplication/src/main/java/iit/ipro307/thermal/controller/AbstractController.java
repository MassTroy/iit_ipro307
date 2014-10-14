package iit.ipro307.thermal.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;

public abstract class AbstractController {
	public static final String FORM_ATTRIBUTE = "form";

	@Autowired
	protected AutowireCapableBeanFactory beanFactory;
	@Autowired
	protected HttpServletRequest request;
	@Autowired
	protected HttpSession session;

	protected String getPreviousPage() {
		return request.getHeader("referer");
	}
}
