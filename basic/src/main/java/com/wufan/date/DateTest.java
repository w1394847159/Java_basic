package com.wufan.date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {

    public static void main(String[] args) {
        beforeAndAfter(new Date(),new Date());
    }


    //获取时间
    public static void getTime(Date date){
        long time = date.getTime();
        System.out.println(time);
    }


    //比较两个日期,date1在date2之前，返回true
    //compareTo 当两个日期相同时返回0
    public static void beforeAndAfter(Date date1,Date date2){
        if(date1.before(date2)){
            System.out.println("date1在date2之前");
        }else if(date1.after(date2)){
            System.out.println("date1在date2之后");
        }else if(!Boolean.valueOf(String.valueOf(date1.compareTo(date2)))){
            System.out.println("date1和date2相同");
        }else {
            System.out.println("两者不同");
        }
    }


    /**
     * 格式化日期
     * SimpleDateFormat
     */
    public void getSimpleDateFormat(Date date,String format){
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);


    }
}
