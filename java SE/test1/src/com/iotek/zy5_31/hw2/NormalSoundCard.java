package com.iotek.zy5_31.hw2;

public class NormalSoundCard extends SoundCard {
    public NormalSoundCard() {
    }

    public NormalSoundCard(String brand) {
        super(brand);
    }

    @Override
    public String toString() {
        return super.toString()+"普通声卡";
    }
}
