package com.wufan.date;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateTest02 {


    /**
     * 自定义时间
     */
    @Test
    public void setTime(){
        //new Date(1900+year,month,day)
        Date date = new Date(123, 10, 11);
        Date date1 = new Date(122, 11, 11);
        System.out.println(date.toString());
        System.out.println(date1.toString());
    }

    /**
     *  获取当前时间
     */
    @Test
    public void getTime(){
        Date date = new Date();

        long time = date.getTime();
        System.out.println("当前时间为："+time);
    }

    /**
     * 比较两个时间
     */
    @Test
    public void compare(){
        Date date = new Date();
        Date date1 = new Date(date.getTime() - 10000L);

        int i = date.compareTo(date1);
        System.out.println("两个时间比较为："+i);
        boolean after = date.before(date1);
        System.out.println("date比date2大："+after);

    }

    /**
     * 格式化日期
     */
    @Test
    public void dateFormat(){
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        //公元 2023年 第 10 周 星期三
        SimpleDateFormat dateFormat1 = new SimpleDateFormat("GG yyyy 第 w 周 E");
        String format = dateFormat.format(date);
        String format1 = dateFormat1.format(date);
        System.out.println("格式化日期为："+format);
        //公元 2023 第 10 周
        System.out.println("格式化日期为："+format1);
    }

    /**
     * Calendar类对象
     */
    @Test
    public void calendar(){
        //创建当前日期的calendar对象
        Calendar c = Calendar.getInstance();

        //创建指定日期对象
        Calendar c1 = Calendar.getInstance();
        c1.set(2012,11,12);

        //获得年份
        int year = c1.get(Calendar.YEAR);
        //获得月份
        int month = c1.get(Calendar.MONTH);
        //获得天
        int date = c1.get(Calendar.DATE);
        System.out.println("当前年份："+year+"\n当前月份："+month+"\n当前天："+date);


    }

    /**
     * GregorianCalendar 实现
     * GregorianCalendar是 Calendar的具体实现
     */
    @Test
    public void test(){
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        //设置具体年月
        gregorianCalendar.set(2022,10,12);
        System.out.println(gregorianCalendar.getTime());
        //设置具体年月时间
        gregorianCalendar.set(2022,11,12,14,45,22);
        System.out.println(gregorianCalendar.getTime());
        //获取时区
        System.out.println(gregorianCalendar.getTimeZone());
        //判断年份是否为闰年
        boolean leapYear = gregorianCalendar.isLeapYear(2024);
        System.out.println("当前年份"+ (leapYear?"是闰年":"不是闰年"));

    }

}
