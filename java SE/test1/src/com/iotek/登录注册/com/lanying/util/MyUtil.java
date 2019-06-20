package com.iotek.登录注册.com.lanying.util;

import java.util.Scanner;

public class MyUtil {
    private static Scanner input = new Scanner(System.in);
    /**
     * 获取键盘输入的指定范围的整数
     * @param min 最小值（包含）
     * @param max 最大值（包含）
     * @return
     */
    public static int inputNum(int min, int max){
        while(true){
            try {
                int num = input.nextInt();
                if(num > max || num < min){
                    System.err.println("数据范围不合法，请重新输入！");
                    continue;
                }
                return num;
            } catch (Exception e) {
                System.err.println("数据类型不匹配，请重新输入！");
                input.nextLine(); // 吸收掉Scanner缓冲区中的非法数据
            }
        }
    }
}
