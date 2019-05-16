package com.hr.service;

import com.hr.dao.CustomerDao;
import com.hr.model.HRM_customer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Resource
    private CustomerDao customerDao;
    public CustomerDao ligon(HRM_customer customer) {
        return null;
    }
}
