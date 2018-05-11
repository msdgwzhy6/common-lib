package com.simple.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by simpepeng on 2017/8/28.
 * <p>
 * 时间工具类
 */

public class DateUtils {

    public final static String YYYY_MM_DD = "yyyy-MM-dd";
    public final static String YYYYMMDD = "yyyyMMdd";
    public final static String YYYYMM = "yyyyMM";
    public final static String YYYY_MM = "yyyy-MM";
    public final static String YYYY_MM_DD_HH_MM = "yyyy-MM-dd HH:mm";
    public final static String YYYYMMDDHHMM = "yyyyMMddHHmm";
    public final static String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
    public final static String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

    public static int getAge(String birthday) {
        int age = 18;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Calendar calendar = Calendar.getInstance();

            int nowYear = calendar.get(Calendar.YEAR);
            int nowMonth = calendar.get(Calendar.MONTH) + 1;
            int nowDay = calendar.get(Calendar.DAY_OF_MONTH);

            Date birthdayDate = format.parse(birthday);
            calendar.setTime(birthdayDate);

            int birthYear = calendar.get(Calendar.YEAR);
            int birthMonth = calendar.get(Calendar.MONTH) + 1;
            int birthDay = calendar.get(Calendar.DAY_OF_MONTH);

            age = nowYear - birthYear;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return age < 0 ? 0 : age;
    }

    public static String getChatMessageTime(long timestamp) {
        return new SimpleDateFormat("yyyy/MM/dd HH:mm:ss")
                .format(new Date(timestamp * 1000));
    }

    public static long getMillis(Date date) {
        return date.getTime();
    }

    public static long getMillis(String time) {
        SimpleDateFormat format = new SimpleDateFormat(YYYY_MM_DD_HH_MM);
        Date date = null;
        try {
            date = format.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return getMillis(date);
    }

}
