package com.iotek.zy5_30.hw1;

public class ColorPrinter extends Printer{
    public ColorPrinter() {
    }
    public ColorPrinter(String brand) {
        super(brand);
    }
    @Override
    public void print(String content) {
        System.out.println(getBrand()+"彩色打印:"+content);
    }
}
