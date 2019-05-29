package com.iotek.zy5_25.a;

public class Square extends Shape{
    private double side;

    public Square() {
    }

    public Square(double side) {
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    @Override
    public void draw() {
        super.draw();
        if (side < 0) {
            System.out.println("正方形边长不能为负，无法正常作画！");
        }else {
            System.out.println("画正方形:"+"边长为"+side);
        }
    }
}
