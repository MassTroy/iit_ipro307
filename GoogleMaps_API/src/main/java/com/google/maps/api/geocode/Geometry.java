package com.google.maps.api.geocode;

import javax.annotation.Generated;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;

import com.google.maps.api.common.Bounds;
import com.google.maps.api.common.Location;

@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "bounds",
    "location",
    "location_type",
    "viewport"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class Geometry {

    @JsonProperty("bounds")
    private Bounds bounds;
    @JsonProperty("location")
    private Location location;
    @JsonProperty("location_type")
    private String locationType;
    @JsonProperty("viewport")
    private Bounds viewport;

    @JsonProperty("bounds")
    public Bounds getBounds() {
        return bounds;
    }

    @JsonProperty("bounds")
    public void setBounds(Bounds bounds) {
        this.bounds = bounds;
    }

    @JsonProperty("location")
    public Location getLocation() {
        return location;
    }

    @JsonProperty("location")
    public void setLocation(Location location) {
        this.location = location;
    }

    @JsonProperty("location_type")
    public String getLocationType() {
        return locationType;
    }

    @JsonProperty("location_type")
    public void setLocationType(String locationType) {
        this.locationType = locationType;
    }

    @JsonProperty("viewport")
    public Bounds getViewport() {
        return viewport;
    }

    @JsonProperty("viewport")
    public void setViewport(Bounds viewport) {
        this.viewport = viewport;
    }

	@Override
	public String toString() {
		return "Geometry [bounds=" + bounds + ", location=" + location + ", locationType=" + locationType + ", viewport=" + viewport + "]";
	}

}
