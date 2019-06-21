package com.iotek.dao.impl;

import com.iotek.dao.RoomDao;
import com.iotek.entity.Room;

import java.io.File;
import java.util.List;

public class RoomDaoImpl extends BaseDaoImpl<Room> implements RoomDao {
    private File roomFile = new File("file/room.dat");


    @Override
    public boolean addRoom(Room room) {
        List<Room> rList = read(roomFile);

        for (Room r : rList) {
            if (r.getRoomId() == room.getRoomId()
            && r.getBuildId() == room.getBuildId()){
                return false;
            }
        }

        rList.add(room);
        return write(rList,roomFile);
    }

    @Override
    public boolean delRoom(int roomId) {
        List<Room> rList = read(roomFile);
        for (int i = 0; i < rList.size(); i++) {
            Room r = rList.get(i);
            if(r.getRoomId() == roomId){
                rList.remove(i);
                return write(rList,roomFile);
            }
        }
        return false;
    }

    @Override
    public boolean updateRoom(Room room) {
        List<Room> rList = read(roomFile);
        for (int i = 0; i < rList.size(); i++) {
            Room r = rList.get(i);
            if(r.getRoomId() == room.getRoomId()){
                rList.set(i,room);
                return write(rList,roomFile);
            }
        }
        return false;
    }

    @Override
    public Room queryRoomById(int roomId) {
        List<Room> rList = read(roomFile);
        for (int i = 0; i < rList.size(); i++) {
            Room r = rList.get(i);
            if (r.getRoomId()==roomId){
                return r;
            }
        }
        return null;
    }

    @Override
    public List<Room> queryAllRooms() {
        return read(roomFile);
    }
}
