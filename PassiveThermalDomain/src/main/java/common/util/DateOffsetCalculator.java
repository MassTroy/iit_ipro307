package common.util;

import java.util.Date;

public class DateOffsetCalculator {
	/**
	 * Find a date offset by a number of seconds
	 * @param from date to compute from
	 * @param duration in seconds. Postive is future, negative is past
	 * @return new Date
	 */
	public static Date offsetSeconds(Date from, long duration) {
		return new Date(from.getTime() + (duration * 1000L));
	}

}
