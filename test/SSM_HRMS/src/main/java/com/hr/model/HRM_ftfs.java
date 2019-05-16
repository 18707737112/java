package com.hr.model;

import java.io.Serializable;
import java.util.Date;

//面试系统表
public class HRM_ftfs implements Serializable {
    private int f_id;//ID
    private int cv_id;//简历ID
    private int rct_id;//招聘ID
    private Date f_date;//面试时间
    private int f_is_read;//是否已读
    private int f_is_accept;//是否允许面试
    private int f_is_agree;//是否同意参加面试

    public HRM_ftfs() {
    }

    public HRM_ftfs(int cv_id, int rct_id, Date f_date, int f_is_read, int f_is_accept, int f_is_agree) {
        this.cv_id = cv_id;
        this.rct_id = rct_id;
        this.f_date = f_date;
        this.f_is_read = f_is_read;
        this.f_is_accept = f_is_accept;
        this.f_is_agree = f_is_agree;
    }

    public HRM_ftfs(int f_id, int cv_id, int rct_id, Date f_date, int f_is_read, int f_is_accept, int f_is_agree) {
        this.f_id = f_id;
        this.cv_id = cv_id;
        this.rct_id = rct_id;
        this.f_date = f_date;
        this.f_is_read = f_is_read;
        this.f_is_accept = f_is_accept;
        this.f_is_agree = f_is_agree;
    }

    public int getF_id() {
        return f_id;
    }

    public void setF_id(int f_id) {
        this.f_id = f_id;
    }

    public int getCv_id() {
        return cv_id;
    }

    public void setCv_id(int cv_id) {
        this.cv_id = cv_id;
    }

    public int getRct_id() {
        return rct_id;
    }

    public void setRct_id(int rct_id) {
        this.rct_id = rct_id;
    }

    public Date getF_date() {
        return f_date;
    }

    public void setF_date(Date f_date) {
        this.f_date = f_date;
    }

    public int getF_is_read() {
        return f_is_read;
    }

    public void setF_is_read(int f_is_read) {
        this.f_is_read = f_is_read;
    }

    public int getF_is_accept() {
        return f_is_accept;
    }

    public void setF_is_accept(int f_is_accept) {
        this.f_is_accept = f_is_accept;
    }

    public int getF_is_agree() {
        return f_is_agree;
    }

    public void setF_is_agree(int f_is_agree) {
        this.f_is_agree = f_is_agree;
    }

    @Override
    public String toString() {
        return "HRM_ftfs{" +
                "f_id=" + f_id +
                ", cv_id=" + cv_id +
                ", rct_id=" + rct_id +
                ", f_date=" + f_date +
                ", f_is_read=" + f_is_read +
                ", f_is_accept=" + f_is_accept +
                ", f_is_agree=" + f_is_agree +
                '}';
    }
}
