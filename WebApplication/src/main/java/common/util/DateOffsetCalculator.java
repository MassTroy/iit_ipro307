package common.util;

import java.util.Date;

public class DateOffsetCalculator {

	public static Date offsetSeconds(Date depart, long duration) {
		return new Date(depart.getTime() + (duration * 1000L));
	}

}
