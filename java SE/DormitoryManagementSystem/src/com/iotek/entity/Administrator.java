package com.iotek.entity;

import java.io.Serializable;

public class Administrator implements Serializable {
    private int administratorId;
    private String administratorName;
    private String administratorPass;
    private String administratorKey;//密钥

    public Administrator() {
    }

    public Administrator(String administratorName, String administratorPass) {
        this.administratorName = administratorName;
        this.administratorPass = administratorPass;
    }

    public Administrator(String administratorName, String administratorPass, String administratorKey) {
        this.administratorName = administratorName;
        this.administratorPass = administratorPass;
        this.administratorKey = administratorKey;
    }

    public Administrator(int administratorId, String administratorName, String administratorPass, String administratorKey) {
        this.administratorId = administratorId;
        this.administratorName = administratorName;
        this.administratorPass = administratorPass;
        this.administratorKey = administratorKey;
    }

    public int getAdministratorId() {
        return administratorId;
    }

    public void setAdministratorId(int administratorId) {
        this.administratorId = administratorId;
    }

    public String getAdministratorName() {
        return administratorName;
    }

    public void setAdministratorName(String administratorName) {
        this.administratorName = administratorName;
    }

    public String getAdministratorPass() {
        return administratorPass;
    }

    public void setAdministratorPass(String administratorPass) {
        this.administratorPass = administratorPass;
    }

    public String getAdministratorKey() {
        return administratorKey;
    }

    public void setAdministratorKey(String administratorKey) {
        this.administratorKey = administratorKey;
    }

    @Override
    public String toString() {
        return "管理员编号：" + administratorId +" "+
                "管理员账号：" + administratorName +" "+
                "管理员密码：" + administratorPass +" "+
                "管理员密钥：" + administratorKey;
    }
}
