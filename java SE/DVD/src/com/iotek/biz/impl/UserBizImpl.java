package com.iotek.biz.impl;

import com.iotek.biz.UserBiz;
import com.iotek.dao.UserDao;
import com.iotek.dao.impl.UserDaoImpl;
import com.iotek.entity.User;

import java.util.List;

public class UserBizImpl implements UserBiz {
    private UserDao userDao = new UserDaoImpl();

    @Override
    public User login(User user) {
        User u = userDao.queryUser(user);
        return u;
    }

    @Override // 注册
    public boolean register(User user) {
        // 先看一下用户名是否存在
        List<User> uList = userDao.queryAllUsers();
        for (User u : uList) {
            if(u.getUname().equals(user.getUname())){
                // 已存在
                System.err.println("用户名已存在，是否要登录？");
                return false;
            }
        }
        // 如果用户名不存在，则说明该用户名可用
        return userDao.saveUser(user);
    }
}
