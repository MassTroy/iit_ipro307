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
	private static final double massContainer = 3800;
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

	public Temperature computeFinalTemperature(Temperature currentTemp, WeatherData weather, long duration) {
		double deltaNewton = deltaNewtonConvection(currentTemp, weather, duration);
		log.debug("deltaNewton="+deltaNewton);
		
		double solarWatts = solarRadiationWatts(weather, new Date()); // TODO adjust date based on segment
		double deltaSolar = (solarWatts * duration) / (massContainer * specificHeatSteel);
		log.debug("deltaSolar="+deltaSolar);
		
		double finalTemp = currentTemp.getKelvin() + deltaNewton + deltaSolar;
		return new Temperature(finalTemp , TemperatureUnit.Kelvin);
	}
	
	private double deltaNewtonConvection(Temperature currentTemp, WeatherData weather, long duration) {
		final double velocity = 24.5872; // 55 mph
		final double reynoldsExterior = (rhoAir * velocity * length) / muAir;
		final double nusseltExterior = 0.33 * Math.pow(reynoldsExterior, 0.5) * Math.pow(prandtl, 1.0/3.0);
		final double hfc = ((nusseltExterior * kAir) / length);
		final double k = hfc * area / (specificHeatSteel * massContainer);
		//final double k = 1.48e-4;
		
		double outsideTemp = weather.getTemperature().getKelvin();
		double initialTemp = currentTemp.getKelvin();
		
		double delta = (outsideTemp + (initialTemp - outsideTemp) * Math.exp(-1 * k * duration)) - initialTemp;
				//temp(t) = TempOutside + (TempInitial - TempOutside) * e ^ (-constant * t)
		
		return delta;
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
		
		return wallsToInteriorWatts;
	}

}
