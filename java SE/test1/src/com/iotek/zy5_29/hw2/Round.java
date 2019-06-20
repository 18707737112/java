package com.iotek.zy5_29.hw2;

public class Round extends Figure{
    private Point o;
    private double r;

    public Round() {}

    public Round(Point o, double r) {
        this.o = o;
        this.r = r;
    }

    public void setO(Point o) {
        this.o = o;
    }

    public void setR(double r) {
        this.r = r;
    }

    public Point getO() {
        return o;
    }

    public double getR() {
        return r;
    }

    public void onDraw() {
        System.out.print("画圆，圆心坐标：");
        System.out.print(o.toString()+",");
        System.out.println("半径:"+r);
    }
}