package com.iotek.zy5_29.hw3;

public class H1 extends Hummer {

    @Override
    public void start() {
        System.out.println("H1启动车辆");
    }

    @Override
    public void stop() {
        System.out.println("H1停止车辆");
    }

    @Override
    public void alarm() {
        System.out.println("H1喇叭鸣叫");
    }

    @Override
    public void engineBoom() {
        System.out.println("H1引擎发出轰鸣声");
    }

    @Override
    public void run() {
        System.out.println("H1汽车跑起来");
    }
}
