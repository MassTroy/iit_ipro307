package com.google.maps.api.directions;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;

import com.google.maps.api.common.Bounds;

@JsonPropertyOrder({
		"bounds",
		"copyrights",
		"legs",
		"overview_polyline",
		"summary",
		"warnings",
		"waypoint_order"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class Route {

	@JsonProperty("bounds")
	private Bounds bounds;
	@JsonProperty("copyrights")
	private String copyrights;
	@JsonProperty("legs")
	private List<Leg> legs = new ArrayList<Leg>();
	@JsonProperty("overview_polyline")
	private Polyline overviewPolyline;
	@JsonProperty("summary")
	private String summary;
	@JsonProperty("warnings")
	private List<Object> warnings = new ArrayList<Object>();
	@JsonProperty("waypoint_order")
	private List<Long> waypointOrder = new ArrayList<Long>();

	@JsonProperty("bounds")
	public Bounds getBounds() {
		return bounds;
	}

	@JsonProperty("bounds")
	public void setBounds(Bounds bounds) {
		this.bounds = bounds;
	}

	@JsonProperty("copyrights")
	public String getCopyrights() {
		return copyrights;
	}

	@JsonProperty("copyrights")
	public void setCopyrights(String copyrights) {
		this.copyrights = copyrights;
	}

	@JsonProperty("legs")
	public List<Leg> getLegs() {
		return legs;
	}

	@JsonProperty("legs")
	public void setLegs(List<Leg> legs) {
		this.legs = legs;
	}

	@JsonProperty("overview_polyline")
	public Polyline getOverviewPolyline() {
		return overviewPolyline;
	}

	@JsonProperty("overview_polyline")
	public void setOverviewPolyline(Polyline overviewPolyline) {
		this.overviewPolyline = overviewPolyline;
	}

	@JsonProperty("summary")
	public String getSummary() {
		return summary;
	}

	@JsonProperty("summary")
	public void setSummary(String summary) {
		this.summary = summary;
	}

	@JsonProperty("warnings")
	public List<Object> getWarnings() {
		return warnings;
	}

	@JsonProperty("warnings")
	public void setWarnings(List<Object> warnings) {
		this.warnings = warnings;
	}

	@JsonProperty("waypoint_order")
	public List<Long> getWaypointOrder() {
		return waypointOrder;
	}

	@JsonProperty("waypoint_order")
	public void setWaypointOrder(List<Long> waypointOrder) {
		this.waypointOrder = waypointOrder;
	}

	@Override
	public String toString() {
		return "Route [bounds=" + bounds + ", copyrights=" + copyrights + ", legs=" + legs + ", overviewPolyline=" + overviewPolyline
				+ ", summary=" + summary + ", warnings=" + warnings + ", waypointOrder=" + waypointOrder + "]";
	}

}
