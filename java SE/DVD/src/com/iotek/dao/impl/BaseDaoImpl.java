package com.iotek.dao.impl;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseDaoImpl<T> {
    protected List<T> read(File file) {
        if(file == null ){
            throw new IllegalArgumentException("入参不合法：File对象为null");
        }

        FileInputStream fis = null;
        ObjectInputStream ois = null;

        List<T> list = new ArrayList<>(); // 为什么这么写？可好用了
        try {
            fis = new FileInputStream(file);
            ois = new ObjectInputStream(fis);

            list = (List<T>) ois.readObject();
        } catch(EOFException e){
            System.out.println("文件中没有数据");
        } catch (FileNotFoundException e) {

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
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

    protected boolean write(List<T> list, File file) {
        if(list == null || file == null || file.isDirectory()){
            throw new IllegalArgumentException("write方法入参不合法！");
        }

        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            fos = new FileOutputStream(file);
            oos = new ObjectOutputStream(fos);

            oos.writeObject(list);
            return true; // 如果没有抛出异常，则写入成功
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
