package com.iotek.biz;

import com.iotek.entity.Administrator;

public interface AdministratorBiz {
    boolean register(Administrator administrator); // 注册(测试类注册)
    Administrator login(Administrator administrator); //1.登录
    void lookAllStudents();
}
