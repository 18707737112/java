package com.iotek.zy5_28;

public class Pet {
    private String name;

    public Pet() {
    }

    public Pet(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void eat(Foot foot){
        System.out.println(getName()+"在吃"+foot.getType());
    }
}
