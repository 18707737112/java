package com.iotek.zy5_28;

public class Dog extends Pet{
    public Dog(String name) {
        super(name);
    }

    @Override
    public void eat(Foot foot) {
        if(foot.getType().matches(".*骨头")){
            System.out.println(getName()+"在吃"+foot.getType());
        }else {
            System.out.println(getName()+"不吃"+foot.getType());
        }
    }
}
