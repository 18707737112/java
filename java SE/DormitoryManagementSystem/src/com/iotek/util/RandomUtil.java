package com.iotek.util;

import java.util.Random;

public class RandomUtil {
    private static Random random = new Random();

    public static int number(int length){
        while(true) {
            try {
                // 范围不合法
                if (length<=0) {
                    throw new RuntimeException("长度不合法");
                }
                int num = random.nextInt(length)+0;
                return num;
            } catch (Exception e) {
                //System.out.println("数据类型不合法，请重新输入！");
            }
        }
    }
}
