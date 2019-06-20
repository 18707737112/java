package com.iotek.zy5_29.hw2;

public class Test529 {
    public static void main(String[] args) {
        Painter p = new Painter("达芬奇");
        Point a = new Point(0,0);
        Point b = new Point(0,1);
        Point c = new Point(1,0);
        Point o = new Point(2,2);
        Figure triangle = new Triangle(a,b,c);
        Figure round = new Round(o,1);
        p.draw(triangle);
        p.draw(round);
    }
}
