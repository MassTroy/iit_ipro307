package com.google.maps.api.geocode;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;

@JsonPropertyOrder({
    "results",
    "status"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class GeocodingResponse {

    @JsonProperty("results")
    private List<Result> results = new ArrayList<Result>();
    @JsonProperty("status")
    private String status;

    @JsonProperty("results")
    public List<Result> getResults() {
        return results;
    }

    @JsonProperty("results")
    public void setResults(List<Result> results) {
        this.results = results;
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
		return "GeocodingResponse [results=" + results + ", status=" + status + "]";
	}

}
