package com.zy.循环1;
//求1+1/3+1/5+...之和，
// 直到某一项的值小于10-6时停止累加
public class Hw3 {
    public static void main(String[] args) {
        double sum = 0;
        for (int i = 1; i < 1000000; i += 2) {
            sum += 1.0/i;
            /*if (i==5){
                System.out.println(sum);
                return;
            }*/
        }
        System.out.println(sum);
    }
}
