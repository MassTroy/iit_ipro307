package iit.ipro497.domain.data;

import java.util.Date;

import org.openweathermap.api.common.Clouds;
import org.openweathermap.api.common.Main;
import org.openweathermap.api.common.Sys;
import org.openweathermap.api.common.Wind;

public class WeatherData {
	// NOTE: all units are in metric
	// celcius, meters per second, or percentage
	
	private final double temperature;
	private final double pressure;
	private final int humidity;
	private final double tempMin;
	private final double tempMax;
	private final double windSpeed;
	private final int windDirection;
	private final int skyCover;
	private final Date date;
	private final String name;
	private final Date sunrise;
	private final Date sunset;

	public WeatherData(Sys sys, Main main, Wind wind, Clouds clouds, long dt, String name) {
		this.temperature = main.getTemp();
		this.pressure = main.getPressure();
		this.humidity = (int) main.getHumidity();
		this.tempMin = main.getTempMin();
		this.tempMax = main.getTempMax();
		this.windSpeed = wind.getSpeed();
		this.windDirection = (int) wind.getDeg();
		this.skyCover = (int) clouds.getAll();
		this.date = new Date(dt*1000L);
		this.name = name;
		this.sunrise = new Date(sys.getSunrise()*1000L);
		this.sunset = new Date(sys.getSunset()*1000L);
	}
	
	public WeatherData(double temperature, double pressure, int humidity, double tempMin, double tempMax, double windSpeed,
			int windDirection, int skyCover, Date date, String name, Date sunrise, Date sunset) {
		this.temperature = temperature;
		this.pressure = pressure;
		this.humidity = humidity;
		this.tempMin = tempMin;
		this.tempMax = tempMax;
		this.windSpeed = windSpeed;
		this.windDirection = windDirection;
		this.skyCover = skyCover;
		this.date = date;
		this.name = name;
		this.sunrise = sunrise;
		this.sunset = sunset;
	}

	public double getTemperature() {
		return temperature;
	}

	public double getPressure() {
		return pressure;
	}

	public int getHumidity() {
		return humidity;
	}

	public double getTempMin() {
		return tempMin;
	}

	public double getTempMax() {
		return tempMax;
	}

	public double getWindSpeed() {
		return windSpeed;
	}

	public int getWindDirection() {
		return windDirection;
	}

	public int getSkyCover() {
		return skyCover;
	}

	public Date getDate() {
		return date;
	}

	public String getName() {
		return name;
	}

	public Date getSunrise() {
		return sunrise;
	}

	public Date getSunset() {
		return sunset;
	}

	@Override
	public String toString() {
		return "WeatherData [temperature=" + temperature + ", pressure=" + pressure + ", humidity=" + humidity + ", tempMin=" + tempMin
				+ ", tempMax=" + tempMax + ", windSpeed=" + windSpeed + ", windDirection=" + windDirection + ", skyCover=" + skyCover
				+ ", date=" + date + ", name=" + name + ", sunrise=" + sunrise + ", sunset=" + sunset + "]";
	}

}
