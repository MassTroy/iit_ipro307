package iit.ipro497.thermal.controller.pages;

import iit.ipro497.thermal.controller.AbstractController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AboutController extends AbstractController {

	@RequestMapping(value = { "/about" }, method = RequestMethod.GET)
	public ModelAndView about() {
		return new ModelAndView("about");
	}

}
