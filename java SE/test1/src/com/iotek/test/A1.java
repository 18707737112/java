package com.iotek.test;

import java.util.Random;

public class A1 {
    public static void main(String[] args) {
        int[] arr = array(5,9,10);
        traverse(arr);
    }
    private static int[] array(int min,int max,int length){
        Random random = new Random();
        int [] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = random.nextInt(max-min+1)+min;
        }
        return arr;
    }
    private static void traverse(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }
}
