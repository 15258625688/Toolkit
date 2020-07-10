package com.toolkit.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class TimeUtil {
    private final static SimpleDateFormat UTC_FORMAT;
    private final static SimpleDateFormat LOCAL_FORMAT;
    static {
	UTC_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
	UTC_FORMAT.setTimeZone(TimeZone.getTimeZone("UTC"));
	LOCAL_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	LOCAL_FORMAT.setTimeZone(TimeZone.getDefault());
    }

    public static String utcTimeToLoaclTime(String utcTime) throws ParseException {
	Date date = UTC_FORMAT.parse(utcTime);
	return LOCAL_FORMAT.format(date);
    }

    public static void main(String[] args) throws ParseException {
	String utc = "2020-01-02T10:11:12.001Z";
	System.out.println(utcTimeToLoaclTime(utc));
    }
}
