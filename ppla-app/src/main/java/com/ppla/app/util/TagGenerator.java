package com.ppla.app.util;

import java.util.Calendar;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.stereotype.Component;

/**
 * @author mbmartinez
 * TODO: make this make real numbers
 */
@Component
public class TagGenerator {

    public String next() {
        return Calendar.getInstance().get(Calendar.YEAR) 
                + Calendar.getInstance().get(Calendar.DAY_OF_YEAR) 
                + RandomStringUtils.randomNumeric(6);
    }

}
