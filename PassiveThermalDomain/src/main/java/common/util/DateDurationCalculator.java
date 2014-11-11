package common.util;

import java.util.Date;

public class DateDurationCalculator {
	private static final long DAY = 60 * 60 * 24;
	private static final long HOUR = 60 * 60;
	private static final long MINUTE = 60;

	/**
	 * Build a string describing the time difference between two dates.
	 * Breaks down into days, hours, minutes
	 * @param date1
	 * @param date2
	 * @return String such as "1 day 10 hours 24 minutes "
	 */
	public static String duration(Date date1, Date date2) {
		long diff = (date2.getTime() - date1.getTime()) / 1000;
		String str = "";
		if (diff >= DAY) {
			long days = diff / DAY;
			str += days + " days ";
			diff -= days * DAY;
		}
		if (diff >= HOUR) {
			long hours = diff / HOUR;
			str += hours + " hours ";
			diff -= hours * HOUR;
		}
		if (diff > MINUTE) {
			long minutes = diff / MINUTE;
			str += minutes + " minutes ";
			diff -= minutes * MINUTE;
		}
		return str;
	}

}
