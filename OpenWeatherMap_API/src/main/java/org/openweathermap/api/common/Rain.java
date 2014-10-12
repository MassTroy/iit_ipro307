
package org.openweathermap.api.common;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;

@JsonPropertyOrder({
    "3h"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class Rain {

    @JsonProperty("3h")
    private long _3h;

    @JsonProperty("3h")
    public long get3h() {
        return _3h;
    }

    @JsonProperty("3h")
    public void set3h(long _3h) {
        this._3h = _3h;
    }

	@Override
	public String toString() {
		return "Rain [_3h=" + _3h + "]";
	}

}
