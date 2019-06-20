package hw1;

public class Computer {
    private IUSB[] usbs = new IUSB[3];

    public Computer() {
    }

    public IUSB[] getUsbs() {
        return usbs;
    }

    public void setUsbs(IUSB usb) {
        if(usb == null){
            System.err.println("请插入合法的支持USB功能的设备");
            return ;
        }

        // 还有空白PCI插槽
        for(int i = 0; i < usbs.length; i ++){
            if(usbs[i] == null){
                usbs[i] = usb;
                usb.install();
                return ;
            }
        }

        System.out.println("USB插槽已满，将自动卸载最后一个设备");
        usbs[usbs.length-1].uninstall();
        usbs[usbs.length-1] = usb;
        usb.install();
    }
}
