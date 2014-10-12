
package org.openweathermap.api.common;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;

@JsonPropertyOrder({
    "lon",
    "lat"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class Coord {

    @JsonProperty("lon")
    private long lon;
    @JsonProperty("lat")
    private long lat;

    @JsonProperty("lon")
    public long getLon() {
        return lon;
    }

    @JsonProperty("lon")
    public void setLon(long lon) {
        this.lon = lon;
    }

    @JsonProperty("lat")
    public long getLat() {
        return lat;
    }

    @JsonProperty("lat")
    public void setLat(long lat) {
        this.lat = lat;
    }

	@Override
	public String toString() {
		return "Coord [lon=" + lon + ", lat=" + lat + "]";
	}

}
