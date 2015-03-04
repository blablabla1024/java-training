package com.jksoft.runpro;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateConverterUtils {

	private static DateTimeFormatter formatterToString = DateTimeFormatter
			.ofPattern("yyyy-MM-dd HH:mm");
	private static DateTimeFormatter formatter = DateTimeFormatter
			.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

	private DateConverterUtils() {

	}

	public static String convertLocalDateTimeToString(LocalDateTime ldt) {
		return ldt.format(formatterToString);
	}

	public static LocalDateTime convertStringToLocalDateTime(String dateTime) {
		return LocalDateTime.parse(dateTime, formatter);
	}

}
