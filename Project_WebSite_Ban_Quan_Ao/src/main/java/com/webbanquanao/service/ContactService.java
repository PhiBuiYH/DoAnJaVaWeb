package com.webbanquanao.service;

import com.webbanquanao.model.ContactEntity;

import java.util.List;


public interface ContactService {
    void insert(ContactEntity contact);
    public List<ContactEntity> getAll();
    void delete(int id);
    void updateAction(int id, int value);
}
