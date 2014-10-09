package com.google.api.geocode.resp;

import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonAnyGetter;
import org.codehaus.jackson.annotate.JsonAnySetter;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;

@JsonPropertyOrder({
    "northeast",
    "southwest"
})
public class Viewport {

    @JsonProperty("northeast")
    private Northeast_ northeast;
    @JsonProperty("southwest")
    private Southwest_ southwest;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("northeast")
    public Northeast_ getNortheast() {
        return northeast;
    }

    @JsonProperty("northeast")
    public void setNortheast(Northeast_ northeast) {
        this.northeast = northeast;
    }

    @JsonProperty("southwest")
    public Southwest_ getSouthwest() {
        return southwest;
    }

    @JsonProperty("southwest")
    public void setSouthwest(Southwest_ southwest) {
        this.southwest = southwest;
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