package com.iotek.dao.impl;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BaseDaoImpl<T> {
    public boolean write(List<T> list, File file) {
        // 入参检查
        if(list == null || file == null || file.isDirectory()){
            throw new IllegalArgumentException("write方法入参不合法！");
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

    public List<T> read(File file) {
        // 入参检查
        if(file == null || file.isDirectory()){
            throw new IllegalArgumentException("read方法入参不合法！");
        }

        List<T> list = new ArrayList<>();

        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            fis = new FileInputStream(file);
            ois = new ObjectInputStream(fis);

            list = (List<T>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("首次使用，"+file.getName()+"文件尚未创建！");
        } catch (EOFException e) {
            System.out.println("首次使用，"+file.getName()+"文件内容为空！");
        } catch (IOException e) {
            //e.printStackTrace();
        } catch (ClassNotFoundException e) {
            //e.printStackTrace();
        } finally {
            if(ois != null){
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return list;

    }
}
