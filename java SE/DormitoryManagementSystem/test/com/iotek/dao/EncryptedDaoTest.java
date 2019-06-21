package com.iotek.dao;

import com.iotek.dao.impl.EncryptedDaoImpl;
import com.iotek.entity.Encrypted;
import org.junit.Test;

import java.util.List;

public class EncryptedDaoTest {
    private EncryptedDao encryptedDao = new EncryptedDaoImpl();

    @Test
    public void findAll(){
        List<Encrypted> list = encryptedDao.queryAllEncrypteds();
        for (Encrypted encrypted : list) {
            System.out.println(encrypted);
        }
    }
}
