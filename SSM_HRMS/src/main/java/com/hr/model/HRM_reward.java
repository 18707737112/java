package com.hr.model;

import java.io.Serializable;
import java.sql.DatabaseMetaData;
import java.sql.Date;

//奖惩表
public class HRM_reward implements Serializable {
    private int r_id;//ID
    private int e_id;//员工ID
    private Date r_date;//时间
    private String r_reason;//原因
    private int r_money;//金额

    public HRM_reward() {
    }

    public HRM_reward(int e_id, Date r_date, String r_reason, int r_money) {
        this.e_id = e_id;
        this.r_date = r_date;
        this.r_reason = r_reason;
        this.r_money = r_money;
    }

    public HRM_reward(int r_id, int e_id, Date r_date, String r_reason, int r_money) {
        this.r_id = r_id;
        this.e_id = e_id;
        this.r_date = r_date;
        this.r_reason = r_reason;
        this.r_money = r_money;
    }

    public int getR_id() {
        return r_id;
    }

    public void setR_id(int r_id) {
        this.r_id = r_id;
    }

    public int getE_id() {
        return e_id;
    }

    public void setE_id(int e_id) {
        this.e_id = e_id;
    }

    public Date getR_date() {
        return r_date;
    }

    public void setR_date(Date r_date) {
        this.r_date = r_date;
    }

    public String getR_reason() {
        return r_reason;
    }

    public void setR_reason(String r_reason) {
        this.r_reason = r_reason;
    }

    public int getR_money() {
        return r_money;
    }

    public void setR_money(int r_money) {
        this.r_money = r_money;
    }

    @Override
    public String toString() {
        return "HRM_reward{" +
                "r_id=" + r_id +
                ", e_id=" + e_id +
                ", r_date=" + r_date +
                ", r_reason='" + r_reason + '\'' +
                ", r_money=" + r_money +
                '}';
    }
}
