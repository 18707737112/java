package com.iotek.质检_以前;

/*
统计个位数是6，并且被3整除的5位数共有多少个。
------------------------------------
（3分）判断条件1分，循环逻辑控制2分
*/
public class A {
    public static void main(String[] args) {
        int count = 0;
        for (int i = 10000; i <100000 ; i++) {
            if (i%10==6 && i%3==0){
                count ++;
            }
        }
        System.out.println(count);
    }
}
