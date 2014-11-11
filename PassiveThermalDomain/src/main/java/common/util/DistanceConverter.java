package common.util;

/**
 * Convert distance between different units
 */
public class DistanceConverter {
	private static final double MILES_TO_METERS = 1609.34;

	public static double metersToMiles(long meters) {
		return meters / MILES_TO_METERS;
	}

	public static long milesToMeters(long miles) {
		return (long) RoundingUtil.round(miles * MILES_TO_METERS, 0);
	}

}
