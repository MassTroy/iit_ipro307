package org.openweathermap.api.common;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;

@JsonPropertyOrder({
		"all"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class Clouds {

	@JsonProperty("all")
	private long all;

	@JsonProperty("all")
	public long getAll() {
		return all;
	}

	@JsonProperty("all")
	public void setAll(long all) {
		this.all = all;
	}

	@Override
	public String toString() {
		return "Clouds [all=" + all + "]";
	}

}
