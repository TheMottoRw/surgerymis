package com.op.surgerymis.helpers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
    public static SimpleDateFormat getDateFormatter() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }

    public static String getCurrentDate() {
        SimpleDateFormat df = getDateFormatter();
        Date date = new Date();
        return df.format(date);
    }

    public static Date getCurrentYear() {
        Date date = null,date1=null;
        SimpleDateFormat df = null;
        try {
            date = getDateFormatter().parse(getCurrentDate());
            df = new SimpleDateFormat("yyyy");
            date1 = df.parse(df.format(date));
        } catch (ParseException ignored) {

        }
        return date1;
    }

}
