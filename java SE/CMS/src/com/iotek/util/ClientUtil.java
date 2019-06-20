package com.iotek.util;

import java.io.*;
import java.net.Socket;

public class ClientUtil {
    public static void getClient(File file) {
        File src = file;
        Socket socket = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        try {
            // 1. 创建Socket对象
            socket = new Socket("192.168.20.208",10086);

            // 2. 通过socket对象获取IO流
            FileInputStream fis = new FileInputStream(src);
            OutputStream os = socket.getOutputStream();

            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(os);

            int data = -1;
            while((data = bis.read()) != -1){
                bos.write(data);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            if(bos != null){
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(bis != null){
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

