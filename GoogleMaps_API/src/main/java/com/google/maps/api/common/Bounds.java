package com.google.maps.api.common;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;

@JsonPropertyOrder({
		"northeast",
		"southwest"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class Bounds {

	@JsonProperty("northeast")
	private Location northeast;
	@JsonProperty("southwest")
	private Location southwest;

	@JsonProperty("northeast")
	public Location getNortheast() {
		return northeast;
	}

	@JsonProperty("northeast")
	public void setNortheast(Location northeast) {
		this.northeast = northeast;
	}

	@JsonProperty("southwest")
	public Location getSouthwest() {
		return southwest;
	}

	@JsonProperty("southwest")
	public void setSouthwest(Location southwest) {
		this.southwest = southwest;
	}

	@Override
	public String toString() {
		return "Bounds [northeast=" + northeast + ", southwest=" + southwest + "]";
	}

}
