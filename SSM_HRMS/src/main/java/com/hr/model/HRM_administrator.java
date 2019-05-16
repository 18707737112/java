package com.hr.model;

import java.io.Serializable;

//管理员
public class HRM_administrator implements Serializable {
    private int a_id;
    private String a_name;
    private String a_pass;

    public HRM_administrator() {
    }

    public HRM_administrator(String a_name, String a_pass) {
        this.a_name = a_name;
        this.a_pass = a_pass;
    }

    public HRM_administrator(int a_id, String a_name, String a_pass) {
        this.a_id = a_id;
        this.a_name = a_name;
        this.a_pass = a_pass;
    }

    public int getA_id() {
        return a_id;
    }

    public void setA_id(int a_id) {
        this.a_id = a_id;
    }

    public String getA_name() {
        return a_name;
    }

    public void setA_name(String a_name) {
        this.a_name = a_name;
    }

    public String getA_pass() {
        return a_pass;
    }

    public void setA_pass(String a_pass) {
        this.a_pass = a_pass;
    }

    @Override
    public String toString() {
        return "HRM_administrator{" +
                "a_id=" + a_id +
                ", a_name='" + a_name + '\'' +
                ", a_pass='" + a_pass + '\'' +
                '}';
    }
}
