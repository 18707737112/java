package com.iotek.dao.impl;

import com.iotek.dao.CheckDao;
import com.iotek.entity.Check;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
//迁入/迁出
public class CheckDaoImpl extends BaseDaoImpl<Check> implements CheckDao {
    private File checkFile = new File("file/check.dat");

    @Override
    public boolean addCheck(Check check) {
        List<Check> cList = read(checkFile);

        if(cList.size() == 0){
            check.setCheckId(1);
        }else{
            int newId = cList.get(cList.size()-1).getCheckId()+1;
            check.setCheckId(newId);
        }

        cList.add(check);
        return write(cList,checkFile);
    }

    @Override
    public boolean delCheck(int checkId) {
        List<Check> list = read(checkFile);
        for (int i = 0; i < list.size(); i++) {
            Check c = list.get(i);
            if(c.getCheckId() == checkId){
                list.remove(i);
                return write(list,checkFile);
            }
        }
        return false;
    }

    @Override
    public boolean updateCheck(Check check) {
        List<Check> cList = read(checkFile);
        for (int i = 0; i < cList.size(); i++) {
            Check c = cList.get(i);
            if(c.getCheckId() == check.getCheckId()){
                cList.set(i,check);
                return write(cList,checkFile);
            }
        }
        return false;
    }

    @Override
    public Check queryCheckById(int checkId) {
        List<Check> cList = read(checkFile);
        for (int i = 0; i < cList.size(); i++) {
            Check c = cList.get(i);
            if (c.getCheckId()==checkId){
                return c;
            }
        }
        return null;
    }

    @Override
    public List<Check> queryCheckByIdS(int studentId) {
        List<Check> cList = read(checkFile);
        List<Check> newList = new ArrayList<>();
        //Check check = new Check();
        for (int i = 0; i < cList.size(); i++) {
            Check c = cList.get(i);
            if (c.getStudentId()==studentId){
                newList.add(c);
            }
        }
        return newList;
    }

    @Override
    public List<Check> queryAllCheckS() {
        //System.out.println("暂时不需要，还没写！");
        return read(checkFile);
    }
}
