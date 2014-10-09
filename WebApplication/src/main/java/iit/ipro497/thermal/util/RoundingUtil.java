package iit.ipro497.thermal.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class RoundingUtil {
	
	public static double round(double value, int places) {
		if (places < 0)
			throw new IllegalArgumentException();
		return new BigDecimal(value).setScale(places, RoundingMode.HALF_UP).doubleValue();
	}

	public static float round(float value, int places) {
		if (places < 0)
			throw new IllegalArgumentException();
		return new BigDecimal(value).setScale(places, RoundingMode.HALF_UP).floatValue();
	}
	
}
