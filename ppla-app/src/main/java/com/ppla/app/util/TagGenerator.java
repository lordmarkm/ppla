package com.ppla.app.util;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.stereotype.Component;

/**
 * @author mbmartinez
 * TODO: make this make real numbers
 */
@Component
public class TagGenerator {

    public String next() {
        return RandomStringUtils.randomNumeric(8);
    }

}
