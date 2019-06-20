package com.iotek.dao.impl;

import com.iotek.dao.DVDDao;
import com.iotek.dao.RecordDao;
import com.iotek.dao.UserDao;
import com.iotek.entity.DVD;
import com.iotek.entity.Record;
import com.iotek.entity.Record2;
import com.iotek.entity.User;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class RecordDaoImpl extends BaseDaoImpl<Record> implements RecordDao {
    private File recordFile = new File("file/record.dat");

    @Override//查看指定id的DVD接环记录
    public Record queryRecordById(int rid) {
        return null;
    }

    @Override//保存record记录
    public boolean saveRecord(Record record) {
        List<Record> dList = read(recordFile);
        if(dList.size() == 0){
            record.setId(1);
        }else{
            int newId =dList.get(dList.size()-1).getId()+1;
            record.setId(newId);
        }
        dList.add(record);

        return write(dList,recordFile);
    }

    @Override //更新record记录
    public boolean updateRecord(Record record) {
        List<Record> dList = read(recordFile);
        for (int i = 0; i < dList.size(); i++) {
            Record d = dList.get(i);
            if(d.getId() == record.getId()){
                dList.set(i,record);
                return write(dList,recordFile);
            }
        }
        return false;
    }

    @Override//查询所有的DVD借还记录
    public List<Record> queryAllRecords() {
        return read(recordFile);
    }

    @Override//查询指定用户的借还记录
    // 多文件查询（user.dat dvd.dat record.dat） 并不推荐这么做
    public List<Record2> queryRecordByUname(String uname) {
        UserDao userDao = new UserDaoImpl(); // 耦合了，这就是我们不推荐的原因。建议正式项目中，拿到Biz层去实现
        DVDDao dvdDao = new DVDDaoImpl();

        // 通过用户名，查询它的所有租赁记录
        int uid = 0;
        for (User u : userDao.queryAllUsers()) {
            if(u.getUname().equals(uname)){
                uid = u.getId();
                break;
            }
        }

        // 根据用户ID，搜索记录文件
        List<Record> rList = queryAllRecords();
        List<Record> newRecordList = new ArrayList<>();
        for (Record r : rList) {
            if(r.getUid() == uid){
                newRecordList.add(r);
            }
        }

        // 通过记录里的did，搜索dvd.dat，获取DVD的名字
        List<Record2> record2List = new ArrayList<>();
        for (Record r : newRecordList) {
            int did = r.getDid();
            DVD dvd = dvdDao.queryDVDById(did);
            String dname = dvd.getDname();
            record2List.add(new Record2(uname,dname,r.getLendTime(),r.getReturnTime()));
        }

        return record2List;
    }

    @Override//查询指定DVD的借还记录
    // dname --> uname,lendTime,returnTime
    public List<Record2> queryRecordByDname(String dname) {
        /**
         * dname --> DVDDao --> DVD --> did
         * did --> RecordDao --> List<Record>
         * Record --> Record2
         * 1) 每个Record --> UserDao --> User --> uname
         * 2) 每个Record --> getLendTime() --> lendTime
         * 3) 每个Record --> getReturnTime() --> returnTime
         * new Record2(uname,dname,lentTime,returnTime)
         */
        UserDao userDao = new UserDaoImpl(); // 耦合了，这就是我们不推荐的原因。建议正式项目中，拿到Biz层去实现
        DVDDao dvdDao = new DVDDaoImpl();

        // 通过用户名，查询它的所有租赁记录
        int did = 0;
        for (DVD d : dvdDao.queryDVDs()) {
            if(d.getDname().equals(dname)){
                did = d.getId();
                break;
            }
        }

        // 根据DVD的ID，搜索记录文件
        List<Record> rList = queryAllRecords();
        List<Record> newRecordList = new ArrayList<>();
        for (Record r : rList) {
            if(r.getDid() == did){
                newRecordList.add(r);
            }
        }

        // 通过记录里的uid，搜索dvd.dat，获取DVD的名字
        List<Record2> record2List = new ArrayList<>();
        for (Record r : newRecordList) {
            int uid = r.getUid();
            List<User> uList = userDao.queryAllUsers();
            String uname = "";
            for (User user : uList) {
               if (user.getId()==uid){
                   uname = user.getUname();
               }
            }
            record2List.add(new Record2(uname,dname,r.getLendTime(),r.getReturnTime()));
        }

        return record2List;
    }

    @Override//查询用户的归还记录（已归还，未归还）
    public List<Record2> queryUserRecordByReturnTime(boolean flag, String returnTime) {
        UserDao userDao = new UserDaoImpl(); // 耦合了，这就是我们不推荐的原因。建议正式项目中，拿到Biz层去实现
        DVDDao dvdDao = new DVDDaoImpl();
        List<Record2> record2List = new ArrayList<>();
        List<Record> rList = queryAllRecords();
        List<Record> newRecordList = new ArrayList<>();
        int did = 0;
        if (flag){
            List<DVD> dvdList = dvdDao.queryDVDByStatus(1);
            for (DVD dvd : dvdList) {
                did = dvd.getId();
                for (Record r : rList) {
                    if(r.getDid() == did){
                        newRecordList.add(r);
                    }
                }
                String dname = dvd.getDname();
                for (Record r : newRecordList) {
                    int uid = r.getUid();
                    List<User> uList = userDao.queryAllUsers();
                    String uname = "";
                    for (User user : uList) {
                        if (user.getId()==uid){
                            uname = user.getUname();
                        }
                    }
                    record2List.add(new Record2(uname,dname,r.getLendTime(),r.getReturnTime()));
                }
            }
        }
        return record2List;
    }
}