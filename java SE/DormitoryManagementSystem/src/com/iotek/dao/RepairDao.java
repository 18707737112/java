package com.iotek.dao;

import com.iotek.entity.Repair;

import java.util.List;

public interface RepairDao {
    boolean addRepair(Repair repair);  //添加报修单
    boolean delRepair(int repairId);  //删除报修单
    boolean updateRepair(Repair repair);  //修改报修单
    Repair queryRepairById(int repairId);   //指定编号查找报修单
    List<Repair> queryRepairByIdS(int studentId);   //指定学号查找报修单
    List<Repair> queryAllRepairs();  //读取文件（可以用来遍历报修单信息）
}
