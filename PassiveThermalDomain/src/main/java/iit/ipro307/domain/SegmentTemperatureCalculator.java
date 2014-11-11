package iit.ipro307.domain;

import iit.ipro307.domain.data.Temperature;
import iit.ipro307.domain.data.TemperatureUnit;
import iit.ipro307.domain.data.WeatherData;

import java.util.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import common.util.PrefixLogger;

/**
 * Compute temperatures for each segment of the route based on weather data.
 * This class contains the entire thermal model
 * @author Troy Mass, Chad Hemindinger
 */
@Service
public class SegmentTemperatureCalculator {
	private static final double solarWattsPerMeterSquare = 250.0;
	private static final double solarAbsorbtion = 0.8;

	private static final double velocity = 24.5872; // 55 mph
	private static final double massContainer = 3800;
	private static final double specificHeatSteel = 490;
	private static final double area = 101.0785;
	private static final double rhoAir = 1.184;
	private static final double length = 12.192;
	private static final double muAir = 1.836e-5; // 1.983e5;
	private static final double kAir = 0.0257;
	private static final double prandtl = 0.715; //(Cp * muAir) / kAir;
	
	@Autowired
	private PrefixLogger log;
	
	Random random = new Random();

	public Temperature computeFinalTemperature(Temperature currentTemp, WeatherData weather, long duration, Date startTime, Date endTime) {
		double deltaNewton = deltaNewtonConvection(currentTemp, weather, duration);
		log.debug("deltaNewton="+deltaNewton);
		
		double solarWatts = solarRadiationWatts(weather, startTime, endTime);
		double deltaSolar = (solarWatts * duration) / (massContainer * specificHeatSteel);
		log.debug("deltaSolar="+deltaSolar + ", time="+new Date((startTime.getTime() + endTime.getTime()) / 2));
		
		double finalTemp = currentTemp.getKelvin() + deltaNewton + deltaSolar;
		return new Temperature(finalTemp , TemperatureUnit.Kelvin);
	}
	
	private double deltaNewtonConvection(Temperature currentTemp, WeatherData weather, long duration) {
		final double reynoldsExterior = (rhoAir * velocity * length) / muAir;
		final double nusseltExterior = 0.33 * Math.pow(reynoldsExterior, 0.5) * Math.pow(prandtl, 1.0/3.0);
		final double hfc = ((nusseltExterior * kAir) / length);
		final double k = hfc * area / (specificHeatSteel * massContainer);
		//final double k = 1.48e-4;
		
		double outsideTemp = weather.getTemperature().getKelvin();
		double initialTemp = currentTemp.getKelvin();
		
		double delta = (outsideTemp + (initialTemp - outsideTemp) * Math.exp(-1 * k * duration)) - initialTemp;
		
		return delta;
	}

	private double solarRadiationWatts(WeatherData weather, Date startTime, Date endTime) {
		final long sunrise = weather.getSunrise().getTime();
		final long sunset = weather.getSunset().getTime();
		final long current = (startTime.getTime() + endTime.getTime()) / 2;
		
		final double solarWatts;
		
		if (current < sunset && current > sunrise) {
			// day time
			
			// inputs
			// TODO: include latitude
			final double solarAngle = Math.PI * (current - sunrise) / (sunset - sunrise);
			final double skyCover = weather.getSkyCover().getPercentageMultiplier();
			
			// calcuations
			double skyCoverAbsorbtion = 1.0 - (0.75 * Math.pow(skyCover, 3.4));
			solarWatts = solarWattsPerMeterSquare * solarAbsorbtion *
					Math.sin(solarAngle) * 
					skyCoverAbsorbtion * 
					(area / 4.0);
		} else {
			// night time
			// TODO: outgoing radiation effect
			solarWatts = 0;
		}

		return solarWatts;
	}

}
