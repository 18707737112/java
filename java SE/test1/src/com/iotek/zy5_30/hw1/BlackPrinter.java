package com.iotek.zy5_30.hw1;

public class BlackPrinter extends Printer{
    public BlackPrinter() {
    }
    public BlackPrinter(String brand) {
        super(brand);
    }
    @Override
    public void print(String content) {
        System.out.println(getBrand()+"黑白打印:"+content);
    }
}
