package com.gemini.util.format;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeFormat {
    public static final String DATE_TIME_PATTERN = "yyyy-MM-dd hh:mm:ss";
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    
    public static String getFormatDate(Date date) {
        return sdf.format(date);
    }
    
}
