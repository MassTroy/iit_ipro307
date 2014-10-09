
package com.google.api.directions.resp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonAnyGetter;
import org.codehaus.jackson.annotate.JsonAnySetter;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;

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
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
