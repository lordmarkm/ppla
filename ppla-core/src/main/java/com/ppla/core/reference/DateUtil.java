package com.ppla.core.reference;

import org.joda.time.DateTime;

public class DateUtil {

    public static final String DATE_FORMAT = "MM/dd/yy hh:mm a";

    public static String formatDate(DateTime date) {
        return null == date ? "" : date.toString(DATE_FORMAT);
    }

}
