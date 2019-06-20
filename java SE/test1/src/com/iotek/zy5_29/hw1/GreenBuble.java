package com.iotek.zy5_29.hw1;

public class GreenBuble extends Buble {
    public GreenBuble() {
    }

    public GreenBuble(String type) {
        super(type);
    }

    @Override
    public void onLight() {
        System.out.println(getType()+"------发绿光！");
    }

    @Override
    public void offLight() {
        super.offLight();
    }
}
