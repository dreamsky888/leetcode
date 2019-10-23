package com.liuzx.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @Author: liuzx
 * @Date: 2019/10/22 13:40
 * @Description: 日期工具类
 **/
public class DateUtil {
    public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:SS";
    public static final String DATE_FORMAT = "yyyy-MM-dd";
    public static String getDateTimeString(LocalDateTime time) {
        return time.format(DateTimeFormatter.ofPattern(DATE_TIME_FORMAT));
    }
    public static String getDateString(LocalDateTime time) {
        return time.format(DateTimeFormatter.ofPattern(DATE_FORMAT));
    }
    public static String getDateString(LocalDate date) {
        return date.format(DateTimeFormatter.ofPattern(DATE_FORMAT));
    }

    public static String date2String(LocalDateTime time, String pattern) {
        return time.format(DateTimeFormatter.ofPattern(pattern));
    }

    public static void main(String[] args) {
        String s = DateUtil.getDateString(LocalDate.now());
        System.out.println(s);
    }
}
