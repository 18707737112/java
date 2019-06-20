package com.iotek.dao.impl;

import com.iotek.dao.UserDao;
import com.iotek.entity.User;

import java.io.*;
import java.util.List;

public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {
    private File userFile = new File("file/user.dat");

    @Override
    public boolean saveUser(User user) {
        // 从文件中读出所有User
        List<User> uList = read(userFile);

        // 想用户ID自增（思路，获取最后一个user的id，在他的ID基础上+1）
        if(uList.size() == 0) {
            user.setId(1); // 第一人
        }else{
            int newID = uList.get(uList.size()-1).getId()+1;
            user.setId(newID);
        }

        // 将新用户添加到集合中（内存）
        uList.add(user);

        // 将新集合写入文件（硬盘）
        return write(uList,userFile);
    }

    @Override
    public boolean delUser(int id) {
        List<User> uList = read(userFile);
        for (int i = 0; i < uList.size(); i++) {
            User u = uList.get(i);
            if(u.getId() == id){
                uList.remove(i); // 从集合中删除了目标（内存）
                return write(uList,userFile); // 写入文件（硬盘）
            }
        }
        return false; // 没找着
    }

    @Override
    public boolean updateUser(User user) {
        List<User> uList = read(userFile);
        for (int i = 0; i < uList.size(); i++) {
            User u = uList.get(i);
            if(u.getId() == user.getId()){
                uList.set(i,user); // 用user替换u
                return write(uList,userFile);
            }
        }
        return false; // 没找着
    }

    @Override // 登录时查找目标(用户名、密码、类型 ==> 获取完整用户信息)
    public User queryUser(User user) {
        List<User> uList = read(userFile);
        for (User u : uList) {
            if (u.getUname().equals(user.getUname())
                    && u.getUpass().equals(user.getUpass())
                    && u.getType() == user.getType()) {
                return u;
            }
        }
        return null;
    }

    @Override
    public List<User> queryAllUsers(){
        return read(userFile);
    }

}
