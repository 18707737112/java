package com.iotek.dao;

import com.iotek.entity.Record;
import com.iotek.entity.Record2;

import java.util.List;

public interface RecordDao {
    Record queryRecordById(int rid);//查看指定id的DVD接环记录
    boolean saveRecord(Record record);//保存record记录
    boolean updateRecord(Record record);//更新record记录
    List<Record> queryAllRecords();//查询所有的DVD借还记录
    List<Record2> queryRecordByUname(String uname);//查询指定用户的借还记录
    List<Record2> queryRecordByDname(String dname);//查询指定DVD的借还记录
    List<Record2> queryUserRecordByReturnTime(boolean flag, String returnTime);//查询用户的归还记录（已归还，未归还）
}
