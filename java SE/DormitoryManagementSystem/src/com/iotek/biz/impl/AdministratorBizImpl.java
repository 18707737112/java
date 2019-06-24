package com.iotek.biz.impl;

import com.iotek.biz.AdministratorBiz;
import com.iotek.dao.*;
import com.iotek.dao.impl.*;
import com.iotek.entity.*;

import java.util.ArrayList;
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
        //List<Check> cList = checkDao.queryAllCheckS();
        for (int i = 0; i < sList.size(); i++) {
            Student s = sList.get(i);
            System.out.println("-------------------------------------------------------");
            System.out.print("学号："+s.getStudentId()+" ");
            System.out.print("姓名："+s.getStudentName()+" ");
            System.out.println("性别："+s.getSex()+" ");
            System.out.print("授权/迁出：");
            List<Check> cL = checkDao.queryCheckByIdS(s.getStudentId());
            Check c;
            if (cL == null || cL.size()==0){
                c = new Check(0,0,0);
            }else {
                c = cL.get(cL.size()-1);
            }


            if (c.getType() == 1){
                System.out.println("😊已经授权了~");
            }else{
                System.out.println("亲，还未授权哟~~~~~~~~~~~~~~~");
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
            System.out.println("授权失败！");
            return false;
        }
        System.out.println("授权成功！");
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
    public boolean addB(Bed bed) {
        List<Room> list = roomDao.queryAllRooms();

        for (Room room : list) {
            if (room.getBuildId() == bed.getBuildId()
            && room.getRoomId() == bed.getRoomId()){
                return bedDao.addBed(bed);
            }
        }

        return false;
    }

    @Override
    public boolean updateB(Bed bed) {
        List<Room> list = roomDao.queryAllRooms();

        for (Room room : list) {
            if (room.getBuildId() == bed.getBuildId()
            && room.getRoomId() == bed.getRoomId()){
                return bedDao.updateBed(bed);
            }

        }
        return false;
    }

    @Override
    public void findNullBed(Dormitory dormitory) {
        int number = dormitory.getRoomNum();
        //int[] arr = new int[number];
        List<Bed> list = bedDao.queryAllBeds();
        List<Room> roomList = roomDao.queryAllRooms();

        for (int i = 0; i < number; i++) {
            boolean flag = false;
            int seat = 0;
            for (Room room : roomList) {
                if (room.getBuildId() == dormitory.getBuildId()
                && room.getRoomId() == i+1){
                    flag = true;
                    seat = room.getBedNum();
                }
            }
            List<Bed> newList = new ArrayList<>();
            for (Bed bed : list) {
                if (bed.getBuildId() == dormitory.getBuildId() && bed.getRoomId() == i+1){
                    if (bed.getStudentId() == 0){
                        newList.add(bed);
                    }
                }
            }
            int lenght = newList.size();
            int a = i+1;
            if (lenght == 0){
                if (flag == true) {
                    System.out.println(a+"号宿舍已住满~~~~~~~~~~~~~~~~~~~~~~~");
                }else {
                    System.out.println(a+"号宿舍还没有安装床！！！！！！");
                }

            }else {
                System.out.println(a+"号宿舍("+seat+"人间)==>"+lenght+"个空床位");
            }
        }
    }

    @Override
    public void findNullBedArray(Room room) {
        List<Bed> list = bedDao.queryAllBeds();
        List<Room> roomList = roomDao.queryAllRooms();
        Room r = null;

        for (Room r2 : roomList) {
            if (r2.getBuildId() == room.getBuildId() && r2.getRoomId() == room.getRoomId()){
                r = r2;
            }
        }
        if (r == null){
            System.out.println("房间不存在~~~~~~~~~~~~~~~");
        }else {
            for (int i = 0; i < room.getBedNum(); i++) {
                int id = i+1;
                for (Bed bed : list) {
                    if (bed.getBuildId() == room.getBuildId()
                    && bed.getRoomId() == room.getRoomId()
                    && bed.getBedId() == id){
                        if (bed.getStudentId() == 0){
                            System.out.println(id+"号床==>空");
                        }else {
                            System.out.println(id+"号床==>✔");
                        }
                    }
                }
            }
        }

    }

    @Override
    public boolean addBed(Bed bed,String sex) {
        List<Room> list = roomDao.queryAllRooms();
        List<Check> cL = checkDao.queryCheckByIdS(bed.getStudentId());
        Check c;
        if (cL == null || cL.size()==0){
            c = new Check(0,0,0);
        }else {
            c = cL.get(cL.size()-1);
        }
        for (Room room : list) {
            /*List<Check> cList = checkDao.queryCheckByIdS(bed.getStudentId());
            Check c = cList.get(cList.size()-1);*/

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
                    return bedDao.updateBed(bed);
                }
            }
        }

        System.out.println("没有迁入，入住失败！");
        return false;
    }

    @Override
    public boolean updateBed(Bed bed,String sex) {
        List<Room> list = roomDao.queryAllRooms();
        List<Check> cL = checkDao.queryCheckByIdS(bed.getStudentId());
        Check c;
        if (cL == null || cL.size()==0){
            c = new Check(0,0,0);
        }else {
            c = cL.get(cL.size()-1);
        }
        for (Room room : list) {
            /*List<Check> cList = checkDao.queryCheckByIdS(bed.getStudentId());
            Check c = cList.get(cList.size()-1);*/
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
