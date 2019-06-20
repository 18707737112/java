package com.iotek.登录注册.com.lanying.biz;


import com.iotek.登录注册.com.lanying.entity.User;

// 业务层：与User相关的业务
public interface UserBiz {
    boolean register(User user); // 注册
    User login(User user); // 登录
    // ...
}
