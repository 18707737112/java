package com.iotek.质检_以前;

import java.util.Random;

/*
定义一个长度为5的数组，
 存放5个0-10的随机数。
存放完毕后，写2个方法，
分别完成根据下标插入元素，
和逆序遍历输出。
-----------------------------------------
（3）随机数实现1，下标插入1.5，逆序遍历0.5
*/
public class C {
    public static void main(String[] args) {
        int[] arr = arr();
        int a = 3;
        int b = 1000;
        int[] brr = brr(arr,a,b);
        printNum(brr);
    }
    public static int [] arr(){
        int[] brr = new int[5];
        Random random = new Random();
        int num = 0;
        for (int i = 0; i < 5; i++) {
            num = random.nextInt(10)+0;
            brr[i] = num;
            System.out.print(brr[i]+" ");
        }
        System.out.println();
        return brr;
    }
    public static int[] brr(int[] arr,int a,int b){
        int[] crr = new int[arr.length+1];
        for (int i = 0; i < crr.length; i++) {
            if(i<a){
                crr[i] = arr[i];
            }else if (i==a){
                crr[i] = b;
            }else {
                crr[i] = arr[i-1];
            }
            System.out.print(crr[i]+" ");
        }
        System.out.println();
        return crr;
    }
    public static void printNum(int[] brr){
        for (int i = brr.length; i >0; i--) {
            System.out.print(brr[i-1]+" ");
        }
    }
}
