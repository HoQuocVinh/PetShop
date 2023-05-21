package com.hcmute.vinh19110318.utils;

import java.util.Random;

public class Constants {
    public static final String DEFAULT_PAGE_NUMBER = "0";
    public  static final String DEFAULT_PAGE_SIZE = "2";
    public static final String DEFAULT_SORT_BY = "firstName";
    public static final String DEFAULT_SORT_DIRECTION = "asc";

    public static String generateTempPwd(int length) {
        String numbers = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        char otp[] = new char[length];
        Random getOtpNum = new Random();
        for (int i = 0; i < length; i++) {
            otp[i] = numbers.charAt(getOtpNum.nextInt(numbers.length()));
        }
        String optCode = "";
        for (int i = 0; i < otp.length; i++) {
            optCode += otp[i];
        }
        return optCode;
    }
}
