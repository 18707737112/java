package com.zy.数组3;

//封装一个方法，求一个一维数组的平均值
public class Hw1 {
    public static void main(String[] args){
        int[] arr = {0,1,2,3,4,5,6};
        average(arr);
    }
    public static void average(int[] arr){
        int sum = 0 ;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        double are = sum/arr.length;
        System.out.println(are);
    }
}
