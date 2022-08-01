package com.webbanquanao.service.impl;

import com.webbanquanao.dao.ContactDAO;
import com.webbanquanao.dao.HibernateConnection.HibernateUtil;
import com.webbanquanao.dao.impl.ContactDaoImpl;
import com.webbanquanao.model.ContactEntity;
import com.webbanquanao.service.ContactService;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class ContactServiceImpl implements ContactService {
    ContactDAO contactDAO = new ContactDaoImpl();
    @Override
    public void insert(ContactEntity contact) {
        contactDAO.insert(contact);
    }

    @Override
    public List<ContactEntity> getAll() {
        return contactDAO.getAll();
    }

    @Override
    public void delete(int id) {
        contactDAO.delete(id);
    }
    public void updateAction(int id, int value) {
        ContactEntity contact = contactDAO.getById(id);
        contact.setStatus(value);
        contactDAO.updateAction(contact);
    }

}
