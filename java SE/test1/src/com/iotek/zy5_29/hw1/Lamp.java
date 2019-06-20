package com.iotek.zy5_29.hw1;

public class Lamp {
    private String name;
    private ISwich iSwich;

    public Lamp() {
    }

    public Lamp(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ISwich getiSwich() {
        return iSwich;
    }

    public void setiSwich(ISwich iSwich) {
        this.iSwich = iSwich;
    }

    public void on(){
        if(iSwich!=null){
            System.out.println("大家好，我是"+name+"台灯，欢迎使用！");
            iSwich.onLight();
        }else {
            System.out.println("不要着急，还没安装灯泡，怎么会亮！");
        }
    }
    public void off(){
        iSwich.offLight();
    }
}
