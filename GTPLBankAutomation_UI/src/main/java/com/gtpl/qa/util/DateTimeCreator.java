package com.gtpl.qa.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeCreator {
	
	public static String getDateAndTime() {
		DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern("yyyy.MM.ddHH:mm:ss");
		LocalDateTime date=LocalDateTime.now();
		dateTimeFormatter.format(date);
		String dateAndTime=String.valueOf(date);
		return dateAndTime;
	
	}
}
