package com.iotek.dao;

import com.iotek.dao.impl.RoomDaoImpl;
import com.iotek.entity.Room;
import org.junit.Test;

import java.util.List;

public class RoomDaoTest {
    private RoomDao roomDao = new RoomDaoImpl();

    @Test
    public void findAll(){
        List<Room> list = roomDao.queryAllRooms();

        for (Room room : list) {
            System.out.println(room);
        }
    }

    @Test
    public void add(){
        Room room = new Room(1,2,6);

        roomDao.addRoom(room);
        findAll();
    }

    @Test
    public void del(){
        roomDao.delRoom(2);
        findAll();
    }

    @Test
    public void up(){
        Room room = new Room(1,2,2);

        roomDao.updateRoom(room);
        findAll();
    }

    @Test
    public void findId(){
        Room r = roomDao.queryRoomById(1,2);

        System.out.println(r);
    }
}
