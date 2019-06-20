package com.iotek.登录注册.com.lanying.dao.impl;

import com.iotek.登录注册.com.lanying.dao.UserDao;
import com.iotek.登录注册.com.lanying.entity.User;

import java.io.File;
import java.util.List;

public class UserDaoImpl extends BaseDao<User> implements UserDao {
    private File userFile = new File("F:/user.dat");

    @Override
    public boolean addUser(User user) {
        // 读取文件，得到List<User>
        List<User> list = read(userFile);
        // list.add(user)

        if(list.size() == 0){
            user.setId(1); // 第一个User的id为1
        }else{
            User u = list.get(list.size()-1); // 因为一直将新User对象加在最后，所以最后一个User的id应该是最大值
            user.setId(u.getId()+1); // 后续用户id自增
        }

        list.add(user); // id自增

        // 写入文件
        return write(userFile,list);
    }

    @Override
    public boolean delUser(int uid) {
        List<User> uList = read(userFile);
        for (int i = 0; i < uList.size(); i++) {
            User u = uList.get(i);
            if(u.getId() == uid){
                uList.remove(i);
                return write(userFile,uList); // 一定记得要写入文件
            }
        }
        return false; // 删除失败
    }

    @Override
    public boolean updateUser(User user) {
        List<User> uList = read(userFile);
        for (int i = 0; i < uList.size(); i++) {
            User u = uList.get(i);
            if(u.getId() == user.getId()){ // 判定条件自定义，此处是ID相同即对象相同
                uList.set(i,user); // 用user替换了u
                return write(userFile,uList);
            }
        }
        return false;
    }

    @Override
    public User queryUserById(int uid) {
        List<User> uList = read(userFile);
        for (int i = 0; i < uList.size(); i++) {
            User u = uList.get(i);
            if(u.getId() == uid){
                return u;
            }
        }
        return null;
    }

    @Override
    public User queryUserByNameAndPassword(String name, String password) {
        List<User> uList = read(userFile);
        for (User user : uList) {
            // 找到了用户名和密码都匹配的User对象
            if(user.getUname().equals(name) && user.getUpass().equals(password)){
                return user;
            }
        }
        return null;
    }

    @Override
    public List<User> queryAllUsers() {
        return read(userFile);
    }


}
