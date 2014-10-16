package iit.ipro307.domain;

import iit.ipro307.domain.data.Temperature;
import iit.ipro307.domain.data.TemperatureUnit;
import iit.ipro307.domain.data.WeatherData;

import java.util.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import common.util.PrefixLogger;

@Service
public class SegmentTemperatureCalculator {
	private static final double massContainer = 3500;
	private static final double specificHeatSteel = 490;
	private static final double massAir = 85.829;
	private static final double specificHeatAir = 1.006;
	private static final double area = 101.0785;
	private static final double rhoAir = 1.184;
	private static final double length = 12.192;
	private static final double muAir = 1.983e5;
	private static final double lp = 1005.0;
	private static final double kAir = 0.0257;
	private static final double pressure = (lp * muAir) / kAir;
	
	@Autowired
	private PrefixLogger log;
	
	Random random = new Random();

	public Temperature computeFinalTemp(Temperature currentTemp, WeatherData weather, long duration) {
		double watts = 0;
		watts += convectionWatts(currentTemp, weather);
		//watts += conductionWatts(currentTemp, weather);
		watts += solarRadiationWatts(weather, new Date());
		watts += rainWatts(weather);
		
		double wallTemp = ((watts * duration) / (massContainer * specificHeatSteel)) + currentTemp.getKelvin();
		
		double wallsToInteriorWatts = wallsToInteriorWatts(currentTemp, wallTemp, duration);
		
		double airTemp = (duration * wallsToInteriorWatts) / (massAir * specificHeatAir);

		//return new Temperature(airTemp, TemperatureUnit.Kelvin);
		return new Temperature(wallTemp, TemperatureUnit.Kelvin);
	}

	private double convectionWatts(Temperature currentTemp, WeatherData weather) {
		final double velocity = 24.5872; // 55 mph
		final double reynoldsExterior = (rhoAir * velocity * length) / muAir;
		final double nusseltExterior = 0.037 * Math.pow(reynoldsExterior, 0.8) * Math.pow(pressure, 1.0/3.0);
		
		// inputs
		final double tempOutside = weather.getTemperature().getKelvin();
		final double tempCurrent = currentTemp.getKelvin();
		
		// calcuations
		final double convectionWatts = nusseltExterior * kAir * area * (tempOutside - tempCurrent);
		
		return convectionWatts;
	}

	private double conductionWatts(Temperature currentTemp, WeatherData weather) {
		final double kw = 16;
		final double deltaX = 0.00478;
		
		// inputs
		final double tempOutside = weather.getTemperature().getKelvin();
		final double tempCurrent = currentTemp.getKelvin();
		
		// calcuations
		final double conductionWatts = (kw * area * (tempOutside - tempCurrent)) / deltaX;
		
		return conductionWatts;
	}

	private double solarRadiationWatts(WeatherData weather, Date date) {
		final long sunrise = weather.getSunrise().getTime();
		final long sunset = weather.getSunset().getTime();
		final long current = date.getTime();
		
		final double solarWatts;
		
		if (current < sunset && current > sunrise) {
			// day time
			
			// inputs
			// TODO: include latitude
			final double solarAngle = Math.PI * (current - sunrise) / (sunset - sunrise);
			final double skyCover = weather.getSkyCover().getPercentageMultiplier();
			
			// calcuations
			final double r0 = 990 * Math.sin(solarAngle) - 30;
			solarWatts = r0 * (1 - (0.75 * Math.pow(skyCover, 3.4)));
		} else {
			// night time
			// TODO: outgoing radiation effect
			solarWatts = 0;
		}
		
		return solarWatts;
	}
	
	private double rainWatts(WeatherData weather) {
		// TODO: rain effects
		return 0;
	}

	private double wallsToInteriorWatts(Temperature currentTemp, double wallTemp, double duration) {
		final double reynoldsInterior = (rhoAir * length) / muAir;
		final double nusseltInterior = 0.037 * Math.pow(reynoldsInterior, 0.5) * Math.pow(pressure, 1.0/3.0);
		
		double wallsToInteriorWatts = nusseltInterior * kAir / length * area * (wallTemp - currentTemp.getKelvin());
		
		return wallsToInteriorWatts;
	}

}
