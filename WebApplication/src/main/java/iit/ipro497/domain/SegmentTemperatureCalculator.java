package iit.ipro497.domain;

import iit.ipro497.domain.data.Temperature;
import iit.ipro497.domain.data.WeatherData;

import java.util.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import common.util.PrefixLogger;

@Service
public class SegmentTemperatureCalculator {
	private static final double SOLAR_CONSTANT = 7.0/60.0/60.0; // 7 degrees per hour at full strength
	
	@Autowired
	private PrefixLogger log;
	
	Random random = new Random();

	public Temperature computeFinalTemp(Temperature currentTemp, WeatherData weather, long duration) {
		double finalTemp = currentTemp.getCelcius();

		finalTemp += ambientEffect(currentTemp, weather, duration);
		
		finalTemp += radiationEffect(weather, duration, new Date());
		
		finalTemp += rainEffect(weather, duration);
		
		return new Temperature(finalTemp);
	}

	private double ambientEffect(Temperature currentTemp, WeatherData weather, long duration) {
		// TODO: ambient temperature effects
		// TODO: wind effect
		
		// one sixth of the delta every 15 minutes
		double ambientDelta = 0;
		for (long d=duration; d>0; d -= 15*60) {
			ambientDelta += (weather.getTemperature().getCelcius() - (currentTemp.getCelcius() + ambientDelta)) / 6.0;
		}

		log.trace("Ambient delta temp. celcius=" + ambientDelta);
		return ambientDelta;
	}

	private double radiationEffect(WeatherData weather, long duration, Date date) {
		// TODO: solar radiation effects
		double solarDelta;
		
		long sunrise = weather.getSunrise().getTime();
		long sunset = weather.getSunset().getTime();
		long current = date.getTime();
		
		if (current < sunset && current > sunrise) {
			// day time
			double skyCover = weather.getSkyCover().getPercentageMultiplier();
			
			// TODO: include latitude
			double solarAngle = Math.PI * (current - sunrise) / (sunset - sunrise);
			solarDelta = SOLAR_CONSTANT * Math.sin(solarAngle) * (1 - skyCover) * duration;
		} else {
			// night time
			// TODO: outgoing radiation effect
			solarDelta = 0;
		}
		
		log.debug("Solar delta temp. celcius=" + solarDelta);
		return solarDelta;
	}

	private double rainEffect(WeatherData weather, long duration) {
		// TODO: rain effects
		return 0;
	}

}
