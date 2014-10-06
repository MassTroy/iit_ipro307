package iit.ipro497.thermal.controller.pages;

import iit.ipro497.thermal.controller.AbstractController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DisplayController extends AbstractController {

	@RequestMapping(value = {"/display"}, method = RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView("display");
		
		return mav;
	}

}
