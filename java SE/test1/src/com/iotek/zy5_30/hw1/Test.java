package com.iotek.zy5_30.hw1;
/**
 * 学校中心配备一台打印机(Printer)（可以是黑白打印机(BlackPrinter)，也可以是彩色打印机(ColorPrinter)
 * 【将来还会新增针式打印机(ZhenPrinter)、激光打印机(LaserPrinter)等等……】）。
 * 中心可以通过打印机打印学员(Student)的个人信息
 * （张三和李四等【将来还可以打印课本（Book）、身份证(IDCard)等等……】）。
 * 请遵循面向接口编程的设计原则通过继承和多态来设计这个程序，使程序具有更好的扩展性和维护性。
 */
public class Test {
    public static void main(String[] args) {
        Printer p1 = new BlackPrinter("联想");
        Printer p2 = new ColorPrinter("佳能");
        School school = new School();
        Student student = new Student("小明",18);
        Book book = new Book("高数",68);
        school.setPrinter(p1);//安装黑白打印机
        school.startPrint(student);
        school.setPrinter(p2);//安装彩色打印机
        school.startPrint(book);
    }

}






