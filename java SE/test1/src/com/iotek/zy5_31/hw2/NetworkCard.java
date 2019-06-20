package com.iotek.zy5_31.hw2;

public class NetworkCard {
    private String brand;

    public NetworkCard() {
    }

    public NetworkCard(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return brand+"牌";
    }
}
