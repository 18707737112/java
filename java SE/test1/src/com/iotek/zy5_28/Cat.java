package com.iotek.zy5_28;

public class Cat extends Pet{
    public Cat(String name) {
        super(name);
    }

    @Override
    public void eat(Foot foot) {
        if(foot.getType().matches(".*鱼")){
            System.out.println(getName()+"在吃"+foot.getType());
        }else {
            System.out.println(getName()+"不吃"+foot.getType());
        }
    }
}
