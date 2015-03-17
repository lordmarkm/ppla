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
        String code = "" + Calendar.getInstance().get(Calendar.YEAR) 
                + StringUtils.leftPad("" + Calendar.getInstance().get(Calendar.DAY_OF_YEAR), 3, "0")
                + RandomStringUtils.randomNumeric(5);
        return code + checkSum(code);
    }

    private int checkSum(String code){
        int val=0;
        for(int i=0;i<code.length();i++){
            val+=((int)Integer.parseInt(code.charAt(i)+""))*((i%2==0)?1:3);
        }

        int checksum_digit = 10 - (val % 10);
        if (checksum_digit == 10) checksum_digit = 0;

        return checksum_digit;
    }

    public static void main(String[] args) {
        System.out.println(Calendar.getInstance().get(Calendar.YEAR));
        System.out.println(StringUtils.leftPad("" + Calendar.getInstance().get(Calendar.DAY_OF_YEAR), 3, "0"));
        System.out.println(new TagGenerator().next());
    }
}
