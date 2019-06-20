package com.iotek.登录注册.com.lanying.dao.impl;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BaseDao<T> {
    // 通用读文件
    public List<T> read(File file){
        if(file == null || !file.exists()){
            throw new IllegalArgumentException("read入参不合法");
        }
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        List<T> list = new ArrayList<>();
        try {
            fis = new FileInputStream(file);
            ois = new ObjectInputStream(fis);
            list = (List<T>) ois.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return list;

    }

    // 通用写方法
    public boolean write(File file, List<T> list){
        if(file == null || file.isDirectory() || list == null){
            throw new IllegalArgumentException("write入参不合法");
        }

        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            fos = new FileOutputStream(file);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(oos != null){
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }
}
