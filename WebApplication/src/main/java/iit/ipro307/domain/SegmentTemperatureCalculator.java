package iit.ipro307.domain;

import iit.ipro307.domain.data.Temperature;
import iit.ipro307.domain.data.WeatherData;

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

		finalTemp += convection(currentTemp, weather, duration);
		
		finalTemp += radiationEffect(weather, duration, new Date());
		
		finalTemp += rainEffect(weather, duration);
		
		return new Temperature(finalTemp);
	}

	private double convection(Temperature currentTemp, WeatherData weather, long duration) {
		// constants
		final double pAir = 1.184;
		final double v = 24.5872; // 55 mph
		final double l = 12.192;
		final double uAir = 1.983 * 10000;
		final double re = (pAir * v * l) / uAir;
		final double lp = 1005.0;
		final double kAir = 0.0257;
		final double pr = (lp * uAir) / kAir;
		final double nu = 0.037 * Math.pow(re, 0.8) * Math.pow(pr, 1.0/3.0);
		final double aw = 101.0785;
		final double mass = 3500;
		final double specificHeat = 490;
		
		// inputs
		final double tempOutside = weather.getTemperature().getKelvin();
		final double tempCurrent = currentTemp.getKelvin();
		
		// calcuations
		final double convectionWatts = nu * kAir * aw * (tempOutside - tempCurrent);
		final double convectionDelta = (duration / (mass * specificHeat)) * convectionWatts;
		
		return convectionDelta;
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
