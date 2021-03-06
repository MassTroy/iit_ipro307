package common.util;

/**
 * Convert speeds between different units
 */
public class SpeedConverter {

	public static double metersPerSecondToMilesPerHour(double metersPerSecond) {
		return metersPerSecond * 2.23694;
	}

	public static double metersPerSecondToKiloMetersPerHour(double metersPerSecond) {
		return metersPerSecond * 3.6;
	}

}
