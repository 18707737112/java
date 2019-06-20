package com.iotek.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 客户端Client --> 服务端Server
 */
public class ServerUtil {
    public static void getServer() throws IOException {
        // 1. 创建ServerSocket对象
        ServerSocket serverSocket = new ServerSocket(8888); // 0~65535 , 建议2000以内不要用
        System.out.println("服务器已就绪...");
        // 2. 等待客户端的连接
        Socket socket = serverSocket.accept();
        System.out.println(socket.getInetAddress()+"已连接...");

        // 3. 通过Socket对象读写数据
        BufferedReader br = null;

        try {
            InputStream is = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            br = new BufferedReader(isr);

            String line = null;
            while(! (line = br.readLine()).equalsIgnoreCase("bye")){
                System.out.println(socket.getInetAddress().getHostName()+": " + line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4. 资源释放
            if(br != null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}