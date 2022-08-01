package com.webbanquanao.service;

import com.webbanquanao.model.CustomerEntity;

public interface CustomerService {
    void insert(CustomerEntity customerEntity);

    void edit(CustomerEntity customerEntity);

    void detele(int id);

    int getCustomerId(int u_id);

    CustomerEntity getCustomer(int id);

    int getNewIDCustomer();
}
