package com.iotek.dao;

import com.iotek.entity.Bed;

import java.util.List;

public interface BedDao {
    boolean addBed(Bed bed);  //添加
    boolean delBed(int bedId);  //删除
    boolean updateBed(Bed bed);  //修改
    Bed queryBedById(int bedId);   //指定宿舍号查找
    List<Bed> queryAllBeds();  //读取文件（可以用来遍历信息）

}
