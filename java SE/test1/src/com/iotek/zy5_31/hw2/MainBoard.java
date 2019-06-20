package com.iotek.zy5_31.hw2;

public class MainBoard {
    private SoundCard sc = new NormalSoundCard("德洪");
    private NetworkCard nc = new NormalNetworkCard("德洪");
    private PCI[] ps = new PCI[3]; // 3个插槽

    public MainBoard() {
    }

    public PCI[] getPci() {
        return ps;
    }

    public void setPci(PCI pci) {
        if(pci == null){
            System.err.println("请插入合法的支持PCI功能的设备");
            return ;
        }

        // 还有空白PCI插槽
        for(int i = 0; i < ps.length; i ++){
            if(ps[i] == null){
                ps[i] = pci;
                pci.install();
                return ;
            }
        }

        // 如果满了，则卸载最后一个设备
        System.out.println("PCI插槽已满，将自动卸载最后一个设备");
        ps[ps.length-1].uninstall();
        ps[ps.length-1] = pci;
        pci.install();

    }


}
