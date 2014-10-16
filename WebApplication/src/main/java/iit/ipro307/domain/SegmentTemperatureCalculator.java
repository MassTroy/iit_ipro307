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
	private static final double mass = 3500;
	private static final double specificHeat = 490;
	private static final double area = 101.0785;
	// convection
	private static final double rhoAir = 1.184;
	private static final double velocity = 24.5872; // 55 mph
	private static final double length = 12.192;
	private static final double muAir = 1.983e5;
	private static final double reynolds = (rhoAir * velocity * length) / muAir;
	private static final double lp = 1005.0;
	private static final double kAir = 0.0257;
	private static final double pressure = (lp * muAir) / kAir;
	private static final double nusselt = 0.037 * Math.pow(reynolds, 0.8) * Math.pow(pressure, 1.0/3.0);
	// conduction
	final double kw = 16;
	final double deltaX = 0.00478;
	
	@Autowired
	private PrefixLogger log;
	
	Random random = new Random();

	public Temperature computeFinalTemp(Temperature currentTemp, WeatherData weather, long duration) {
		double finalTemp = currentTemp.getCelcius();

		finalTemp += convection(currentTemp, weather, duration);
		
		//finalTemp += conduction(currentTemp, weather, duration);
		
		finalTemp += solarRadiation(weather, duration, new Date());
		
		finalTemp += rainEffect(weather, duration);
		
		return new Temperature(finalTemp);
	}

	private double convection(Temperature currentTemp, WeatherData weather, long duration) {
		// inputs
		final double tempOutside = weather.getTemperature().getKelvin();
		final double tempCurrent = currentTemp.getKelvin();
		
		// calcuations
		final double convectionWatts = nusselt * kAir * area * (tempOutside - tempCurrent);
		final double convectionDelta = (duration * convectionWatts) / (mass * specificHeat);
		
		return convectionDelta;
	}

	private double conduction(Temperature currentTemp, WeatherData weather, long duration) {
		// inputs
		final double tempOutside = weather.getTemperature().getKelvin();
		final double tempCurrent = currentTemp.getKelvin();
		
		// calcuations
		final double conductionWatts = (kw * area * (tempOutside - tempCurrent)) / deltaX;
		final double conductionDelta = (duration * conductionWatts) / (mass * specificHeat);

		log.debug("Conduction delta temp. celcius=" + conductionDelta);
		return conductionDelta;
	}

	private double solarRadiation(WeatherData weather, long duration, Date date) {
		final long sunrise = weather.getSunrise().getTime();
		final long sunset = weather.getSunset().getTime();
		final long current = date.getTime();
		
		final double solarDelta;
		
		if (current < sunset && current > sunrise) {
			// day time
			
			// inputs
			// TODO: include latitude
			final double solarAngle = Math.PI * (current - sunrise) / (sunset - sunrise);
			final double skyCover = weather.getSkyCover().getPercentageMultiplier();
			
			// calcuations
			final double r0 = 990 * Math.sin(solarAngle) - 30;
			final double solarWatts = r0 * (1 - (0.75 * Math.pow(skyCover, 3.4)));
			
			solarDelta = (duration * solarWatts) / (mass * specificHeat);
		} else {
			// night time
			// TODO: outgoing radiation effect
			solarDelta = 0;
		}
		
		return solarDelta;
	}
	
	private double rainEffect(WeatherData weather, long duration) {
		// TODO: rain effects
		return 0;
	}

}
