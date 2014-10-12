package org.openweathermap.api.weather;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.openweathermap.api.common.Clouds;
import org.openweathermap.api.common.Coord;
import org.openweathermap.api.common.Main;
import org.openweathermap.api.common.Sys;
import org.openweathermap.api.common.Weather;
import org.openweathermap.api.common.Wind;

@JsonPropertyOrder({
		"coord",
		"sys",
		"weather",
		"base",
		"main",
		"wind",
		"clouds",
		"dt",
		"id",
		"name",
		"cod"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrentWeatherResponse {

	@JsonProperty("coord")
	private Coord coord;
	@JsonProperty("sys")
	private Sys sys;
	@JsonProperty("weather")
	private List<Weather> weather = new ArrayList<Weather>();
	@JsonProperty("base")
	private String base;
	@JsonProperty("main")
	private Main main;
	@JsonProperty("wind")
	private Wind wind;
	@JsonProperty("clouds")
	private Clouds clouds;
	@JsonProperty("dt")
	private long dt;
	@JsonProperty("id")
	private long id;
	@JsonProperty("name")
	private String name;
	@JsonProperty("cod")
	private long cod;

	@JsonProperty("coord")
	public Coord getCoord() {
		return coord;
	}

	@JsonProperty("coord")
	public void setCoord(Coord coord) {
		this.coord = coord;
	}

	@JsonProperty("sys")
	public Sys getSys() {
		return sys;
	}

	@JsonProperty("sys")
	public void setSys(Sys sys) {
		this.sys = sys;
	}

	@JsonProperty("weather")
	public List<Weather> getWeather() {
		return weather;
	}

	@JsonProperty("weather")
	public void setWeather(List<Weather> weather) {
		this.weather = weather;
	}

	@JsonProperty("base")
	public String getBase() {
		return base;
	}

	@JsonProperty("base")
	public void setBase(String base) {
		this.base = base;
	}

	@JsonProperty("main")
	public Main getMain() {
		return main;
	}

	@JsonProperty("main")
	public void setMain(Main main) {
		this.main = main;
	}

	@JsonProperty("wind")
	public Wind getWind() {
		return wind;
	}

	@JsonProperty("wind")
	public void setWind(Wind wind) {
		this.wind = wind;
	}

	@JsonProperty("clouds")
	public Clouds getClouds() {
		return clouds;
	}

	@JsonProperty("clouds")
	public void setClouds(Clouds clouds) {
		this.clouds = clouds;
	}

	@JsonProperty("dt")
	public long getDt() {
		return dt;
	}

	@JsonProperty("dt")
	public void setDt(long dt) {
		this.dt = dt;
	}

	@JsonProperty("id")
	public long getId() {
		return id;
	}

	@JsonProperty("id")
	public void setId(long id) {
		this.id = id;
	}

	@JsonProperty("name")
	public String getName() {
		return name;
	}

	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("cod")
	public long getCod() {
		return cod;
	}

	@JsonProperty("cod")
	public void setCod(long cod) {
		this.cod = cod;
	}

	@Override
	public String toString() {
		return "CurrentWeatherResponse [coord=" + coord + ", sys=" + sys + ", weather=" + weather + ", base=" + base + ", main=" + main
				+ ", wind=" + wind + ", clouds=" + clouds + ", dt=" + dt + ", id=" + id + ", name=" + name + ", cod=" + cod + "]";
	}

}
