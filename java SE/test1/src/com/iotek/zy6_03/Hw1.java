package com.iotek.zy6_03;

import java.util.Scanner;

/*
写一个方法void judge(int a, int b, int c)，
判断三个参数是否能构成一个三角形，
如果不能抛出异常IllegalArgumentException，
显示异常信息a，b，c+“不能构成三角形”，
如果可以构成则显示三角形三个边长，
在主方法中得到命令行输入的三个整数，
调用此方法，并捕获异常。
*/
public class Hw1 {
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int a = 0;
        int b = 0;
        int c = 0;
        System.out.println("请输入三角形的三边：");
        System.out.println("三角形的第一边长度是：");
        a = inputNum(0,Integer.MAX_VALUE);//Integer.MAX_VALUE=2147483647
        System.out.println("三角形的第二边长度是：");
        b = inputNum(0,2147483647);
        System.out.println("三角形的第三边长度是：");
        c = inputNum(0,2147483647);
        judge(a,b,c);
    }
    public static void judge(int a, int b, int c){
        if((a + b) > c && (a + c) > b && (b + c) > a){
            System.out.println("恭喜你，创建新的三角形成功！");
            System.out.println("可以构成三角形，三边长度分别是：");
            System.out.println(a+","+b+","+c);
        }else {
            try {
                throw new IllegalArgumentException("不能构成三角形！！！");
            } catch(IllegalArgumentException e){
                e.printStackTrace();
            }
        }
    }
    public static int inputNum(int min, int max){
        while(true){
            try {
                int num = sc.nextInt();
                if(num > max || num < min){
                    System.err.println("数字超出范围，请重新输入！");
                    continue;//看到continue时立即结束本次循环，继续执行下一次循环。
                }
                return num;
            } catch (Exception e) {
                System.err.println("数据类型不匹配，请重新输入！");
                sc.nextLine();    // 吸收掉Scanner缓冲区中的非法数据
            }
        }
    }
}
