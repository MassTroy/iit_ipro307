package org.openweathermap.api.common;

import java.util.ArrayList;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;

@JsonPropertyOrder({
		"dt",
		"main",
		"weather",
		"clouds",
		"wind",
		"rain",
		"sys",
		"dt_txt"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherDataPoint {

	@JsonProperty("dt")
	private long dt;
	@JsonProperty("main")
	private Main main;
	@JsonProperty("weather")
	private java.util.List<Weather> weather = new ArrayList<Weather>();
	@JsonProperty("clouds")
	private Clouds clouds;
	@JsonProperty("wind")
	private Wind wind;
	@JsonProperty("rain")
	private Rain rain;
	@JsonProperty("sys")
	private Sys sys;
	@JsonProperty("dt_txt")
	private String dtTxt;

	@JsonProperty("dt")
	public long getDt() {
		return dt;
	}

	@JsonProperty("dt")
	public void setDt(long dt) {
		this.dt = dt;
	}

	@JsonProperty("main")
	public Main getMain() {
		return main;
	}

	@JsonProperty("main")
	public void setMain(Main main) {
		this.main = main;
	}

	@JsonProperty("weather")
	public java.util.List<Weather> getWeather() {
		return weather;
	}

	@JsonProperty("weather")
	public void setWeather(java.util.List<Weather> weather) {
		this.weather = weather;
	}

	@JsonProperty("clouds")
	public Clouds getClouds() {
		return clouds;
	}

	@JsonProperty("clouds")
	public void setClouds(Clouds clouds) {
		this.clouds = clouds;
	}

	@JsonProperty("wind")
	public Wind getWind() {
		return wind;
	}

	@JsonProperty("wind")
	public void setWind(Wind wind) {
		this.wind = wind;
	}

	@JsonProperty("rain")
	public Rain getRain() {
		return rain;
	}

	@JsonProperty("rain")
	public void setRain(Rain rain) {
		this.rain = rain;
	}

	@JsonProperty("sys")
	public Sys getSys() {
		return sys;
	}

	@JsonProperty("sys")
	public void setSys(Sys sys) {
		this.sys = sys;
	}

	@JsonProperty("dt_txt")
	public String getDtTxt() {
		return dtTxt;
	}

	@JsonProperty("dt_txt")
	public void setDtTxt(String dtTxt) {
		this.dtTxt = dtTxt;
	}

	@Override
	public String toString() {
		return "WeatherDataPoint [dt=" + dt + ", main=" + main + ", weather=" + weather + ", clouds=" + clouds + ", wind=" + wind
				+ ", rain=" + rain + ", sys=" + sys + ", dtTxt=" + dtTxt + "]";
	}

}
