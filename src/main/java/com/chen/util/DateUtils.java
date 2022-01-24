package com.chen.util;

import java.util.Calendar;
import java.util.Date;

public class DateUtils {


    //    获取今天日期
    public static Date getTodayDate(){
        Calendar date=Calendar.getInstance();
        date.set(Calendar.DATE,date.get(Calendar.DATE));
//        将时间都设置为12点整
        date.set(Calendar.HOUR_OF_DAY, 0);
        date.set(Calendar.MINUTE, 0);
        date.set(Calendar.SECOND, 0);
        date.set(Calendar.MILLISECOND, 0);
        return date.getTime();
    }
    /**
     * 获取昨天的日期
     */
    public static Date getYesterdayDate(){
        Calendar date=Calendar.getInstance();
        date.set(Calendar.DATE,date.get(Calendar.DATE)-1);
//        将时间都设置为12点整
        date.set(Calendar.HOUR_OF_DAY, 0);
        date.set(Calendar.MINUTE, 0);
        date.set(Calendar.SECOND, 0);
        date.set(Calendar.MILLISECOND, 0);
        return date.getTime();
    }

}
