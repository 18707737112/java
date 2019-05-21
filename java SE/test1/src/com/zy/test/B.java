package com.zy.test;

public class B {
    public static void main(String[] args) {
        fact(4);
    }

    public static int[] generateArray(int min,int max,int length){

        return null;
    }

    public static long fact(int n){
        long s=1;
        for (int i = 1; i <= n; i++) {
            s *= i;
        }
        System.out.println(s);
        return s;
    }
}
