package com.iotek.dao.impl;

import com.iotek.dao.AdministratorDao;
import com.iotek.entity.Administrator;
import com.iotek.entity.Student;

import java.io.File;
import java.util.List;
import java.util.Scanner;

public class AdministratorDaoImpl extends BaseDaoImpl<Administrator> implements AdministratorDao {
    private File administratorFile = new File("file/administrator.dat");
    private int count = 0;

    @Override
    public boolean addAdministrator(Administrator administrator) {
        List<Administrator> aList = read(administratorFile);
        if(aList.size() == 0){
            administrator.setAdministratorId(1);
        }else{
            int newId = aList.get(aList.size()-1).getAdministratorId()+1;
            administrator.setAdministratorId(newId);
        }
        aList.add(administrator);

        return write(aList,administratorFile);
    }

    @Override
    public boolean delAdministrator(int administratorId) {
        List<Administrator> aList = read(administratorFile);
        for (int i = 0; i < aList.size(); i++) {
            Administrator a = aList.get(i);
            if(a.getAdministratorId() == administratorId){
                aList.remove(i);
                return write(aList,administratorFile);
            }
        }
        return false;
    }

    @Override
    public boolean updateAdministrator(Administrator administrator) {
        List<Administrator> aList = read(administratorFile);
        for (int i = 0; i < aList.size(); i++) {
            Administrator a = aList.get(i);
            if(a.getAdministratorId() == administrator.getAdministratorId()){
                aList.set(i,administrator);
                return write(aList,administratorFile);
            }
        }
        return false;
    }

    @Override
    public Administrator queryAdministratorById(int administratorId) {
        List<Administrator> aList = read(administratorFile);
        for (int i = 0; i < aList.size(); i++) {
            Administrator a = aList.get(i);
            if (a.getAdministratorId()==administratorId){
                return a;
            }
        }
        return null;
    }

    @Override
    public Administrator queryAdministratorByNameAndPassword(String name, String password) {
        List<Administrator> aList = read(administratorFile);
        for (Administrator a : aList) {
            // 找到了用户名和密码都匹配的对象
            if(a.getAdministratorName().equals(name)){
                if(a.getAdministratorPass().equals(password)){
                    return a;
                }else {
                    count++;
                    if (count==3) {
                        System.err.println("密码错误"+count+"次，请尽快联系校方负责人！");
                        //System.exit(0);
                        return null;
                    }
                    try {
                        throw new Exception("密码错误"+count+",请重新输入！");
                    } catch (Exception e) {
                        System.err.println("密码错误"+count+",请重新输入！");
                    }
                    Scanner scanner = new Scanner(System.in);
                    String p = scanner.next();
                    return queryAdministratorByNameAndPassword(name,p);
                }
            }
        }
        System.err.println("该管理员不存在！");
        return null;
    }

    @Override
    public List<Administrator> queryAllAdministrators() {
        return read(administratorFile);
    }
}
