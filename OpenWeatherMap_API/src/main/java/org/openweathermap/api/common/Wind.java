package org.openweathermap.api.common;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;

@JsonPropertyOrder({
		"speed",
		"deg"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class Wind {

	@JsonProperty("speed")
	private double speed;
	@JsonProperty("deg")
	private double deg;

	@JsonProperty("speed")
	public double getSpeed() {
		return speed;
	}

	@JsonProperty("speed")
	public void setSpeed(double speed) {
		this.speed = speed;
	}

	@JsonProperty("deg")
	public double getDeg() {
		return deg;
	}

	@JsonProperty("deg")
	public void setDeg(double deg) {
		this.deg = deg;
	}

	@Override
	public String toString() {
		return "Wind [speed=" + speed + ", deg=" + deg + "]";
	}

}
