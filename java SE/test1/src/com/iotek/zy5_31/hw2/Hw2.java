package com.iotek.zy5_31.hw2;

/**
 *  编写一个程序，模拟以下场景：
 * 	现有一块电脑主板，其主板本身已经集成了网卡和声卡功能，
 * 	但是为了满足市场的需求，主板上提供了3个PCI接口，提供给用户后期扩展功能使用。
 * 	用户可以在PCI接口上插上各种PCI设备，
 * 	例如可以支持千M网速的独立网卡、
 * 	HIFI音质的独立声卡、
 * 	检测专用的检测卡等。
 */
public class Hw2 {
    public static void main(String[] args) {
        MainBoard mb = new MainBoard();
        PCI p1 = new IndependentSoundCard("老大哥");
        PCI p2 = new IndependentNetworkCard("老二哥");
        PCI p3 = new TestCard();

        mb.setPci(p1);
        mb.setPci(p2);
        mb.setPci(p3);
        mb.setPci(p1);
        mb.setPci(p2);
        mb.setPci(p3);
    }
}
