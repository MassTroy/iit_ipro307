
package com.google.maps.api.directions;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;

@JsonPropertyOrder({
    "points"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class Polyline {

    @JsonProperty("points")
    private String points;

    @JsonProperty("points")
    public String getPoints() {
        return points;
    }

    @JsonProperty("points")
    public void setPoints(String points) {
        this.points = points;
    }

}
