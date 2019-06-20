package com.iotek.zy6_03;

import java.util.Scanner;

/*写一个方法，从键盘输入一个整数，如果输入的不是整数，则提示输入有误，请重新输入，直到输入正确为止。*/
public class Hw3 {
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("请输入数字：");
        inputNum(0,Integer.MAX_VALUE);//Integer.MAX_VALUE=2147483647
    }
    public static int inputNum(int min, int max){
        while(true){
            try {
                int num = sc.nextInt();
                if(num <= max || num >= min){
                    System.out.println("Very good！！！该数字是整数！");
                }
                return num;
            } catch (Exception e) {
                System.err.println("数据类型不匹配，请重新输入！");
                sc.nextLine();    // 吸收掉Scanner缓冲区中的非法数据
            }
        }
    }
}
