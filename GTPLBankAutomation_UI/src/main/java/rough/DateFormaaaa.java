package rough;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class DateFormaaaa {
	
	
	
	public static void main(String[] args) {
		
		/*
		 * Locale locale = new Locale("fr", "FR"); DateTimeFormat dateFormat =
		 * DateFormat.getDateInstance(DateFormat.DEFAULT, locale);
		 * 
		 * String date = dateFormat.format(new Date()); System.out.print(date);
		 */
		
		/*Locale locale = new Locale("in", "IN");
		DateFormat dateFormat = DateFormat.getTimeInstance(DateFormat.DEFAULT, locale);
		String date = dateFormat.format(new Date());
		System.out.print(date);*/
		
		DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern("yyyy.MM.dd_HH:mm:ss");
		LocalDateTime date=LocalDateTime.now();
		System.out.println(dateTimeFormatter.format(date));
		
	}

}
