package com.iotek.util;

import java.util.Random;
import java.util.Arrays;
/**
 * 生成四位验证码---> 验证码要求由 0-9 a-z A-Z组成
 *
 */
public class CodeUtil{
    public static char[] getCode(){
        char[] arr = new char[4]; // 保存四位验证码
        Random random = new Random();
        char[] cs = new char[62]; // 0~9,A-Z,a-z

        int i = 0;
        // 存入'0'~'9'
        for(char c = '0'; c <= '9'; c ++){
            cs[i++] = c;
        }
        // 存入'a'~'z'
        for(char c = 'a'; c <= 'z'; c ++){
            cs[i++] = c;
        }
        // 存入'A'~'Z'
        for(char c = 'A'; c <= 'Z'; c ++){
            cs[i++] = c;
        }


        for(int j = 0; j < arr.length;){
            // 随机数 当作下标
            int index = random.nextInt(cs.length); // 10
            // 随机下标 ==> 随机字符
            char c = cs[index]; // 'A'
            // 去重
            boolean isExist = false; // 标记是否重复（已存在）
            for(int k = 0; k < j; k ++){
                if(c == arr[k]){ // 已存在
                    isExist = true;
                    break;
                }
            }
            if(!isExist){ // 不存在，说明可用
                arr[j++] = c;
            }
        }

        //System.out.println(Arrays.toString(arr));
        return arr;
    }
}
