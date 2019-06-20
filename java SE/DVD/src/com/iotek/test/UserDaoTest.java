package com.iotek.test;

import com.iotek.dao.impl.UserDaoImpl;
import com.iotek.entity.User;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserDaoTest {
    private UserDaoImpl userDao = new UserDaoImpl();
    @Test
    public void testSaveUser(){
        boolean save = userDao.saveUser(new User("msy","123456",1));
        assertEquals(true,save);
    }

    @Test
    public void testQueryAllUsers(){
        for (User user : userDao.queryAllUsers()) {
            System.out.println(user);
        }
    }

    @Test
    public void testDelUser(){
        userDao.delUser(3);
    }
}
