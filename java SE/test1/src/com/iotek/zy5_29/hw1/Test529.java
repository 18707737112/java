package com.iotek.zy5_29.hw1;

/*
使用接口

设计一个台灯类Lamp其中台灯有灯泡这个属性

  还有开灯(on)这个方法，设计一个灯泡类 其中有红灯泡(RedBuble)

  和绿灯泡(GreenBuble) 他们都有一个发亮的方法

  请设计出一段代码可以使台灯开启灯泡发亮，并且

  保证替换不同种类的灯泡 台灯类代码不被修改
  */
public class Test529 {
    public static void main(String[] args) {
        Lamp lamp = new Lamp("四叶草牌");
        Buble redBuble = new RedBuble("节能红灯泡");
        Buble greenBuble = new GreenBuble("节能绿灯泡");
        System.out.println("--------------------------------");
        lamp.setiSwich(redBuble);
        lamp.on();
        lamp.off();
        System.out.println("--------------------------------");
        lamp.setiSwich(greenBuble);
        lamp.on();
        lamp.off();
        System.out.println("--------------------------------");
    }
}
