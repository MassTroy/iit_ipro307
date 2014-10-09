package iit.ipro497.domain.client;

import iit.ipro497.config.AppConfig;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.google.maps.api.common.Location;
import com.google.maps.api.directions.DirectionsResponse;
import com.google.maps.api.directions.Step;

@Service
public class GoogleDirectionsClient {
	private static final String API_DIRECTIONS_URL = "https://maps.googleapis.com/maps/api/directions/json?";

	public void getDirections(String origin, String destination, String waypoint) {
		String url = API_DIRECTIONS_URL 
				+ "origin=" + origin 
				+ "&destination=" + destination 
				+ "&waypoints=" + waypoint 
				+ "&key=" + AppConfig.GOOGLE_API_KEY;


		RestTemplate restTemplate = new RestTemplate();
		DirectionsResponse resp = restTemplate.getForObject(url, DirectionsResponse.class);
		
		// FIXME: null checks
		if (true) {
			Step step = resp.getRoutes().get(0).getLegs().get(0).getSteps().get(0);
			Location start = step.getStartLocation();
			Location end = step.getEndLocation();
			// TODO: do something with this information
		}
	}
}
