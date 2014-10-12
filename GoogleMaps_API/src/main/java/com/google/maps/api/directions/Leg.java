package com.google.maps.api.directions;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;

import com.google.maps.api.common.Location;
import com.google.maps.api.common.TextValue;

@JsonPropertyOrder({
		"distance",
		"duration",
		"end_address",
		"end_location",
		"start_address",
		"start_location",
		"steps",
		"via_waypoint"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class Leg {

	@JsonProperty("distance")
	private TextValue distance;
	@JsonProperty("duration")
	private TextValue duration;
	@JsonProperty("end_address")
	private String endAddress;
	@JsonProperty("end_location")
	private Location endLocation;
	@JsonProperty("start_address")
	private String startAddress;
	@JsonProperty("start_location")
	private Location startLocation;
	@JsonProperty("steps")
	private List<Step> steps = new ArrayList<Step>();
	@JsonProperty("via_waypoint")
	private List<Object> viaWaypoint = new ArrayList<Object>();

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

	@JsonProperty("end_address")
	public String getEndAddress() {
		return endAddress;
	}

	@JsonProperty("end_address")
	public void setEndAddress(String endAddress) {
		this.endAddress = endAddress;
	}

	@JsonProperty("end_location")
	public Location getEndLocation() {
		return endLocation;
	}

	@JsonProperty("end_location")
	public void setEndLocation(Location endLocation) {
		this.endLocation = endLocation;
	}

	@JsonProperty("start_address")
	public String getStartAddress() {
		return startAddress;
	}

	@JsonProperty("start_address")
	public void setStartAddress(String startAddress) {
		this.startAddress = startAddress;
	}

	@JsonProperty("start_location")
	public Location getStartLocation() {
		return startLocation;
	}

	@JsonProperty("start_location")
	public void setStartLocation(Location startLocation) {
		this.startLocation = startLocation;
	}

	@JsonProperty("steps")
	public List<Step> getSteps() {
		return steps;
	}

	@JsonProperty("steps")
	public void setSteps(List<Step> steps) {
		this.steps = steps;
	}

	@JsonProperty("via_waypoint")
	public List<Object> getViaWaypoint() {
		return viaWaypoint;
	}

	@JsonProperty("via_waypoint")
	public void setViaWaypoint(List<Object> viaWaypoint) {
		this.viaWaypoint = viaWaypoint;
	}

	@Override
	public String toString() {
		return "Leg [distance=" + distance + ", duration=" + duration + ", endAddress=" + endAddress + ", endLocation=" + endLocation
				+ ", startAddress=" + startAddress + ", startLocation=" + startLocation + ", steps=" + steps + ", viaWaypoint="
				+ viaWaypoint + "]";
	}

}
