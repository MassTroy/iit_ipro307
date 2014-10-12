package com.google.maps.api.geocode;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;

@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "long_name",
    "short_name",
    "types"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class AddressComponent {

    @JsonProperty("long_name")
    private String longName;
    @JsonProperty("short_name")
    private String shortName;
    @JsonProperty("types")
    private List<String> types = new ArrayList<String>();

    @JsonProperty("long_name")
    public String getLongName() {
        return longName;
    }

    @JsonProperty("long_name")
    public void setLongName(String longName) {
        this.longName = longName;
    }

    @JsonProperty("short_name")
    public String getShortName() {
        return shortName;
    }

    @JsonProperty("short_name")
    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    @JsonProperty("types")
    public List<String> getTypes() {
        return types;
    }

    @JsonProperty("types")
    public void setTypes(List<String> types) {
        this.types = types;
    }

	@Override
	public String toString() {
		return "AddressComponent [longName=" + longName + ", shortName=" + shortName + ", types=" + types + "]";
	}

}
