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
	private static final double muAir = 1.836e-5; // 1.983e5;
	private static final double Cp = 1005.0;
	private static final double kAir = 0.0257;
	private static final double prandtl = 0.715; //(Cp * muAir) / kAir;
	
	@Autowired
	private PrefixLogger log;
	
	Random random = new Random();

	public Temperature computeFinalWallTemp(Temperature currentWall, WeatherData weather, long duration) {
		double watts = 0;
		watts += convectionWatts(currentWall, weather);
		//watts += solarRadiationWatts(weather, new Date());
		//watts += rainWatts(weather);
		log.debug("watts: " + watts);
		
		double wallTemp = ((watts * duration) / (massContainer * specificHeatSteel)) + currentWall.getKelvin();
		
		return new Temperature(wallTemp, TemperatureUnit.Kelvin);
	}
	public Temperature computeFinalInteriorTemp(Temperature currentInterior, Temperature finalWall, WeatherData weather, long duration) {
		double wallsToInteriorWatts = wallsToInteriorWatts(currentInterior, finalWall.getKelvin());

		double airTemp = ((duration * wallsToInteriorWatts) / (massAir * specificHeatAir)) + currentInterior.getKelvin();

		return new Temperature(airTemp, TemperatureUnit.Kelvin);
	}

	private double convectionWatts(Temperature currentTemp, WeatherData weather) {
		final double velocity = 24.5872; // 55 mph
		final double reynoldsExterior = (rhoAir * velocity * length) / muAir;
		final double nusseltExterior = 0.33 * Math.pow(reynoldsExterior, 0.5) * Math.pow(prandtl, 1.0/3.0);
		final double hfc = ((nusseltExterior * kAir) / length);
		
		// inputs
		final double tempOutside = weather.getTemperature().getKelvin();
		final double tempCurrent = currentTemp.getKelvin();
		
		// calcuations
		final double convectionWatts = hfc * area * (tempOutside - tempCurrent);
		
		log.debug("Convection watts: " + convectionWatts);
		return convectionWatts;
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
			solarWatts = (r0 * (1 - (0.75 * Math.pow(skyCover, 3.4)))) / area;
		} else {
			// night time
			// TODO: outgoing radiation effect
			solarWatts = 0;
		}

		log.debug("Solar watts: " + solarWatts);
		return solarWatts;
	}
	
	private double rainWatts(WeatherData weather) {
		// TODO: rain effects
		return 0;
	}

	private double wallsToInteriorWatts(Temperature currentTemp, double wallTemp) {
		final double heatTransferCoef = 2.73; // 7.9;
		final double reynoldsInterior = (rhoAir * length) / muAir;
		final double nusseltInterior = 0.037 * Math.pow(reynoldsInterior, 0.5) * Math.pow(prandtl, 1.0/3.0);
		
		double wallsToInteriorWatts = heatTransferCoef * area * (wallTemp - currentTemp.getKelvin());
		
		log.debug("wallToInteriorWatts: " + wallsToInteriorWatts);
		return wallsToInteriorWatts;
	}

}
