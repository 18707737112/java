package com.iotek.zy5_22;
/*
一球从100米高度自由落下，
每次落地后反跳回原高度的一半，再落下，
求它在第10次落地时，共经过多少米？
第10次反弹多高？
100-50-50-25-25------
*/
public class A {
    public static void main(String[] args) {
        action(100,10);
    }
    private static void action(double high,int count){
        double sum = high;
        for (int i = 1; i < 10; i++) {
            high /= 2;
            sum += high*2;
        }
        System.out.println("第"+count+"次落地时,小球共经过："+sum+"米");
        System.out.println("第十次反弹时的高度是："+high/2);
    }
}
