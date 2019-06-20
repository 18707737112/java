package com.iotek.dao;

import com.iotek.entity.Administrator;

import java.util.List;

public interface AdministratorDao {
    boolean addAdministrator(Administrator administrator);  //添加管理员
    boolean delAdministrator(int administratorId);  //指定编号删除管理员
    boolean updateAdministrator(Administrator administrator);  //指定编号替换
    Administrator queryAdministratorById(int administratorId);   //指定编号查找
    Administrator queryAdministratorByNameAndPassword(String name, String password);  // 找到了用户名和密码都匹配的User对象
    List<Administrator> queryAllAdministrators();  //读取文件（可以用来遍历用户信息）
}
