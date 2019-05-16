package com.hr.model;

import java.io.Serializable;
import java.util.Date;

public class HRM_cv implements Serializable {
    private int cv_id;//ID
    private int c_id;//游客ID
    private String cv_name;//姓名
    private char cv_gender;//性别
    private Date cv_birth;//出生年月
    private String cv_address;//住址
    private String cv_school;//学校名称
    private String cv_education;//学历
    private String cv_major;//所学专业
    private Date cv_enroll_date;//入学时间
    private Date cv_graduation_date;//毕业时间
    private String cv_salary;//期望薪资
    private String cv_exprience;//经历

    public HRM_cv() {
    }

    public HRM_cv(int c_id, String cv_name, char cv_gender, Date cv_birth, String cv_address, String cv_school, String cv_education, String cv_major, Date cv_enroll_date, Date cv_graduation_date, String cv_salary, String cv_exprience) {
        this.c_id = c_id;
        this.cv_name = cv_name;
        this.cv_gender = cv_gender;
        this.cv_birth = cv_birth;
        this.cv_address = cv_address;
        this.cv_school = cv_school;
        this.cv_education = cv_education;
        this.cv_major = cv_major;
        this.cv_enroll_date = cv_enroll_date;
        this.cv_graduation_date = cv_graduation_date;
        this.cv_salary = cv_salary;
        this.cv_exprience = cv_exprience;
    }

    public HRM_cv(int cv_id, int c_id, String cv_name, char cv_gender, Date cv_birth, String cv_address, String cv_school, String cv_education, String cv_major, Date cv_enroll_date, Date cv_graduation_date, String cv_salary, String cv_exprience) {
        this.cv_id = cv_id;
        this.c_id = c_id;
        this.cv_name = cv_name;
        this.cv_gender = cv_gender;
        this.cv_birth = cv_birth;
        this.cv_address = cv_address;
        this.cv_school = cv_school;
        this.cv_education = cv_education;
        this.cv_major = cv_major;
        this.cv_enroll_date = cv_enroll_date;
        this.cv_graduation_date = cv_graduation_date;
        this.cv_salary = cv_salary;
        this.cv_exprience = cv_exprience;
    }

    public int getCv_id() {
        return cv_id;
    }

    public void setCv_id(int cv_id) {
        this.cv_id = cv_id;
    }

    public int getC_id() {
        return c_id;
    }

    public void setC_id(int c_id) {
        this.c_id = c_id;
    }

    public String getCv_name() {
        return cv_name;
    }

    public void setCv_name(String cv_name) {
        this.cv_name = cv_name;
    }

    public char getCv_gender() {
        return cv_gender;
    }

    public void setCv_gender(char cv_gender) {
        this.cv_gender = cv_gender;
    }

    public Date getCv_birth() {
        return cv_birth;
    }

    public void setCv_birth(Date cv_birth) {
        this.cv_birth = cv_birth;
    }

    public String getCv_address() {
        return cv_address;
    }

    public void setCv_address(String cv_address) {
        this.cv_address = cv_address;
    }

    public String getCv_school() {
        return cv_school;
    }

    public void setCv_school(String cv_school) {
        this.cv_school = cv_school;
    }

    public String getCv_education() {
        return cv_education;
    }

    public void setCv_education(String cv_education) {
        this.cv_education = cv_education;
    }

    public String getCv_major() {
        return cv_major;
    }

    public void setCv_major(String cv_major) {
        this.cv_major = cv_major;
    }

    public Date getCv_enroll_date() {
        return cv_enroll_date;
    }

    public void setCv_enroll_date(Date cv_enroll_date) {
        this.cv_enroll_date = cv_enroll_date;
    }

    public Date getCv_graduation_date() {
        return cv_graduation_date;
    }

    public void setCv_graduation_date(Date cv_graduation_date) {
        this.cv_graduation_date = cv_graduation_date;
    }

    public String getCv_salary() {
        return cv_salary;
    }

    public void setCv_salary(String cv_salary) {
        this.cv_salary = cv_salary;
    }

    public String getCv_exprience() {
        return cv_exprience;
    }

    public void setCv_exprience(String cv_exprience) {
        this.cv_exprience = cv_exprience;
    }

    @Override
    public String toString() {
        return "HRM_cv{" +
                "cv_id=" + cv_id +
                ", c_id=" + c_id +
                ", cv_name='" + cv_name + '\'' +
                ", cv_gender=" + cv_gender +
                ", cv_birth=" + cv_birth +
                ", cv_address='" + cv_address + '\'' +
                ", cv_school='" + cv_school + '\'' +
                ", cv_education='" + cv_education + '\'' +
                ", cv_major='" + cv_major + '\'' +
                ", cv_enroll_date=" + cv_enroll_date +
                ", cv_graduation_date=" + cv_graduation_date +
                ", cv_salary='" + cv_salary + '\'' +
                ", cv_exprience='" + cv_exprience + '\'' +
                '}';
    }
}
