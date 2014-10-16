package iit.ipro307.domain.client;

import iit.ipro307.config.AppConfig;
import iit.ipro307.domain.data.Route;
import iit.ipro307.domain.data.RouteSegment;
import iit.ipro307.exception.BadRequestException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.google.maps.api.directions.DirectionsResponse;
import com.google.maps.api.directions.Leg;
import com.google.maps.api.directions.Step;
import common.util.DateOffsetCalculator;
import common.util.PrefixLogger;

@Service
public class GoogleDirectionsClient {
	private static final String API_DIRECTIONS_URL = "https://maps.googleapis.com/maps/api/directions/json?alternatives=true&";

	@Autowired
	private PrefixLogger log;

	public List<Route> getDirections(String origin, String destination) throws BadRequestException {
		String url = API_DIRECTIONS_URL
				+ "origin=" + origin
				+ "&destination=" + destination
				+ "&key=" + AppConfig.GOOGLE_API_KEY;

		return getRoutes(url);
	}

	private List<Route> getRoutes(String url) throws BadRequestException {
		log.debug("Getting google directions. url=" + url);
		RestTemplate restTemplate = new RestTemplate();
		DirectionsResponse resp = restTemplate.getForObject(url, DirectionsResponse.class);

		if (resp != null && resp.getStatus() != null && resp.getStatus().equals("OK")) {
			if (resp != null && resp.getRoutes() != null && resp.getRoutes().size() >= 1) {
				List<Route> routePointsList = new ArrayList<Route>();

				for (com.google.maps.api.directions.Route googleRoute : resp.getRoutes()) {

					List<RouteSegment> segments = new ArrayList<RouteSegment>();
					long duration = 0;
					for (Leg leg : googleRoute.getLegs()) {
						duration += leg.getDuration().getValue();
						for (Step step : leg.getSteps()) {
							RouteSegment routePoint = new RouteSegment(step);
							segments.add(routePoint);
						}
					}

					Date depart = new Date();
					Date arrive = DateOffsetCalculator.offsetSeconds(depart, duration);
					Route routePoints = new Route(googleRoute, depart, arrive, segments);
					routePointsList.add(routePoints);
				}

				return routePointsList;
			}
		}

		throw new BadRequestException("Failed to get response from Google Directions. url=" + url);
	}

	public List<Route> getDirections(String origin, String destination, String waypoint) throws BadRequestException {
		String url = API_DIRECTIONS_URL
				+ "origin=" + origin
				+ "&destination=" + destination
				+ "&waypoints=" + waypoint
				+ "&key=" + AppConfig.GOOGLE_API_KEY;

		return getRoutes(url);
	}
}