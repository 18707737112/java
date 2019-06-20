package com.iotek.zy5_29.hw5;

/*
刘备江东娶妻，赵云容易吗

刘备去江东，诸葛亮事先准备了3个锦囊给予赵云，在关键时候使用。

三个妙计分别是：1.找乔国老帮忙(开后门)

     2.求吴国太放行(诉苦)

     3.孙夫人断后

设计一个程序，模拟赵云使用锦囊的过程
*/
public class Test {
    public static void main(String[] args) {
        Person.use(new KitsA());
        Person.use(new KitsB());
        Person.use(new KitsC());
    }
}
