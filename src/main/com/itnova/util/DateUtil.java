package com.itnova.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	public static String getTime() {
		SimpleDateFormat format = new SimpleDateFormat("HHmmss");
		return format.format(new Date());
	}

	public static String getTime(Date date) {
		SimpleDateFormat format = new SimpleDateFormat("HHmmss");
		return format.format(date);
	}

	public static String getToday() {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		return format.format(new Date());
	}

	public static String getMonth() {
		return getToday().substring(0, 6);
	}
}
