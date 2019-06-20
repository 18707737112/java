package com.hr.service;

import com.hr.dao.CustomerMapper;
import com.hr.model.HRM_customer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Resource
    public CustomerMapper customerMapper;

    public CustomerMapper ligon(HRM_customer customer) {
        return (CustomerMapper) customerMapper.findUser(customer);
    }
}
