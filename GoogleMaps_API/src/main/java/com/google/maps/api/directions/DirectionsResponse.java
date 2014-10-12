package com.google.maps.api.directions;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;

@JsonPropertyOrder({
		"routes",
		"status"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class DirectionsResponse {

	@JsonProperty("routes")
	private List<Route> routes = new ArrayList<Route>();
	@JsonProperty("status")
	private String status;

	@JsonProperty("routes")
	public List<Route> getRoutes() {
		return routes;
	}

	@JsonProperty("routes")
	public void setRoutes(List<Route> routes) {
		this.routes = routes;
	}

	@JsonProperty("status")
	public String getStatus() {
		return status;
	}

	@JsonProperty("status")
	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "DirectionsResponse [routes=" + routes + ", status=" + status + "]";
	}

}
