
package org.openweathermap.api.common;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;

@JsonPropertyOrder({
    "message",
    "country",
    "sunrise",
    "sunset"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class Sys {

    @JsonProperty("message")
    private double message;
    @JsonProperty("country")
    private String country;
    @JsonProperty("sunrise")
    private long sunrise;
    @JsonProperty("sunset")
    private long sunset;

    @JsonProperty("message")
    public double getMessage() {
        return message;
    }

    @JsonProperty("message")
    public void setMessage(double message) {
        this.message = message;
    }

    @JsonProperty("country")
    public String getCountry() {
        return country;
    }

    @JsonProperty("country")
    public void setCountry(String country) {
        this.country = country;
    }

    @JsonProperty("sunrise")
    public long getSunrise() {
        return sunrise;
    }

    @JsonProperty("sunrise")
    public void setSunrise(long sunrise) {
        this.sunrise = sunrise;
    }

    @JsonProperty("sunset")
    public long getSunset() {
        return sunset;
    }

    @JsonProperty("sunset")
    public void setSunset(long sunset) {
        this.sunset = sunset;
    }

	@Override
	public String toString() {
		return "Sys [message=" + message + ", country=" + country + ", sunrise=" + sunrise + ", sunset=" + sunset + "]";
	}

}
