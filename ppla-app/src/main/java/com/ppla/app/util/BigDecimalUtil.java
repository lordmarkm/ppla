package com.ppla.app.util;

import static java.math.BigDecimal.*;

import java.math.BigDecimal;

/**
 * @author markm
 */
public class BigDecimalUtil {

    public static BigDecimal tryParse(String str) {
        if (null == str) return ZERO;
        try {
            return new BigDecimal(str);
        } catch (NumberFormatException n) {
            return ZERO;
        }
    }

}
