package com.hr.model;

import java.io.Serializable;
import java.util.Date;

//招聘表
public class HRM_recruit implements Serializable {
    private int rct_id;//ID
    private int pos_id;//职位ID
    private String rct_title;//主题
    private String rct_introducation;//职位描述
    private Date rct_publish_time;//发布时间
    private String rct_address;//地址
    private int rct_salary;//薪资
    private int e_id;//联系人ID
    private int rct_is_draft;//是否为草稿
    private int rct_is_publish;//是否发布

    public HRM_recruit() {
    }

    public HRM_recruit(int pos_id, String rct_title, String rct_introducation, Date rct_publish_time, String rct_address, int rct_salary, int e_id, int rct_is_draft, int rct_is_publish) {
        this.pos_id = pos_id;
        this.rct_title = rct_title;
        this.rct_introducation = rct_introducation;
        this.rct_publish_time = rct_publish_time;
        this.rct_address = rct_address;
        this.rct_salary = rct_salary;
        this.e_id = e_id;
        this.rct_is_draft = rct_is_draft;
        this.rct_is_publish = rct_is_publish;
    }

    public HRM_recruit(int rct_id, int pos_id, String rct_title, String rct_introducation, Date rct_publish_time, String rct_address, int rct_salary, int e_id, int rct_is_draft, int rct_is_publish) {
        this.rct_id = rct_id;
        this.pos_id = pos_id;
        this.rct_title = rct_title;
        this.rct_introducation = rct_introducation;
        this.rct_publish_time = rct_publish_time;
        this.rct_address = rct_address;
        this.rct_salary = rct_salary;
        this.e_id = e_id;
        this.rct_is_draft = rct_is_draft;
        this.rct_is_publish = rct_is_publish;
    }

    public int getRct_id() {
        return rct_id;
    }

    public void setRct_id(int rct_id) {
        this.rct_id = rct_id;
    }

    public int getPos_id() {
        return pos_id;
    }

    public void setPos_id(int pos_id) {
        this.pos_id = pos_id;
    }

    public String getRct_title() {
        return rct_title;
    }

    public void setRct_title(String rct_title) {
        this.rct_title = rct_title;
    }

    public String getRct_introducation() {
        return rct_introducation;
    }

    public void setRct_introducation(String rct_introducation) {
        this.rct_introducation = rct_introducation;
    }

    public Date getRct_publish_time() {
        return rct_publish_time;
    }

    public void setRct_publish_time(Date rct_publish_time) {
        this.rct_publish_time = rct_publish_time;
    }

    public String getRct_address() {
        return rct_address;
    }

    public void setRct_address(String rct_address) {
        this.rct_address = rct_address;
    }

    public int getRct_salary() {
        return rct_salary;
    }

    public void setRct_salary(int rct_salary) {
        this.rct_salary = rct_salary;
    }

    public int getE_id() {
        return e_id;
    }

    public void setE_id(int e_id) {
        this.e_id = e_id;
    }

    public int getRct_is_draft() {
        return rct_is_draft;
    }

    public void setRct_is_draft(int rct_is_draft) {
        this.rct_is_draft = rct_is_draft;
    }

    public int getRct_is_publish() {
        return rct_is_publish;
    }

    public void setRct_is_publish(int rct_is_publish) {
        this.rct_is_publish = rct_is_publish;
    }

    @Override
    public String toString() {
        return "HRM_recruit{" +
                "rct_id=" + rct_id +
                ", pos_id=" + pos_id +
                ", rct_title='" + rct_title + '\'' +
                ", rct_introducation='" + rct_introducation + '\'' +
                ", rct_publish_time=" + rct_publish_time +
                ", rct_address='" + rct_address + '\'' +
                ", rct_salary=" + rct_salary +
                ", e_id=" + e_id +
                ", rct_is_draft=" + rct_is_draft +
                ", rct_is_publish=" + rct_is_publish +
                '}';
    }
}
