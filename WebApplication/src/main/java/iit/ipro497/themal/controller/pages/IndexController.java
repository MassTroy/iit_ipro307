package iit.ipro497.themal.controller.pages;

import iit.ipro497.themal.controller.AbstractController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController extends AbstractController {

	@RequestMapping(value = {"/", "/ROOT"}, method = RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView("index");
		
		return mav;
	}

}
