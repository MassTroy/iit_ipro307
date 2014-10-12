package iit.ipro497.thermal.controller.pages;

import iit.ipro497.domain.ThermalRouteService;
import iit.ipro497.domain.data.RouteSummary;
import iit.ipro497.exception.BadRequestException;
import iit.ipro497.thermal.controller.AbstractController;
import iit.ipro497.thermal.model.DisplayModel;
import iit.ipro497.thermal.model.FormData;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DisplayController extends AbstractController {
	@Autowired
	private ThermalRouteService routeFinder;

	@RequestMapping(value = {"/display"}, method = RequestMethod.GET)
	public ModelAndView display() throws BadRequestException {
		FormData form = (FormData)session.getAttribute(FORM_ATTRIBUTE);
		if (form == null)
			return new ModelAndView("redirect:./");
		
		List<RouteSummary> routeList;
		routeList = routeFinder.findRoutes(form);
		DisplayModel model = new DisplayModel(form, routeList);
		ModelAndView mav = new ModelAndView("display", "model", model);
		return mav;
	}

}
