package com.iotek.zy5_29.hw4;

import java.util.Scanner;

/*
设计一个产生女朋友的工厂(对你没有看错是女朋友)，并测试

要求：

1：设计BaseGF类，含有抽象无参方法 eat(),普通无参方法shopping(),

2：三个子类分别继承BaseGF

3：设计GFFactory类，含有静态方法:BaseGF createGF(String gfType)

4：设计gfType判断，只能是，四川，广东，山东

5：测试，分别创建三个类的对象，并调用对象的两个方法
*/
public class Test {
    public static void main(String[] args) {
        System.out.println("请输入您想要那个地方的妹子：");
        Scanner input = new Scanner(System.in);
        String gfType = input.next();
        BaseGF baseGF = GFFactory.createGF(gfType);
        if(gfType!=null){
            System.out.println("恭喜你，得到了一个"+baseGF.getGfType());
            baseGF.eat();
            baseGF.shopping();
        }
    }
}
