package com.google.maps.api.common;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;

@JsonPropertyOrder({
		"lat",
		"lng"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class Location {

	@JsonProperty("lat")
	private double lat;
	@JsonProperty("lng")
	private double lng;

	@JsonProperty("lat")
	public double getLat() {
		return lat;
	}

	@JsonProperty("lat")
	public void setLat(double lat) {
		this.lat = lat;
	}

	@JsonProperty("lng")
	public double getLng() {
		return lng;
	}

	@JsonProperty("lng")
	public void setLng(double lng) {
		this.lng = lng;
	}

	@Override
	public String toString() {
		return "Location [lat=" + lat + ", lng=" + lng + "]";
	}

}
