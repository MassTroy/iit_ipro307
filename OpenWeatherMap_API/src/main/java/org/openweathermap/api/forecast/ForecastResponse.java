
package org.openweathermap.api.forecast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonAnyGetter;
import org.codehaus.jackson.annotate.JsonAnySetter;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.openweathermap.api.common.City;

@JsonPropertyOrder({
    "cod",
    "message",
    "city",
    "cnt",
    "list"
})
public class ForecastResponse {

    @JsonProperty("cod")
    private String cod;
    @JsonProperty("message")
    private double message;
    @JsonProperty("city")
    private City city;
    @JsonProperty("cnt")
    private long cnt;
    @JsonProperty("list")
    private java.util.List<org.openweathermap.api.common.WeatherDataPoint> list = new ArrayList<org.openweathermap.api.common.WeatherDataPoint>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("cod")
    public String getCod() {
        return cod;
    }

    @JsonProperty("cod")
    public void setCod(String cod) {
        this.cod = cod;
    }

    @JsonProperty("message")
    public double getMessage() {
        return message;
    }

    @JsonProperty("message")
    public void setMessage(double message) {
        this.message = message;
    }

    @JsonProperty("city")
    public City getCity() {
        return city;
    }

    @JsonProperty("city")
    public void setCity(City city) {
        this.city = city;
    }

    @JsonProperty("cnt")
    public long getCnt() {
        return cnt;
    }

    @JsonProperty("cnt")
    public void setCnt(long cnt) {
        this.cnt = cnt;
    }

    @JsonProperty("list")
    public java.util.List<org.openweathermap.api.common.WeatherDataPoint> getList() {
        return list;
    }

    @JsonProperty("list")
    public void setList(java.util.List<org.openweathermap.api.common.WeatherDataPoint> list) {
        this.list = list;
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
