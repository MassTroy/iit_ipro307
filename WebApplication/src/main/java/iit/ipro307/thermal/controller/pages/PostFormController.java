package iit.ipro307.thermal.controller.pages;

import iit.ipro307.thermal.controller.AbstractController;
import iit.ipro307.thermal.model.FormData;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PostFormController extends AbstractController {

	/**
	 * Accept the post values from the form as a FormData object
	 * @param form
	 */
	@RequestMapping(value = { "/submit" }, method = RequestMethod.POST)
	public ModelAndView display(
			@ModelAttribute FormData form
			) {
		// validate the form
		form.validate();

		// store the form data into the session
		session.setAttribute(FORM_ATTRIBUTE, form);
		// redirect to the display page
		ModelAndView mav = new ModelAndView("redirect:/display");

		return mav;
	}

}
