package common.util;

public class TemperatureConverter {

	public static double fahrenheitToCelcius(double fahrenheit) {
		return (fahrenheit-32.0) * 5.0 / 9.0;
	}

	public static double celciusToFahrenheit(double celcius) {
		return (celcius * 9.0 / 5.0) + 32.0;
	}

	public static double celciusToKelvin(double celcius) {
		return celcius + 274.15;
	}

}
