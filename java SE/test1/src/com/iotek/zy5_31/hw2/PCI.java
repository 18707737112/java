package com.iotek.zy5_31.hw2;

/**
 * 不是PCI设备，此处指PCI扩展能力
 */
public interface PCI {
    void install(); // 安装PCI设备
    void uninstall(); // 卸载PCI设备
}
