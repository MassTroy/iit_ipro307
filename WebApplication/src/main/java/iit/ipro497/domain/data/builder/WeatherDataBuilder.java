package iit.ipro497.domain.data.builder;

import java.util.Date;

import iit.ipro497.domain.data.WeatherData;

public class WeatherDataBuilder {
	
	private double temperature;
	private double pressure;
	private int humidity;
	private double tempMin;
	private double tempMax;
	private double windSpeed;
	private int windDirection;
	private int skyCover;
	private Date date;
	private String name;
	private Date sunrise;
	private Date sunset;

	public WeatherDataBuilder() {
	}
	
	public WeatherData build() {
		return new WeatherData(
				temperature,
				pressure,
				humidity,
				tempMin,
				tempMax,
				windSpeed,
				windDirection,
				skyCover,
				date,
				name,
				sunrise,
				sunset
			);
	}

	public WeatherDataBuilder temperature(double temperature) {
		this.temperature = temperature;
		return this;
	}

	public WeatherDataBuilder pressure(double pressure) {
		this.pressure = pressure;
		return this;
	}

	public WeatherDataBuilder humidity(int humidity) {
		this.humidity = humidity;
		return this;
	}

	public WeatherDataBuilder tempMin(double tempMin) {
		this.tempMin = tempMin;
		return this;
	}

	public WeatherDataBuilder tempMax(double tempMax) {
		this.tempMax = tempMax;
		return this;
	}

	public WeatherDataBuilder windSpeed(double windSpeed) {
		this.windSpeed = windSpeed;
		return this;
	}

	public WeatherDataBuilder windDirection(int windDirection) {
		this.windDirection = windDirection;
		return this;
	}

	public WeatherDataBuilder skyCover(int skyCover) {
		this.skyCover = skyCover;
		return this;
	}

	public WeatherDataBuilder date(Date date) {
		this.date = date;
		return this;
	}

	public WeatherDataBuilder name(String name) {
		this.name = name;
		return this;
	}

	public WeatherDataBuilder sunrise(Date sunrise) {
		this.sunrise = sunrise;
		return this;
	}

	public WeatherDataBuilder sunset(Date sunset) {
		this.sunset = sunset;
		return this;
	}
}
