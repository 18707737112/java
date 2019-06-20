package com.iotek.zy5_31;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Hw3 {
    public static void main(String[] args) {
        String date1 = "2015年2月17日";
        String date2 = "2015年3月29日";
        int days = cel(date1,date2);
        System.out.println(date1+"和"+date2+"之间一共有："+days+"天");

    }
    public static int cel(String date1,String date2){
        SimpleDateFormat s = new SimpleDateFormat("yyyy年MM月dd日");
        Date d1 = new Date();
        Date d2 = new Date();
        try {
            d1 = s.parse(date1);
            d2 = s.parse(date2);
        }catch(ParseException e){
            e.printStackTrace();
        }

        long time = (d2.getTime()-d1.getTime())/(3600000*24);
        return (int)time;
    }
}
