package iit.ipro307.thermal.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Abstract controller class. Autowires up all shared items such as the request and session
 * @author Troy Mass
 */
public abstract class AbstractController {
	public static final String FORM_ATTRIBUTE = "form";

	@Autowired
	protected HttpServletRequest request;
	@Autowired
	protected HttpSession session;

	protected String getPreviousPage() {
		return request.getHeader("referer");
	}
}
