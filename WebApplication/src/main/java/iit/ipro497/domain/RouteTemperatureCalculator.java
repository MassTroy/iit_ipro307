package iit.ipro497.domain;

import iit.ipro497.domain.client.OpenWeatherMapClient;
import iit.ipro497.domain.data.Route;
import iit.ipro497.domain.data.RouteSegment;
import iit.ipro497.domain.data.TemperatureSummary;
import iit.ipro497.domain.data.WeatherData;
import iit.ipro497.exception.BadRequestException;
import iit.ipro497.thermal.model.FormData;

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

	public TemperatureSummary computeTempertature(Route route, FormData form) throws BadRequestException {
		double minTemp = form.getStartTemp();
		double maxTemp = form.getStartTemp();
		double averageTemp = form.getStartTemp();
		long duration = 0;
		double currentTemp = form.getStartTemp();
		
		for (RouteSegment segment : route.getSegments()) {
			WeatherData weather = openWeatherMapClient.getWeather(segment.getEndLocation(), new Date());
			long segmentDuration = segment.getDuration();
			currentTemp = segmentTemperatureCalculator.computeFinalTemp(currentTemp, weather, segmentDuration);
			
			// update temperature data
			if (currentTemp < minTemp)
				minTemp = currentTemp;
			if (currentTemp > maxTemp)
				maxTemp = currentTemp;
			averageTemp = ((averageTemp * duration) + (currentTemp * segmentDuration)) / (duration + segmentDuration);
			duration += segmentDuration;
		}

		TemperatureSummary tempSummary = new TemperatureSummary(form.getUnit(), minTemp, maxTemp, currentTemp, averageTemp);
		return tempSummary;
	}

}
