package com.ayp.sms.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * 
 * @author rana
 *
 */

public class DateUtil {
	
	private final static SimpleDateFormat FORMAT =  new SimpleDateFormat("dd MMM, yy", Locale.ENGLISH);
    
    private final static SimpleDateFormat FORMAT_WITH_TIME =   new SimpleDateFormat("MMMM dd, yyyy, HH:mm zzz", Locale.ENGLISH);

    /**
     * This function is supposed to convert Calendar object to String
     *
     * @param calendar
     *
     * @return String
     */
    public static String convertCalendarToString (Calendar calendar) {
        return (FORMAT.format(calendar.getTime()));
    }
    
    /**
     * This function is supposed to convert Calendar object to String
     *
     * @param calendar
     *
     * @return String
     */
    public static String convertCalendarToStringWithTime (Calendar calendar) {
        return (FORMAT_WITH_TIME.format(calendar.getTime()));
    }

    /**
     * This function is supposed to convert String to Calendar object
     *
     * @param date
     *
     * @return Calendar
     */
    public static Calendar convertStringToCalendar (String date) {
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(FORMAT.parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return calendar;
    }

}
