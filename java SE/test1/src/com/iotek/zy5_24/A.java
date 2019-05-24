package com.iotek.zy5_24;
/*
设计一个Rectange的类表示矩形

1.具有2个属性width和height,他们分别表示高和宽，默认值都为1

2.创建默认的矩形的无参构造方法

3.创建一个getArea()的方法，返回这个矩形的面积

4.创建一个getPerimeter()的方法返回矩形的周长
*/
public class A {
    public static void main(String[] args) {
        Rectange rectange = new Rectange();
        System.out.println("矩形的面积："+rectange.getArea());
        System.out.println("矩形的周长："+rectange.getPerimeter());
    }
}

class Rectange{
    private double height = 1;
    private double wigth = 1;

    public Rectange() {
        height = 10;
        wigth = 10;
    }

    public double getArea() {
        return height * wigth;
    }

    public double getPerimeter() {
        return 2*(height + wigth);
    }
}