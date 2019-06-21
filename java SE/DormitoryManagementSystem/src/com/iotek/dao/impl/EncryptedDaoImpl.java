package com.iotek.dao.impl;

import com.iotek.dao.EncryptedDao;
import com.iotek.entity.Encrypted;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class EncryptedDaoImpl extends BaseDaoImpl<Encrypted> implements EncryptedDao {
    private File encryptedFile = new File("file/encrypted.dat");


    @Override
    public boolean addEncrypted(Encrypted encrypted) {
        List<Encrypted> eList = read(encryptedFile);
        eList.add(encrypted);
        return write(eList,encryptedFile);
    }

    @Override
    public boolean delEncrypted(int studentId) {
        System.out.println("暂时不需要，还没写！");
        return false;
    }

    @Override
    public boolean updateEncryptedCard(Encrypted studentCard) {
        System.out.println("暂时不需要，还没写！");
        return false;
    }

    @Override
    public List<Encrypted> queryEncryptedById(int studentId) {
        List<Encrypted> eList = read(encryptedFile);
        List<Encrypted> newList = new ArrayList<>();
        for (int i = 0; i < eList.size(); i++) {
            Encrypted e = eList.get(i);
            if (e.getId()==studentId){
                newList.add(e);
            }
        }
        return newList;
    }

    @Override
    public List<Encrypted> queryAllEncrypteds() {
        return read(encryptedFile);
    }
}
