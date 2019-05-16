package com.hr.model;

import java.io.Serializable;

//职位表
public class HRM_position implements Serializable {
    private int pos_id;//职位ID
    private int dep_id;//部门ID
    private int e_id;//员工ID
    private String pos_name;//职位名称

    public HRM_position() {
    }

    public HRM_position(int dep_id, int e_id, String pos_name) {
        this.dep_id = dep_id;
        this.e_id = e_id;
        this.pos_name = pos_name;
    }

    public HRM_position(int pos_id, int dep_id, int e_id, String pos_name) {
        this.pos_id = pos_id;
        this.dep_id = dep_id;
        this.e_id = e_id;
        this.pos_name = pos_name;
    }

    public int getPos_id() {
        return pos_id;
    }

    public void setPos_id(int pos_id) {
        this.pos_id = pos_id;
    }

    public int getDep_id() {
        return dep_id;
    }

    public void setDep_id(int dep_id) {
        this.dep_id = dep_id;
    }

    public int getE_id() {
        return e_id;
    }

    public void setE_id(int e_id) {
        this.e_id = e_id;
    }

    public String getPos_name() {
        return pos_name;
    }

    public void setPos_name(String pos_name) {
        this.pos_name = pos_name;
    }

    @Override
    public String toString() {
        return "HRM_position{" +
                "pos_id=" + pos_id +
                ", dep_id=" + dep_id +
                ", e_id=" + e_id +
                ", pos_name='" + pos_name + '\'' +
                '}';
    }
}
