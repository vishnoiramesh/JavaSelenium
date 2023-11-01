package ramesh.coreJava.practice;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateTime {
	public static void main(String args[]) {
		// Instantiate a Date object
		Date date = new Date();
		// display time and date using toString()
		System.out.println("Simple System Date : " + date.toString());

		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"E yyyy.MM.dd 'at' hh:mm:ss a zzz");
		String formattedDate = dateFormat.format(date);
		System.out.println("Format 1: " + formattedDate);

		SimpleDateFormat[] dateFormatOther = {
				new SimpleDateFormat("yyyy/MM/dd"),
				new SimpleDateFormat("dd-M-yyyy hh:mm:ss"),
				new SimpleDateFormat("dd MMMM yyyy zzzz", Locale.ENGLISH) };

		for (int i = 0; i < dateFormatOther.length; i++) {
			formattedDate = dateFormatOther[i].format(date);
			System.out.println("Format " + (i + 2) + ": "
					+ formattedDate);
		}
		try {
			DateFormat df = DateFormat.getDateInstance(DateFormat.FULL);  //new DateFormat();
			String myString = df.format(date); //DateFormat.getDateInstance(DateFormat.FULL)
					
			Date parsedDate = df.parse(myString + "Bla bla text will be ignored at last");
			System.out.println("Date parsed form string: " + parsedDate);
		} catch (ParseException pe) {
			pe.printStackTrace();
		}
		
		
		long start =System.currentTimeMillis(); 
		try {
			Thread.sleep(5*60*10);
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		} 
		long end = System.currentTimeMillis();
		System.out.println("Time Taken to Sleep: " + ((end - start)/1000) + " Seconds");
	}
}