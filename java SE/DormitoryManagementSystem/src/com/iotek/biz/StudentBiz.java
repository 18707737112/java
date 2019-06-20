package com.iotek.biz;

import com.iotek.entity.Administrator;
import com.iotek.entity.StudentCard;

public interface StudentBiz {
    boolean register(StudentCard studentCard); // 注册(测试类注册)
    StudentCard login(StudentCard studentCard); //1.登录
    void topIn(StudentCard studentCard,double money);//2.充值
    void topOut(StudentCard studentCard,double money);//消费
}
