package com.hr.model;

import java.io.Serializable;
import java.util.Date;

//培训表
public class HRM_training implements Serializable {
    private int t_id;//ID
    private String t_title;//主题
    private String t_context;//具体内容
    private int e_id;//员工ID
    private Date t_start_time;//开始时间
    private Date t_end_time;//结束时间
    private String t_address;//地点
    private int t_is_publish;//是否为发布

    public HRM_training() {
    }

    public HRM_training(String t_title, String t_context, int e_id, Date t_start_time, Date t_end_time, String t_address, int t_is_publish) {
        this.t_title = t_title;
        this.t_context = t_context;
        this.e_id = e_id;
        this.t_start_time = t_start_time;
        this.t_end_time = t_end_time;
        this.t_address = t_address;
        this.t_is_publish = t_is_publish;
    }

    public HRM_training(int t_id, String t_title, String t_context, int e_id, Date t_start_time, Date t_end_time, String t_address, int t_is_publish) {
        this.t_id = t_id;
        this.t_title = t_title;
        this.t_context = t_context;
        this.e_id = e_id;
        this.t_start_time = t_start_time;
        this.t_end_time = t_end_time;
        this.t_address = t_address;
        this.t_is_publish = t_is_publish;
    }

    public int getT_id() {
        return t_id;
    }

    public void setT_id(int t_id) {
        this.t_id = t_id;
    }

    public String getT_title() {
        return t_title;
    }

    public void setT_title(String t_title) {
        this.t_title = t_title;
    }

    public String getT_context() {
        return t_context;
    }

    public void setT_context(String t_context) {
        this.t_context = t_context;
    }

    public int getE_id() {
        return e_id;
    }

    public void setE_id(int e_id) {
        this.e_id = e_id;
    }

    public Date getT_start_time() {
        return t_start_time;
    }

    public void setT_start_time(Date t_start_time) {
        this.t_start_time = t_start_time;
    }

    public Date getT_end_time() {
        return t_end_time;
    }

    public void setT_end_time(Date t_end_time) {
        this.t_end_time = t_end_time;
    }

    public String getT_address() {
        return t_address;
    }

    public void setT_address(String t_address) {
        this.t_address = t_address;
    }

    public int getT_is_publish() {
        return t_is_publish;
    }

    public void setT_is_publish(int t_is_publish) {
        this.t_is_publish = t_is_publish;
    }

    @Override
    public String toString() {
        return "HRM_training{" +
                "t_id=" + t_id +
                ", t_title='" + t_title + '\'' +
                ", t_context='" + t_context + '\'' +
                ", e_id=" + e_id +
                ", t_start_time=" + t_start_time +
                ", t_end_time=" + t_end_time +
                ", t_address='" + t_address + '\'' +
                ", t_is_publish=" + t_is_publish +
                '}';
    }
}
