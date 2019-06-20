package com.iotek.zy5_31.hw2;

public class TestCard implements PCI {
    @Override
    public void install() {
        System.out.println("安装测试卡");
    }

    @Override
    public void uninstall() {
        System.out.println("卸载测试卡");
    }
}
