package iit.ipro497.themal.controller.pages;

import iit.ipro497.themal.controller.AbstractController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PostFormController extends AbstractController {

	@RequestMapping(value = {"/", "/ROOT"}, method = RequestMethod.POST)
	public ModelAndView display() {
		ModelAndView mav = new ModelAndView("index");
		
		return mav;
	}

}
