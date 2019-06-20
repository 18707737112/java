package hw1;

public class Test {
    public static void main(String[] args) {
        Computer computer = new Computer();
        IUSB usb1 = new USBKeyBoard("USB键盘");
        IUSB usb2 = new USBMouse("USB鼠标");
        IUSB usb3 = new USBFan("USB风扇");
        IUSB usb4 = new USBKeyBoard("新的USB键盘");
        IUSB usb5 = new USBMouse("新的USB鼠标");
        IUSB usb6 = new USBFan("新的USB风扇");
        computer.setUsbs(usb1);
        computer.setUsbs(usb2);
        computer.setUsbs(usb3);
        computer.setUsbs(usb4);
        computer.setUsbs(usb5);
        computer.setUsbs(usb6);
    }
}
