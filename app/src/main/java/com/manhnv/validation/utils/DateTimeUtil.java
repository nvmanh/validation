package com.manhnv.validation.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTimeUtil {
    /**
     * Date and Time Pattern Result "yyyy.MM.dd G 'at' HH:mm:ss z" 2001.07.04 AD at 12:08:56 PDT
     * "EEE, MMM d, ''yy" Wed, Jul 4, '01 "h:mm a" 12:08 PM "hh 'o''clock' a, zzzz" 12 o'clock PM,
     * Pacific Daylight Time "K:mm a, z" 0:08 PM, PDT "yyyyy.MMMMM.dd GGG hh:mm aaa" 02001.July.04
     * AD 12:08 PM "EEE, d MMM yyyy HH:mm:ss Z" Wed, 4 Jul 2001 12:08:56 -0700 "yyMMddHHmmssZ"
     * 010704120856-0700 "yyyy-MM-dd'T'HH:mm:ss.SSSZ" 2001-07-04T12:08:56.235-0700
     */
    public static final String COMMON_DATE_FORMAT = "MM/dd/yyyy";
    public static final String COMMON_DATETIME_FORMAT = "MM/dd/yyyy hh:mm:ss a";
    public static final String VN_DATE_FORMAT = "dd/MM/yyyy";
    public static final String VN_DATETIME_FORMAT = "dd/MM/yyyy hh:mm:ss a";
    public static final String DATE_FULL_DATABASE = "yyyy-MM-dd HH:mm:ss";
    public static int SECOND = 1000;
    public static int MINUTE = 60 * SECOND;
    public static int HOUR = 60 * MINUTE;
    public static int DAY = 24 * HOUR;

    public static java.util.Date stringToDate(String src, String format) {
        try {
            src = src.trim();
            if (format == null)
                format = VN_DATE_FORMAT;
            SimpleDateFormat ts = new SimpleDateFormat(format);
            return ts.parse(src);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Date getNextDay(Date d2) {
        if (d2 == null)
            d2 = new Date();
        Calendar c1 = Calendar.getInstance();
        c1.setTimeInMillis(d2.getTime() + 24 * 60 * 60 * 1000);
        return c1.getTime();
    }

    public static Date getStartNextDay(Date d2) {
        Date d = getNextDay(d2);
        String dStr = dateToString(d, null);
        return stringToDate(dStr, null);
    }

    public static String dateToString(Date date, String format) {
        if (format == null)
            format = VN_DATE_FORMAT;
        SimpleDateFormat ts = new SimpleDateFormat(format);
        return ts.format(date);
    }

    public static java.util.Date parse(String src) {
        try {
            return DateFormat.getDateInstance().parse(src);
        } catch (ParseException e) {
            return DateFormat.getInstance().getCalendar().getTime();
        }
    }

    public static String convertFormat(String src, String f1, String f2) {
        Date date = stringToDate(src, f1);
        return dateToString(date, f2);
    }

    public static int compare(Date date1, Date date2) {
        String d1 = dateToString(date1, "yyyyMMdd");
        String d2 = dateToString(date2, "yyyyMMdd");
        return d1.compareTo(d2);
    }

    /**
     * @param date1
     * @param date1Format
     * @param date2
     * @param date2Format
     * @return 0: d1 = d2<br>
     *         1: d1 > d2<br>
     *         -1: d1 < d2
     */
    public static int compare(String date1, String date1Format, String date2, String date2Format) {
        long d1 = stringToDate(date1, date1Format).getTime();
        long d2 = stringToDate(date2, date2Format).getTime();
        if (d1 == d2)
            return 0;
        else if (d1 > d2)
            return 1;
        else
            return -1;
    }
}
