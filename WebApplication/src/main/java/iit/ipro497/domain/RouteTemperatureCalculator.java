package iit.ipro497.domain;

import iit.ipro497.domain.client.OpenWeatherMapClient;
import iit.ipro497.domain.data.Route;
import iit.ipro497.domain.data.RouteSegment;
import iit.ipro497.domain.data.Temperature;
import iit.ipro497.domain.data.TemperatureSummary;
import iit.ipro497.domain.data.WeatherData;
import iit.ipro497.exception.BadRequestException;

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
		Temperature currentTemp = startingTemp;
		
		for (RouteSegment segment : route.getSegments()) {
			WeatherData weather = openWeatherMapClient.getWeather(segment.getEndLocation(), new Date());
			long segmentDuration = segment.getDuration();
			currentTemp = segmentTemperatureCalculator.computeFinalTemp(currentTemp, weather, segmentDuration);
			
			// update temperature data
			if (currentTemp.getCelcius() < minTemp)
				minTemp = currentTemp.getCelcius();
			if (currentTemp.getCelcius() > maxTemp)
				maxTemp = currentTemp.getCelcius();
			averageTemp = ((averageTemp * duration) + (currentTemp.getCelcius() * segmentDuration)) / (duration + segmentDuration);
			duration += segmentDuration;
		}

		TemperatureSummary tempSummary = new TemperatureSummary(new Temperature(minTemp), new Temperature(maxTemp), currentTemp, new Temperature(averageTemp));
		return tempSummary;
	}

}
