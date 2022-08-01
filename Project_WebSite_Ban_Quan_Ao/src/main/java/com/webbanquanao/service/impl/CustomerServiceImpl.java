package com.webbanquanao.service.impl;

import com.webbanquanao.dao.CustomerDao;
import com.webbanquanao.dao.impl.CustomerDaoImpl;
import com.webbanquanao.model.CustomerEntity;
import com.webbanquanao.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {
    CustomerDao customerDao = new CustomerDaoImpl();

    @Override
    public void insert(CustomerEntity customerEntity) { customerDao.insert(customerEntity); }

    @Override
    public void edit(CustomerEntity customerEntity) { customerDao.edit(customerEntity); }

    @Override
    public void detele(int id) { customerDao.detele(id); }

    @Override
    public int getCustomerId(int u_id) { return customerDao.getCustomerId(u_id); }

    @Override
    public CustomerEntity getCustomer(int id) { return customerDao.getCustomer(id); }

    @Override
    public int getNewIDCustomer() { return customerDao.getNewIDCustomer(); }
}
