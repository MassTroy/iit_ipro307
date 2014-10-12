package iit.ipro497.domain.data;

import common.util.TemperatureConverter;

public class Temperature {
	private final double celcius;

	public Temperature(double celcius) {
		this.celcius = celcius;
	}

	public Temperature(double value, TemperatureUnit unit) {
		if (unit == TemperatureUnit.Celsius)
			this.celcius = value;
		else
			this.celcius = TemperatureConverter.fahrenheitToCelcius(value);
	}

	public double getCelcius() {
		return celcius;
	}
	
	public double getFahrenheit() {
		return TemperatureConverter.celciusToFahrenheit(celcius);
	}
	
	public double getTemperature(TemperatureUnit unit) {
		if (unit == TemperatureUnit.Celsius)
			return getCelcius();
		else
			return getFahrenheit();
	}

	@Override
	public String toString() {
		return "Temperature [celcius=" + celcius + "]";
	}

}
