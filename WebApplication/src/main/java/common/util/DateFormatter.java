package common.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatter {

	public static String formatDate(Date date) {
		return new SimpleDateFormat("MMMM dd - hh:mm aa").format(date);
	}
}
