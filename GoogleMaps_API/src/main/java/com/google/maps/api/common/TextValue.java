package com.google.maps.api.common;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;

@JsonPropertyOrder({
		"text",
		"value"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class TextValue {

	@JsonProperty("text")
	private String text;
	@JsonProperty("value")
	private long value;

	@JsonProperty("text")
	public String getText() {
		return text;
	}

	@JsonProperty("text")
	public void setText(String text) {
		this.text = text;
	}

	@JsonProperty("value")
	public long getValue() {
		return value;
	}

	@JsonProperty("value")
	public void setValue(long value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "TextValue [text=" + text + ", value=" + value + "]";
	}

}
