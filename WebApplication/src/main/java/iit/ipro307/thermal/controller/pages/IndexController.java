package iit.ipro307.thermal.controller.pages;

import iit.ipro307.thermal.controller.AbstractController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController extends AbstractController {

	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView mav;

		if (session.getAttribute(FORM_ATTRIBUTE) == null) {
			mav = new ModelAndView("index");
		} else {
			mav = new ModelAndView("redirect:display");
		}

		return mav;
	}

}
