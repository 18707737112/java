package com.hr.model;

import java.io.Serializable;
import java.util.Date;

//部门表
public class HRM_department implements Serializable {
    private int dep_id;//ID
    private String dep_name;//部门名称
    private Date dep_date;//建立时间

    public HRM_department() {
    }

    public HRM_department(String dep_name, Date dep_date) {
        this.dep_name = dep_name;
        this.dep_date = dep_date;
    }

    public HRM_department(int dep_id, String dep_name, Date dep_date) {
        this.dep_id = dep_id;
        this.dep_name = dep_name;
        this.dep_date = dep_date;
    }

    public int getDep_id() {
        return dep_id;
    }

    public void setDep_id(int dep_id) {
        this.dep_id = dep_id;
    }

    public String getDep_name() {
        return dep_name;
    }

    public void setDep_name(String dep_name) {
        this.dep_name = dep_name;
    }

    public Date getDep_date() {
        return dep_date;
    }

    public void setDep_date(Date dep_date) {
        this.dep_date = dep_date;
    }

    @Override
    public String toString() {
        return "HRM_department{" +
                "dep_id=" + dep_id +
                ", dep_name='" + dep_name + '\'' +
                ", dep_date=" + dep_date +
                '}';
    }
}
