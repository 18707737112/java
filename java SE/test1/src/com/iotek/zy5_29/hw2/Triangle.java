package com.iotek.zy5_29.hw2;

public class Triangle extends Figure{
    private Point a;
    private Point b;
    private Point c;

    public Triangle() {}

    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public void setA(Point a) {
        this.a = a;
    }

    public void setB(Point b) {
        this.b = b;
    }

    public void setC(Point c) {
        this.c = c;
    }

    public Point getA() {
        return a;
    }

    public Point getB() {
        return b;
    }

    public Point getC() {
        return c;
    }

    public void onDraw() {
        System.out.println("画三角形，三角形三个坐标：");
        System.out.print(a.toString()+",");
        System.out.print(b.toString()+",");
        System.out.println(c.toString());
    }
}