package com.iotek.util;

import java.util.InputMismatchException;
import java.util.Scanner;

//有效范围：获取键盘输入的指定范围的整数【min,max】
public class MyUtil {
    private static Scanner input = new Scanner(System.in);

    public static int inputNum(int min, int max){
        while(true) {
            try {
                int num = input.nextInt();

                // 范围不合法
                if (num > max || num < min) {
                    throw new RuntimeException("范围不合法");
                }
                return num;
            } catch (InputMismatchException e) {
                System.out.println("数据类型不合法，请重新输入！");
                input.next(); // 清空输入缓冲区中的非法数据
            } catch (RuntimeException e) {
                System.out.println("数据范围不合法，请重新输入！");
            }
        }
    }

    /*public static int inputNumNew(int min, int max){
        while(true){
            try {
                int num = input.nextInt();
                if(num > max || num < min){
                    System.err.println("该编号不存在，请重新输入！");
                    continue;
                }
                return num;
            } catch (Exception e) {
                System.err.println("数据类型不匹配，请重新输入！");
                input.nextLine();    // 吸收掉Scanner缓冲区中的非法数据
            }
        }
    }*/
}
