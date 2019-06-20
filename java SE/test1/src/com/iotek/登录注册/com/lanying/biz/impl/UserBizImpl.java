package com.iotek.登录注册.com.lanying.biz.impl;


import com.iotek.登录注册.com.lanying.biz.UserBiz;
import com.iotek.登录注册.com.lanying.dao.UserDao;
import com.iotek.登录注册.com.lanying.dao.impl.UserDaoImpl;
import com.iotek.登录注册.com.lanying.entity.User;

import java.util.List;

// 业务层：将用户需求（业务）拆解成一个个基本操作（CRUD），然后将处理结果反馈给View层
public class UserBizImpl implements UserBiz {
    private UserDao userDao = new UserDaoImpl();

    @Override // 注册
    public boolean register(User user) {
        // 先看一下用户名是否存在
        List<User> uList = userDao.queryAllUsers();
        for (User u : uList) {
            if(u.getUname().equals(user.getUname())){
                // 已存在
                System.err.println("用户名已存在，是否要登录？");
                return false; // 如果想做得更好一些，可以返回一个整数，让View层反馈给用户（这样业务层会更纯粹）
            }
        }
        // 如果用户名不存在，则说明该用户名可用
        return userDao.addUser(user);
    }

    @Override // 登录：如果项目中需要结合类型来登录，则需要修改此方法
    public User login(User user) {
        User u = userDao.queryUserByNameAndPassword(user.getUname(),user.getUpass());
        return u;
    }
}
