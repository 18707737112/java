package com.iotek.zy5_23;

import java.util.Scanner;

/*
输入自己的身份证号码，
并由此号码输出自己的生日，
年月日（String）
*/
public class A {
    public static void main(String[] args) {
        System.out.println("请输入您的身份证号码：");
        Scanner input = new Scanner(System.in);
        String id = input.next();
        String birth = birthday(id);
        System.out.println("您的生日："+birth);
    }
    private static String birthday(String id){
        String year = id.substring(6,10);
        String month = id.substring(10,12);
        String day = id.substring(12,14);
        return year+"年"+month+"月"+day+"日";
    }
}
