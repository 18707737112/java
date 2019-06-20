package com.iotek.dao;

import com.iotek.entity.Top;

import java.util.List;

public interface TopDao {
    boolean addTop(Top top);  //添加充值单
    boolean delTop(int studentId);  //删除
    boolean updateTop(Top top);  //修改
    List<Top> queryTopById(int studentId);   //指定学号查找
    List<Top> queryAllTops();  //读取文件（可以用来遍历信息）
}
