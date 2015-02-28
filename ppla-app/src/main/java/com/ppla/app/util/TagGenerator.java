package com.ppla.app.util;

import java.util.Calendar;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

/**
 * @author mbmartinez
 */
@Component
public class TagGenerator {

    public String next() {
        return "" + Calendar.getInstance().get(Calendar.YEAR) 
                + StringUtils.leftPad("" + Calendar.getInstance().get(Calendar.DAY_OF_YEAR), 3, "0")
                + RandomStringUtils.randomNumeric(6);
    }

    public static void main(String[] args) {
        System.out.println(Calendar.getInstance().get(Calendar.YEAR));
        System.out.println(StringUtils.leftPad("" + Calendar.getInstance().get(Calendar.DAY_OF_YEAR), 3, "0"));
        System.out.println(new TagGenerator().next());
    }
}
