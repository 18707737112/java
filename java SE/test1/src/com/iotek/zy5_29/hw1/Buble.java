package com.iotek.zy5_29.hw1;

public abstract class Buble implements ISwich{
    private String type;

    public Buble() {
    }

    public Buble(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    @Override
    public void onLight() {
        System.out.println("发光！");
    }

    @Override
    public void offLight() {
        System.out.println("关灯------不发光！");
    }
}
