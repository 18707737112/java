package com.hr.model;

import java.io.Serializable;
import java.util.Date;

//薪资表
public class HRM_salary implements Serializable {
    private int s_id;//ID
    private int e_id;//员工ID
    private Date s_date;//结算日期
    private int s_performance;//绩效奖金
    private int s_extra;//加班费用
    private int s_reward;//奖惩费用
    private int s_s_insurance;//社保
    private int s_total;//总计
    private int s_is_trouble;//复议状态

    public HRM_salary() {
    }

    public HRM_salary(int e_id, Date s_date, int s_performance, int s_extra, int s_reward, int s_s_insurance, int s_total, int s_is_trouble) {
        this.e_id = e_id;
        this.s_date = s_date;
        this.s_performance = s_performance;
        this.s_extra = s_extra;
        this.s_reward = s_reward;
        this.s_s_insurance = s_s_insurance;
        this.s_total = s_total;
        this.s_is_trouble = s_is_trouble;
    }

    public HRM_salary(int s_id, int e_id, Date s_date, int s_performance, int s_extra, int s_reward, int s_s_insurance, int s_total, int s_is_trouble) {
        this.s_id = s_id;
        this.e_id = e_id;
        this.s_date = s_date;
        this.s_performance = s_performance;
        this.s_extra = s_extra;
        this.s_reward = s_reward;
        this.s_s_insurance = s_s_insurance;
        this.s_total = s_total;
        this.s_is_trouble = s_is_trouble;
    }

    public int getS_id() {
        return s_id;
    }

    public void setS_id(int s_id) {
        this.s_id = s_id;
    }

    public int getE_id() {
        return e_id;
    }

    public void setE_id(int e_id) {
        this.e_id = e_id;
    }

    public Date getS_date() {
        return s_date;
    }

    public void setS_date(Date s_date) {
        this.s_date = s_date;
    }

    public int getS_performance() {
        return s_performance;
    }

    public void setS_performance(int s_performance) {
        this.s_performance = s_performance;
    }

    public int getS_extra() {
        return s_extra;
    }

    public void setS_extra(int s_extra) {
        this.s_extra = s_extra;
    }

    public int getS_reward() {
        return s_reward;
    }

    public void setS_reward(int s_reward) {
        this.s_reward = s_reward;
    }

    public int getS_s_insurance() {
        return s_s_insurance;
    }

    public void setS_s_insurance(int s_s_insurance) {
        this.s_s_insurance = s_s_insurance;
    }

    public int getS_total() {
        return s_total;
    }

    public void setS_total(int s_total) {
        this.s_total = s_total;
    }

    public int getS_is_trouble() {
        return s_is_trouble;
    }

    public void setS_is_trouble(int s_is_trouble) {
        this.s_is_trouble = s_is_trouble;
    }

    @Override
    public String toString() {
        return "HRM_salary{" +
                "s_id=" + s_id +
                ", e_id=" + e_id +
                ", s_date=" + s_date +
                ", s_performance=" + s_performance +
                ", s_extra=" + s_extra +
                ", s_reward=" + s_reward +
                ", s_s_insurance=" + s_s_insurance +
                ", s_total=" + s_total +
                ", s_is_trouble=" + s_is_trouble +
                '}';
    }
}
