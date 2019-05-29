package com.iotek.zy5_25.a;

/*
父类Shape代表各种形状，
子类Circle（圆）、Triangle（三角形）、Square（正方形）
继承Circle。
父类总有绘画方法draw()，子类重写。
要求主方法产生一个形状数组，包含各类形状，让它们各自画出自己。
*/
public class Test {
    public static void main(String[] args) {
        Shape circle=new Circle(5);
        Shape triangle=new Triangle(2,3,4);
        Shape square=new Square(5);
        String[] figure={"circle","triangle","square"};
        for (String s : figure) {
            if (s.equals("circle")){
                circle.draw();
            }
            if (s.equals("triangle")) {
                triangle.draw();
            }
            if (s.equals("square")){
                square.draw();
            }
        }
    }
}
