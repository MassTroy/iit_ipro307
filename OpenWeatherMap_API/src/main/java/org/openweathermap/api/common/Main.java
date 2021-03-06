package org.openweathermap.api.common;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;

@JsonPropertyOrder({
		"temp",
		"temp_min",
		"temp_max",
		"pressure",
		"sea_level",
		"grnd_level",
		"humidity"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class Main {

	@JsonProperty("temp")
	private double temp;
	@JsonProperty("temp_min")
	private double tempMin;
	@JsonProperty("temp_max")
	private double tempMax;
	@JsonProperty("pressure")
	private double pressure;
	@JsonProperty("sea_level")
	private double seaLevel;
	@JsonProperty("grnd_level")
	private double grndLevel;
	@JsonProperty("humidity")
	private long humidity;

	@JsonProperty("temp")
	public double getTemp() {
		return temp;
	}

	@JsonProperty("temp")
	public void setTemp(double temp) {
		this.temp = temp;
	}

	@JsonProperty("temp_min")
	public double getTempMin() {
		return tempMin;
	}

	@JsonProperty("temp_min")
	public void setTempMin(double tempMin) {
		this.tempMin = tempMin;
	}

	@JsonProperty("temp_max")
	public double getTempMax() {
		return tempMax;
	}

	@JsonProperty("temp_max")
	public void setTempMax(double tempMax) {
		this.tempMax = tempMax;
	}

	@JsonProperty("pressure")
	public double getPressure() {
		return pressure;
	}

	@JsonProperty("pressure")
	public void setPressure(double pressure) {
		this.pressure = pressure;
	}

	@JsonProperty("sea_level")
	public double getSeaLevel() {
		return seaLevel;
	}

	@JsonProperty("sea_level")
	public void setSeaLevel(double seaLevel) {
		this.seaLevel = seaLevel;
	}

	@JsonProperty("grnd_level")
	public double getGrndLevel() {
		return grndLevel;
	}

	@JsonProperty("grnd_level")
	public void setGrndLevel(double grndLevel) {
		this.grndLevel = grndLevel;
	}

	@JsonProperty("humidity")
	public long getHumidity() {
		return humidity;
	}

	@JsonProperty("humidity")
	public void setHumidity(long humidity) {
		this.humidity = humidity;
	}

	@Override
	public String toString() {
		return "Main [temp=" + temp + ", tempMin=" + tempMin + ", tempMax=" + tempMax + ", pressure=" + pressure + ", seaLevel=" + seaLevel
				+ ", grndLevel=" + grndLevel + ", humidity=" + humidity + "]";
	}

}
