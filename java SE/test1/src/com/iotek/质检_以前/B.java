package com.iotek.质检_以前;

/*
有连个正整数a和b，已知a*b=2048，求
a、b各为何值时，a+b的值最小。
--------------------------------
（4）循环结构1，算法1，结果正确1
*/
public class B {
    public static void main(String[] args) {
        int a = 0;
        int b = 0;
        int sum = 1 + 2048;
        int count = 0;
        for (int i = 1; i <= 2048; i++) {
            for (int j = 2048; j >= 1; j--) {   //32 64 4194304
            //for (int j = 1; j <= 2048; j++) {    //32 64 4194304
                if(i*j==2048 && sum > i + j){
                    sum = i + j;
                    a = i;
                    b = j;
                }
                count++;
            }
        }
        System.out.println(a + " " + b + " " + count);
    }
}
/*
public class B {
    public static void main(String[] args) {
        int x =1;
        int y =1;
        int s=2048;
        for (int a = 1; a <= 2048; a++) {
            for (int b = 1; b <= 2048; b++) {
                if (a * b == 2048 && s > a+b) {
                    s = a+ b;
                    x =a;
                    y = b;
                }
            }
        }
        System.out.print(x + "\t" + y);
    }
}
*/
/*
public class B {
    public static void main(String[] args) {
        int a = 0, b = 0, min = 100000, num_a = 0, num_b = 0;
        for (a = 1; a <= 2048; a++) {
            if (2048 % a == 0) {
                b = 2048 / a;
                if (min > a + b) {
                    min = a + b;
                    num_a = a;
                    num_b = b;
                }
            }
        }
        System.out.print(num_a + "\t" + num_b);
    }
}
*/