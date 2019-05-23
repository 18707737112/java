package com.iotek.test;

//求斐波那数第n个数
public class A {
    public static void main(String[] args) {
        fibo(4);
    }
    public static int fibo(int n){
        int a = 1;
        int b = 1;
        int c = a+b;
        if(n<1){
            System.out.println("输入错误！");
            return -1;
        }else if(n == 1 || n == 2){
            System.out.println(1);
            return 1;
        }
        for (int i = 3; i <= n ; i++) {
            c = a+b;
            a = b;
            b = c;
        }
        System.out.println(c);
        return c;
    }
}
