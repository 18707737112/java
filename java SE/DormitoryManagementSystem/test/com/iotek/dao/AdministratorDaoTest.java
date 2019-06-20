package com.iotek.dao;

import com.iotek.dao.impl.AdministratorDaoImpl;
import com.iotek.entity.Administrator;
import org.junit.Test;

import java.util.List;

public class AdministratorDaoTest {
    private AdministratorDao administratorDao = new AdministratorDaoImpl();

    @Test
    public void findAll(){
        List<Administrator> list = administratorDao.queryAllAdministrators();
        for (Administrator administrator : list) {
            System.out.println(administrator);
        }
    }

    @Test
    public void add(){
        administratorDao.addAdministrator(new Administrator("不知道","妖","1"));
        administratorDao.addAdministrator(new Administrator("aaa","aaa","aaa"));
        findAll();
    }

    @Test
    public void del(){
        administratorDao.delAdministrator(3);
        findAll();
    }

    @Test
    public void update(){
        administratorDao.updateAdministrator(new Administrator(2,"a","a","a"));
        findAll();
    }

    @Test
    public void findId(){
        System.out.println(administratorDao.queryAdministratorById(2));
    }

    @Test
    public void login(){
        Administrator a = administratorDao.queryAdministratorByNameAndPassword("aaa","aaa");
        System.out.println(a);
    }

}


