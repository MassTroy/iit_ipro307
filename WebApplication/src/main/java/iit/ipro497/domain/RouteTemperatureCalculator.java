package iit.ipro497.domain;

import iit.ipro497.domain.data.Route;
import iit.ipro497.domain.data.TemperatureSummary;
import iit.ipro497.thermal.model.FormData;

import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class RouteTemperatureCalculator {
	Random random = new Random();

	public TemperatureSummary computeTempertature(Route reduced, FormData form) {
		// TODO: random temperatures
		double minTemp = randomDouble(10, 50);
		double maxTemp = randomDouble(51, 110);
		double finalTemp = randomDouble(minTemp, maxTemp);
		double averageTemp = randomDouble(minTemp, maxTemp);
		
		TemperatureSummary tempSummary = new TemperatureSummary(form.getUnit(), minTemp, maxTemp, finalTemp, averageTemp);
		return tempSummary;
	}

	private double randomDouble(double min, double max) {
		return (random.nextDouble() * (max-min)) + min;
	}

}
