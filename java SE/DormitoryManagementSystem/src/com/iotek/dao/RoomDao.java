package com.iotek.dao;

import com.iotek.entity.Room;

import java.util.List;

public interface RoomDao {
    boolean addRoom(Room room);  //添加
    boolean delRoom(int roomId);  //删除
    boolean updateRoom(Room room);  //修改
    Room queryRoomById(int roomId);   //指定宿舍号查找
    List<Room> queryAllRooms();  //读取文件（可以用来遍历信息）

}
