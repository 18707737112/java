package com.iotek.登录注册.com.lanying.dao;

import com.iotek.登录注册.com.lanying.entity.User;

import java.util.List;

// UserDao中封装了对User.dat文件的增删改查操作
public interface UserDao {
    boolean addUser(User user);
    boolean delUser(int uid);
    boolean updateUser(User user);
    User queryUserById(int uid);
    User queryUserByNameAndPassword(String name, String password);
    List<User> queryAllUsers();
}
