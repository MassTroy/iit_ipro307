package iit.ipro497.domain.client;

import iit.ipro497.config.AppConfig;
import iit.ipro497.domain.data.GeoCoordinate;
import iit.ipro497.domain.data.WeatherData;
import iit.ipro497.exception.BadRequestException;

import java.util.Date;

import org.openweathermap.api.weather.CurrentWeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import common.util.PrefixLogger;

@Service
public class OpenWeatherMapClient {
	private static final String API_WEATHER_URL = "http://api.openweathermap.org/data/2.5/weather?units=metric&";
	private static final String API_KEY_SUFFIX = "&APPID=" + AppConfig.OPEN_WEATHER_MAP_API_KEY;

	@Autowired
	private PrefixLogger log;

	public WeatherData getWeather(GeoCoordinate location, Date date) throws BadRequestException {
		String url = API_WEATHER_URL 
				+ "lat=" + location.getLatitude()
				+ "&lon=" + location.getLongitude()
				+ API_KEY_SUFFIX;
		
		return queryWeather(url);
	}

	public WeatherData getWeather(String location, Date date) throws BadRequestException {
		String url = API_WEATHER_URL 
				+ "q=" + location
				+ API_KEY_SUFFIX;
		
		return queryWeather(url);
	}

	private WeatherData queryWeather(String url) throws BadRequestException {
		log.debug("Getting weather. url=" + url);
		RestTemplate restTemplate = new RestTemplate();
		CurrentWeatherResponse resp = restTemplate.getForObject(url, CurrentWeatherResponse.class);
		
		if (resp != null) {
			WeatherData weather = new WeatherData(resp.getSys(), resp.getMain(), resp.getWind(), resp.getClouds(), resp.getDt(), resp.getName());
			log.trace("Got weather. weather=" + weather);
			return weather;
		}
		
		throw new BadRequestException("Unable to query weather. url=" + url);
	}

}
