package com.iotek.dao;

import com.iotek.entity.User;

import java.util.List;

public interface UserDao {
    boolean saveUser(User user);
    boolean delUser(int id);
    boolean updateUser(User user);
    User queryUser(User user);

    List<User> queryAllUsers();
}
