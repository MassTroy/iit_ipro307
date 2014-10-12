package iit.ipro497.domain.data;

import java.util.Date;

import common.util.DateDurationCalculator;
import common.util.DateFormatter;

public class RouteSummary {
	private final String title;
	private final Date depart;
	private final Date arrive;
	private final double miles;
	private final TemperatureSummary temperatureSummary;
	private final TemperatureUnit unit;

	public RouteSummary(Route route, TemperatureSummary temperatureSummary, TemperatureUnit unit) {
		this.title = route.getSummary();
		this.depart = route.getDepart();
		this.arrive = route.getArrive();
		this.miles = route.getMiles();
		this.temperatureSummary = temperatureSummary;
		this.unit = unit;
	}

	public String getTitle() {
		return title;
	}

	public String getArrivalTimeString() {
		return DateFormatter.formatDate(arrive);
	}

	public String getDurationString() {
		return DateDurationCalculator.duration(depart, arrive);
	}

	public double getMiles() {
		return miles;
	}

	public TemperatureUnit getTempUnit() {
		return unit;
	}

	public double getMinTemp() {
		return temperatureSummary.getMinTemp().getTemperature(unit);
	}

	public double getMaxTemp() {
		return temperatureSummary.getMaxTemp().getTemperature(unit);
	}

	public double getFinalTemp() {
		return temperatureSummary.getFinalTemp().getTemperature(unit);
	}

	public double getAverageTemp() {
		return temperatureSummary.getAverageTemp().getTemperature(unit);
	}

	@Override
	public String toString() {
		return "RouteSummary [title=" + title + ", depart=" + depart + ", arrive=" + arrive + ", miles=" + miles + ", temperatureSummary="
				+ temperatureSummary + "]";
	}
}
