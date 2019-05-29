package com.iotek.zy5_28;

public class Fish extends Foot{
    public Fish(String type) {
        super(type);
    }

    @Override
    public String foot() {
        if(getType().matches(".*鱼")){
            return super.foot();
        }
        return "食物品种错误，拜托，我是鱼！！！";
    }
}
