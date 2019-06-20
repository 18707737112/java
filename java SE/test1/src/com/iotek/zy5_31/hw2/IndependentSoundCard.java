package com.iotek.zy5_31.hw2;

public class IndependentSoundCard extends SoundCard implements PCI{
    public IndependentSoundCard() {
    }

    public IndependentSoundCard(String brand) {
        super(brand);
    }

    @Override
    public String toString() {
        return super.toString()+"独立声卡";
    }

    @Override
    public void install() {
        System.out.println("安装--"+getBrand()+"--牌独立声卡，声卡功能已启用");
    }

    @Override
    public void uninstall() {
        System.out.println("卸载--"+getBrand()+"--牌独立声卡，声卡功能已关闭");
    }
}
