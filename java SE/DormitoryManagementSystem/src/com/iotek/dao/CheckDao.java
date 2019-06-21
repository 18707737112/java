package com.iotek.dao;

import com.iotek.entity.Check;

import java.util.List;

public interface CheckDao {
    boolean addCheck(Check check);//添加迁入/迁出单号
    boolean delCheck(int checkId);//删除
    boolean updateCheck(Check check);//修改
    Check queryCheckById(int checkId);//指定编号查找
    //List<Check> queryCheckByIdS(int studentId);//指定学号查找
    List<Check> queryAllCheckS();//查询全部入/迁出单号
}
