package com.iotek.zy5_29.hw2;

public class Painter {
    private String name;

    public Painter() {}

    public Painter(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name+"开始画画：";
    }

    public void draw(Figure figure){
        System.out.println(toString());
        figure.onDraw();
    }
}
