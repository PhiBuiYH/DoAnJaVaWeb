package com.webbanquanao.dao;

import com.webbanquanao.model.CustomerEntity;

import java.util.List;

public interface CustomerDao {
    void insert(CustomerEntity customerEntity);

    void edit(CustomerEntity customerEntity);

    void detele(int id);

    int getCustomerId(int u_id);

    CustomerEntity getCustomer(int id);

    int getNewIDCustomer();
}
