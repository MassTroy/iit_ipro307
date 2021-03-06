package com.google.maps.api.directions;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;

import com.google.maps.api.common.Location;
import com.google.maps.api.common.TextValue;

@JsonPropertyOrder({
		"distance",
		"duration",
		"end_location",
		"html_instructions",
		"polyline",
		"start_location",
		"travel_mode",
		"maneuver"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class Step {

	@JsonProperty("distance")
	private TextValue distance;
	@JsonProperty("duration")
	private TextValue duration;
	@JsonProperty("end_location")
	private Location endLocation;
	@JsonProperty("html_instructions")
	private String htmlInstructions;
	@JsonProperty("polyline")
	private Polyline polyline;
	@JsonProperty("start_location")
	private Location startLocation;
	@JsonProperty("travel_mode")
	private String travelMode;
	@JsonProperty("maneuver")
	private String maneuver;

	@JsonProperty("distance")
	public TextValue getDistance() {
		return distance;
	}

	@JsonProperty("distance")
	public void setDistance(TextValue distance) {
		this.distance = distance;
	}

	@JsonProperty("duration")
	public TextValue getDuration() {
		return duration;
	}

	@JsonProperty("duration")
	public void setDuration(TextValue duration) {
		this.duration = duration;
	}

	@JsonProperty("end_location")
	public Location getEndLocation() {
		return endLocation;
	}

	@JsonProperty("end_location")
	public void setEndLocation(Location endLocation) {
		this.endLocation = endLocation;
	}

	@JsonProperty("html_instructions")
	public String getHtmlInstructions() {
		return htmlInstructions;
	}

	@JsonProperty("html_instructions")
	public void setHtmlInstructions(String htmlInstructions) {
		this.htmlInstructions = htmlInstructions;
	}

	@JsonProperty("polyline")
	public Polyline getPolyline() {
		return polyline;
	}

	@JsonProperty("polyline")
	public void setPolyline(Polyline polyline) {
		this.polyline = polyline;
	}

	@JsonProperty("start_location")
	public Location getStartLocation() {
		return startLocation;
	}

	@JsonProperty("start_location")
	public void setStartLocation(Location startLocation) {
		this.startLocation = startLocation;
	}

	@JsonProperty("travel_mode")
	public String getTravelMode() {
		return travelMode;
	}

	@JsonProperty("travel_mode")
	public void setTravelMode(String travelMode) {
		this.travelMode = travelMode;
	}

	@JsonProperty("maneuver")
	public String getManeuver() {
		return maneuver;
	}

	@JsonProperty("maneuver")
	public void setManeuver(String maneuver) {
		this.maneuver = maneuver;
	}

	@Override
	public String toString() {
		return "Step [distance=" + distance + ", duration=" + duration + ", endLocation=" + endLocation + ", htmlInstructions="
				+ htmlInstructions + ", polyline=" + polyline + ", startLocation=" + startLocation + ", travelMode=" + travelMode
				+ ", maneuver=" + maneuver + "]";
	}

}
