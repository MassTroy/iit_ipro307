package iit.ipro307.domain;

import iit.ipro307.domain.client.OpenWeatherMapClient;
import iit.ipro307.domain.data.Route;
import iit.ipro307.domain.data.RouteSegment;
import iit.ipro307.domain.data.Temperature;
import iit.ipro307.domain.data.TemperatureSummary;
import iit.ipro307.domain.data.WeatherData;
import iit.ipro307.exception.BadRequestException;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import common.util.PrefixLogger;

@Service
public class RouteTemperatureCalculator {
	@Autowired
	private PrefixLogger log;
	@Autowired
	private OpenWeatherMapClient openWeatherMapClient;
	@Autowired
	private SegmentTemperatureCalculator segmentTemperatureCalculator;

	public TemperatureSummary computeTempertature(Route route, Temperature startingTemp) throws BadRequestException {
		double minTemp = startingTemp.getCelcius();
		double maxTemp = startingTemp.getCelcius();
		double averageTemp = startingTemp.getCelcius();
		long duration = 0;
		Temperature currentInterior = startingTemp;
		
		for (RouteSegment segment : route.getSegments()) {
			WeatherData weather = openWeatherMapClient.getWeather(segment.getEndLocation(), new Date());
			long segmentDuration = segment.getDuration();
			currentInterior = segmentTemperatureCalculator.computeFinalTemperature(currentInterior, weather, segmentDuration);
			
			// update temperature data
			if (currentInterior.getCelcius() < minTemp)
				minTemp = currentInterior.getCelcius();
			if (currentInterior.getCelcius() > maxTemp)
				maxTemp = currentInterior.getCelcius();
			averageTemp = ((averageTemp * duration) + (currentInterior.getCelcius() * segmentDuration)) / (duration + segmentDuration);
			duration += segmentDuration;
			log.debug("Temperature after segment. celcius=" + currentInterior.getCelcius());
		}

		TemperatureSummary tempSummary = new TemperatureSummary(new Temperature(minTemp), new Temperature(maxTemp), currentInterior, new Temperature(averageTemp));
		return tempSummary;
	}

}
