package com.iotek.数组3;

import java.util.Scanner;

/*
* 有一个数组{2,4,5,6,1,10,12,7,1}，
* 要求用户键盘上输入一个数，如果存在，
* 打印出该数字出现的位置，如果不存在，
* 打印-1，算法要求封装为方法
*/
public class Hw2 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("输入：");
        int a = input.nextInt();
        System.out.println();
        int[] arr = {0,1,2,3,4,5,6};
        is(arr,a);
    }

    public static void is(int[] arr,int a) {
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==a){
                System.out.print("所在位置：");
                System.out.println(i);
                return;
            }
        }
        System.out.println("-1");
    }
}
