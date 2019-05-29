package com.iotek.zy5_25.a;

public class Circle extends Shape {
    private double radius;

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public void draw() {
        super.draw();
        if (radius<0){
            System.out.println("圆的半径不能为负，无法正常作画！");
        }else {
            System.out.println("画圆："+"半径为"+radius);
        }
    }
}
