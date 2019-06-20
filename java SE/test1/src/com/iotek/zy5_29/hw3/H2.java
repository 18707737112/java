package com.iotek.zy5_29.hw3;

public class H2 extends Hummer {

    @Override
    public void start() {
        System.out.println("H2启动车辆");
    }

    @Override
    public void stop() {
        System.out.println("H2停止车辆");
    }

    @Override
    public void alarm() {
        System.out.println("H2喇叭鸣叫");
    }

    @Override
    public void engineBoom() {
        System.out.println("H2引擎发出轰鸣声");
    }

    @Override
    public void run() {
        System.out.println("H2汽车跑起来");
    }
}
