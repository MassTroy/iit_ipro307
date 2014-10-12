package common.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class RoundingUtil {
	
	public static double round(double value, int places) {
		return new BigDecimal(value).setScale(places, RoundingMode.HALF_UP).doubleValue();
	}

	public static float round(float value, int places) {
		return new BigDecimal(value).setScale(places, RoundingMode.HALF_UP).floatValue();
	}
	
}
