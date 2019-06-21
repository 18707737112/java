package com.iotek.dao;

import com.iotek.entity.Dormitory;

import java.util.List;

public interface DormitoryDao {
    boolean addDormitory(Dormitory dormitory);  //添加
    boolean delDormitory(int buildIdId);  //删除
    boolean updateDormitoryCard(Dormitory dormitory);  //修改
    Dormitory queryDormitoryById(int buildId);   //指定宿舍号查找
    List<Dormitory> queryAllDormitorys();  //读取文件（可以用来遍历信息）

}
