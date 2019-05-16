package com.hr.dao;

import com.hr.model.HRM_customer;

import java.util.List;

public interface CustomerDao {
    boolean addUser(HRM_customer customer);
    List<HRM_customer> findUser(HRM_customer customer);
}
