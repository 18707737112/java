package com.iotek.zy5_31;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Hw1 {
    public static void main(String[] args) {
        System.out.println("当前日期："+new Date());
        SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String now = sim.format(new Date());
        System.out.println("转化后日期："+now);
    }
}
