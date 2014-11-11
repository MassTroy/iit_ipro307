package common.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatter {

	/**
	 * Prints out a date as a string
	 * @param date
	 * @return String such as "Sept 21 - 10:34 am"
	 */
	public static String formatDate(Date date) {
		return new SimpleDateFormat("MMMM dd - hh:mm aa").format(date);
	}
}
