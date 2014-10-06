package iit.ipro497.thermal.controller.pages;

import iit.ipro497.thermal.controller.AbstractController;
import iit.ipro497.thermal.model.FormData;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PostFormController extends AbstractController {

	@RequestMapping(value = {"/submit"}, method = RequestMethod.POST)
	public ModelAndView display(
			@ModelAttribute FormData form) {
		System.out.println(form);
		ModelAndView mav = new ModelAndView("redirect:/display");
		
		return mav;
	}

}
