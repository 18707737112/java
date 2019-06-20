package com.iotek.zy5_30.hw1;

public abstract class Printer {
    private String brand;
    public Printer() {
    }
    public Printer(String brand){
        this.brand=brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public String getBrand(){
        return brand;
    }
    public abstract void print(String content);
}
