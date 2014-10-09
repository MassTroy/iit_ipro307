package iit.ipro497.thermal.controller.admin;

import iit.ipro497.thermal.client.GoogleGeocodeClient;
import iit.ipro497.thermal.controller.AbstractController;
import iit.ipro497.thermal.exception.BadRequestException;
import iit.ipro497.thermal.model.data.GeoCoordinate;
import iit.ipro497.thermal.persistence.IntersectionCoord;
import iit.ipro497.thermal.persistence.dao.IntersectionCoordDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AddIntersectionController extends AbstractController {
	@Autowired
	private IntersectionCoordDAO intersectionCoordDAO;
	@Autowired
	private GoogleGeocodeClient googleGeocodeClient;

	@RequestMapping(value = {"/addIntersection"}, method = RequestMethod.GET)
	@Transactional(readOnly = false)
	@ResponseBody
	public GeoCoordinate addIntersectionLocation(
			@RequestParam(value= "locationName", required = true) String locationName) throws BadRequestException {
		
		IntersectionCoord intersection = intersectionCoordDAO.findByName(locationName);
		GeoCoordinate coordinate = null;
		if (intersection == null) {
			coordinate = googleGeocodeClient.getGeoCoordinate(locationName);
			intersection = new IntersectionCoord(locationName, coordinate.getLatitude(), coordinate.getLongitude());
			intersectionCoordDAO.persist(intersection);
		}
		
		return coordinate;
	}

}