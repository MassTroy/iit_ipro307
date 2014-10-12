package iit.ipro497.domain;

import java.util.Random;

import iit.ipro497.domain.data.WeatherData;

import org.springframework.stereotype.Service;

@Service
public class SegmentTemperatureCalculator {
	
	Random random = new Random();

	public double computeFinalTemp(double currentTemp, WeatherData weather, long duration) {
		// TODO: random temperature offsets
		return currentTemp + randomDouble(-5.0, 5.0);
	}

	private double randomDouble(double min, double max) {
		return (random.nextDouble() * (max - min)) + min;
	}

}
