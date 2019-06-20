package com.iotek.zy5_31.hw2;

public class IndependentNetworkCard extends NetworkCard implements PCI{
    public IndependentNetworkCard() {
    }

    public IndependentNetworkCard(String brand) {
        super(brand);
    }

    @Override
    public String toString() {
        return super.toString() + "独立网卡";
    }

    @Override
    public void install() {
        System.out.println("安装=="+getBrand()+"==牌独立网卡，网卡功能已启用");
    }

    @Override
    public void uninstall() {
        System.out.println("卸载=="+getBrand()+"==牌独立网卡，网卡功能已关闭");
    }
}
