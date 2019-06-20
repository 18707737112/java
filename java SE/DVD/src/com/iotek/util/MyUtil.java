package com.iotek.util;

import java.util.Scanner;

//有效范围：获取键盘输入的指定范围的整数【min,max】
public class MyUtil {
    private static Scanner input = new Scanner(System.in);

    public static int inputNum(int min, int max){
        while(true){
            try {
                int num = input.nextInt();
                if(num > max || num < min){
                    System.err.println("编号输入错误，请重新输入！");
                    continue;
                }
                return num;
            } catch (Exception e) {
                System.err.println("数据类型不匹配，请重新输入！");
                input.nextLine();    // 吸收掉Scanner缓冲区中的非法数据
            }
        }
    }
}
