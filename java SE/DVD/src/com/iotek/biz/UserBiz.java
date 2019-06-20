package com.iotek.biz;

import com.iotek.entity.User;

public interface UserBiz {
    User login(User user); // 1.登录--T
    boolean register(User user); // 2.注册--T

}
