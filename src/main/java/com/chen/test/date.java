package com.chen.test;

import java.util.Calendar;
import java.util.Date;

public class date {
    public static void main(String[] args) {
        System.out.println(getTodayDate());
    }
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
}
