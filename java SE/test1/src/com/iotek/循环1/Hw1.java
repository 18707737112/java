package com.iotek.循环1;

//使用do-while单循环打印输出10~100之间
// 所有能同时被5和9整除的整数
public class Hw1 {
    public static void main(String[] args) {
        int i = 10;
        System.out.println("10-100之间能同时被5和9整除的整数有：");
        do {
            if(i%5==0 && i%9==0){
                System.out.print(i+" ");
            }
            i++;
        }while (i < 100);
    }
}
