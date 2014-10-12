package iit.ipro497.domain;

import iit.ipro497.domain.data.Temperature;
import iit.ipro497.domain.data.WeatherData;

import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class SegmentTemperatureCalculator {
	
	Random random = new Random();

	public Temperature computeFinalTemp(Temperature currentTemp, WeatherData weather, long duration) {
		// TODO: random temperature offsets
		return new Temperature(currentTemp.getCelcius() + randomDouble(-5.0, 5.0));
	}

	private double randomDouble(double min, double max) {
		return (random.nextDouble() * (max - min)) + min;
	}

}
