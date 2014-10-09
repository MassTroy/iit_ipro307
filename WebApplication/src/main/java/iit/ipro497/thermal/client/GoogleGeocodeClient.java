package iit.ipro497.thermal.client;

import iit.ipro497.thermal.config.AppConfig;
import iit.ipro497.thermal.exception.BadRequestException;
import iit.ipro497.thermal.model.data.GeoCoordinate;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.google.api.geocode.resp.GeocodingResponse;
import com.google.api.geocode.resp.Location;

@Service
public class GoogleGeocodeClient {
	private static final String GEOCODE_JSON_ADDRESS = "https://maps.googleapis.com/maps/api/geocode/json?address=";

	public GeoCoordinate getGeoCoordinate(String locationName) throws BadRequestException {
		String reqUrl = GEOCODE_JSON_ADDRESS + locationName + "&key=" + AppConfig.GOOGLE_API_KEY;

		RestTemplate restTemplate = new RestTemplate();
		GeocodingResponse resp = restTemplate.getForObject(reqUrl, GeocodingResponse.class);

		if (	resp != null &&
				resp.getResults() != null && resp.getResults().size() >= 1 &&
				resp.getResults().get(0) != null &&
				resp.getResults().get(0).getGeometry() != null &&
				resp.getResults().get(0).getGeometry().getLocation() != null &&
				resp.getStatus() != null &&
				resp.getStatus().equals("OK")) {
			
			Location location = resp.getResults().get(0).getGeometry().getLocation();
			return new GeoCoordinate(location);
		}
		
		throw new BadRequestException("Invalid request to google geocode api. locationName=" + locationName);
	}
}
