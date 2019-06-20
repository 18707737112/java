package com.iotek.zy5_29.hw1;

public class RedBuble extends Buble {
    public RedBuble() {
    }

    public RedBuble(String type) {
        super(type);
    }

    @Override
    public void onLight() {
        System.out.println(getType()+"------发红光！");
    }

    @Override
    public void offLight() {
        super.offLight();
    }
}
