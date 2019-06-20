package com.iotek.zy5_31.hw2;

public class NormalNetworkCard extends NetworkCard {
    public NormalNetworkCard() {
    }

    public NormalNetworkCard(String brand) {
        super(brand);
    }

    @Override
    public String toString() {
        return super.toString() + "普通网卡";
    }
}
