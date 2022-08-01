package com.webbanquanao.dao;

import com.webbanquanao.model.ContactEntity;

import java.util.List;

public interface ContactDAO {
    void insert(ContactEntity contact);
    public List<ContactEntity> getAll();
    void delete(int id);
    void updateAction(ContactEntity contact);
    ContactEntity getById(int id);
}
