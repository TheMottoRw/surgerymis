package com.op.surgerymis.helpers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Utils {
    public static SimpleDateFormat getDateFormatter() {
        return new SimpleDateFormat("yyyy-MM-dd");
    }
    public static SimpleDateFormat getDateTimeFormatter() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }

    public static String getCurrentDate() {
        SimpleDateFormat df = getDateTimeFormatter();
        Date date = new Date();
        System.out.println(date.toString());
        return df.format(date);
    }

    public static Date strToDate(String date) {
        SimpleDateFormat df = getDateTimeFormatter();
        try {
            return df.parse(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static Date getCurrentYear() {
        Date date = null,date1=null;
        SimpleDateFormat df = null;
        try {
            date = getDateTimeFormatter().parse(getCurrentDate());
            df = new SimpleDateFormat("yyyy");
            date1 = df.parse(df.format(date));
        } catch (ParseException ignored) {

        }
        return date1;
    }

}
