package com.zy.zy5_21;

//封装一份方法，接收两个整数和一个操作符，
// 根据操作符做相应的和差积商，并返回结果。
public class A {
    public static void main(String[] args) {
        System.out.println(add(4,2));
        System.out.println(subtraction(4,2));
        System.out.println(multiplication(4,2));
        System.out.println(division(4,2));
    }
    private static int add(int a,int b){
        return a+b;
    }
    private static int subtraction(int a,int b){
        return a-b;
    }
    private static int multiplication(int a,int b){
        return a*b;
    }
    private static int division(int a,int b){
        return a/b;
    }
}
