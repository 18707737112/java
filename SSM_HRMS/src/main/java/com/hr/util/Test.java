package com.hr.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Test {
    public static void main(String[] args) {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE",
                    "hrms","hrms");
            if (connection!=null){
                System.out.println("连接成功");
            }else {
                System.out.println("连接失败");
            }
        } catch (ClassNotFoundException e) {
            System.out.println("驱动加载出错");
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
