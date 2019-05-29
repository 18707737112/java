package com.iotek.zy5_25.b;

/*
需求
1）定义一个(Person)类,包含属性：姓名，年龄，性别；
    写好相关的方法，能够构造的时候初始化或者后续修改属性值。
2）定义一个Employee类继承于Person类，包含新的属性：职位；
    写好相关的方法，能够构造的时候初始化或者后续修改属性值，重写equals方法，
    规则：当两个对象的姓名，年龄，性别，职位都相等时返回true，否则返回false。
3）写一个测试类进行相关测试（要求可以打印对象的信息，能够比较对象是否"相等"）。
*/
public class Test {
    public static void main(String[] args) {
        Person employee1= new Employee("Jim",28,"男","软件工程师");
        Person employee2= new Employee("Tom",28,"男","软件工程师");
        System.out.println(employee1.toString());
        System.out.println(employee2.toString());
        System.out.println(employee1.equals(employee2));
    }
}
