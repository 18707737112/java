package com.iotek.dao.impl;

import com.iotek.dao.CheckDao;
import com.iotek.entity.Check;

import java.util.List;

public class CheckDaoImpl extends BaseDaoImpl<Check> implements CheckDao {

    @Override
    public boolean addCheck(Check check) {
        return false;
    }

    @Override
    public boolean delCheck(int checkId) {
        return false;
    }

    @Override
    public boolean updateCheck(Check check) {
        return false;
    }

    @Override
    public Check queryCheckById(int checkId) {
        return null;
    }

    @Override
    public List<Check> queryCheckByIdS(int studentId) {
        return null;
    }

    @Override
    public List<Check> queryAllCheckS() {
        return null;
    }
}
