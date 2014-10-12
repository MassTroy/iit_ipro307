package iit.ipro497.domain.data;

import java.util.Date;

import org.openweathermap.api.common.Clouds;
import org.openweathermap.api.common.Main;
import org.openweathermap.api.common.Sys;
import org.openweathermap.api.common.Wind;

public class WeatherData {
	private final Temperature temperature;
	private final double pressure;
	private final Percentage humidity;
	private final Temperature tempMin;
	private final Temperature tempMax;
	private final Speed windSpeed;
	private final int windDirection;
	private final Percentage skyCover;
	private final Date date;
	private final String name;
	private final Date sunrise;
	private final Date sunset;

	public WeatherData(Sys sys, Main main, Wind wind, Clouds clouds, long dt, String name) {
		this.temperature = new Temperature(main.getTemp());
		this.pressure = main.getPressure();
		this.humidity = new Percentage(main.getHumidity());
		this.tempMin = new Temperature(main.getTempMin());
		this.tempMax = new Temperature(main.getTempMax());
		this.windSpeed = new Speed(wind.getSpeed());
		this.windDirection = (int) wind.getDeg();
		this.skyCover = new Percentage(clouds.getAll());
		this.date = new Date(dt*1000L);
		this.name = name;
		this.sunrise = new Date(sys.getSunrise()*1000L);
		this.sunset = new Date(sys.getSunset()*1000L);
	}

	public Temperature getTemperature() {
		return temperature;
	}

	public double getPressure() {
		return pressure;
	}

	public Percentage getHumidity() {
		return humidity;
	}

	public Temperature getTempMin() {
		return tempMin;
	}

	public Temperature getTempMax() {
		return tempMax;
	}

	public Speed getWindSpeed() {
		return windSpeed;
	}

	public int getWindDirection() {
		return windDirection;
	}

	public Percentage getSkyCover() {
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
