package com.iotek.biz.impl;

import com.iotek.biz.AdministratorBiz;
import com.iotek.dao.*;
import com.iotek.dao.impl.*;
import com.iotek.entity.*;

import java.util.List;

public class AdministratorBizImpl implements AdministratorBiz {
    private AdministratorDao administratorDao = new AdministratorDaoImpl();
    private StudentDao studentDao = new StudentDaoImpl();
    private CheckDao checkDao = new CheckDaoImpl();
    private DormitoryDao dormitoryDao = new DormitoryDaoImpl();
    private RoomDao roomDao = new RoomDaoImpl();
    private BedDao bedDao = new BedDaoImpl();

    @Override
    public boolean register(Administrator administrator) {
        // 先看一下用户名是否存在
        List<Administrator> aList = administratorDao.queryAllAdministrators();
        for (Administrator a : aList) {
            if(a.getAdministratorName().equals(administrator.getAdministratorName())){
                // 已存在
                System.err.println("用户名已存在，是否要登录？");
                return false;
            }
        }
        // 如果用户名不存在，则说明该用户名可用
        return administratorDao.addAdministrator(administrator);
    }

    @Override
    public Administrator login(Administrator administrator) {
        Administrator a = administratorDao.queryAdministratorByNameAndPassword(administrator.getAdministratorName(),administrator.getAdministratorPass());
        return a;
    }

    @Override
    public boolean addStudent(Student student) {
        return  studentDao.addStudent(student);
        //return false;
    }

    @Override
    public void lookAllStudents() {
        List<Student> sList = studentDao.queryAllStudents();
        List<Bed> bList = bedDao.queryAllBeds();
        List<Check> cList = checkDao.queryAllCheckS();
        for (int i = 0; i < sList.size(); i++) {
            Student s = sList.get(i);
            System.out.println("-------------------------------------------------------");
            System.out.print("学号："+s.getStudentId()+" ");
            System.out.print("姓名："+s.getStudentName()+" ");
            System.out.println("性别："+s.getSex()+" ");
            System.out.print("迁入/迁出：");
            Check c = checkDao.queryCheckByIdS(s.getStudentId());

            if (c.getType() == 1){
                System.out.println("😊已经迁入了~~~~~~");
            }else {
                System.out.println("亲，还未迁入哟~~~");
            }

            System.out.print("宿舍：");
            Bed bed = bedDao.queryBedById(s.getStudentId());

            if (bed == null){
                System.out.println("😭，还没有。。。。。。");
            }else {
                System.out.println(bed.getBuildId()+"楼"+bed.getRoomId()+"号"+bed.getBedId()+"床");
            }

            System.out.println("-------------------------------------------------------");
        }
    }

    @Override
    public void updateStudent(Student student) {
        boolean flag = studentDao.updateStudent(student);
        if (!flag){
            System.out.println("修改失败！");
        }else {
            System.out.println("修改成功！");
        }
    }

    @Override
    public void lookAllBed() {
        List<Bed> list = bedDao.queryAllBeds();

        for (Bed bed : list) {
            System.out.println(bed);
        }
    }

    @Override
    public void updateStudentId(Student student, int id) {
        boolean flag = studentDao.updateStudentId(student,id);
        if (!flag){
            System.out.println("修改失败！");
        }else {
            System.out.println("修改成功！");
        }
    }

    @Override
    public void findCheck() {
        List<Check> list = checkDao.queryAllCheckS();
        for (Check check : list) {
            System.out.println(check);
        }
    }

    @Override
    public boolean addCheck(int studentId) {
        boolean flag =  checkDao.addCheck(new Check(studentId));
        if (!flag){
            System.out.println("迁入失败！");
            return false;
        }
        System.out.println("迁入成功！");
        return true;

    }

    @Override
    public boolean updateCheck(Check check) {
        boolean flag =  checkDao.updateCheck(check);
        if (!flag){
            System.out.println("迁出失败！");
            return false;
        }
        System.out.println("迁出成功！");
        return true;
    }

    @Override
    public boolean addDormitory(Dormitory dormitory) {
        return dormitoryDao.addDormitory(dormitory);
    }

    @Override
    public boolean updateDormitory(Dormitory dormitory) {
        return dormitoryDao.updateDormitoryCard(dormitory);
    }

    @Override
    public boolean addRoom(Room room) {
        List<Dormitory> list = dormitoryDao.queryAllDormitorys();
        for (Dormitory dormitory : list) {
            if (dormitory.getBuildId() == room.getBuildId()){
                return roomDao.addRoom(room);
            }
        }
        return false;
    }

    @Override
    public boolean updateRoom(Room room) {
        List<Dormitory> list = dormitoryDao.queryAllDormitorys();
        for (Dormitory dormitory : list) {
            if (dormitory.getBuildId() == room.getBuildId()){
                return roomDao.updateRoom(room);
            }
        }
        return false;
    }

    @Override
    public boolean addBed(Bed bed,String sex) {
        List<Room> list = roomDao.queryAllRooms();

        for (Room room : list) {
            Check c = checkDao.queryCheckByIdS(bed.getStudentId());
            Dormitory d = dormitoryDao.queryDormitoryById(room.getBuildId());
            /*if (room.getBuildId() == bed.getBuildId()
              && room.getRoomId() == bed.getRoomId()){
                if (c == null && c.getType() == 1){
                    return bedDao.addBed(bed);
                }
            }*/
            if (c != null && c.getType() == 1){
                if (room.getBuildId() == bed.getBuildId()
                && room.getRoomId() == bed.getRoomId()){
                    if(!d.getPersonSex().equals(sex)){
                        System.out.println("😊亲，注意性别~~~~");
                        System.out.println("入住失败！");
                        return false;
                    }
                    return bedDao.addBed(bed);
                }
            }
        }

        System.out.println("没有迁入，入住失败！");
        return false;
    }

    @Override
    public boolean updateBed(Bed bed,String sex) {
        List<Room> list = roomDao.queryAllRooms();

        for (Room room : list) {
            Check c = checkDao.queryCheckByIdS(bed.getStudentId());
            Dormitory d = dormitoryDao.queryDormitoryById(room.getBuildId());
            /*if (room.getBuildId() == bed.getBuildId()
            && room.getRoomId() == bed.getRoomId()){
                if (c == null && c.getType() == 1){
                    return bedDao.updateBed(bed);
                }
            }*/
            if (c != null && c.getType() == 1){
                if (room.getBuildId() == bed.getBuildId()
                && room.getRoomId() == bed.getRoomId()){
                    if(!d.getPersonSex().equals(sex)){
                        System.out.println("😊亲，注意性别~~~~");
                        System.out.println("调换失败！");
                        return false;
                    }
                    return bedDao.updateBed(bed);
                }
            }

        }
        System.out.println("没有迁入，换宿舍失败！");
        return false;
    }
}
