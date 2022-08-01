package com.webbanquanao.dao.impl;

import com.webbanquanao.dao.ContactDAO;
import com.webbanquanao.dao.HibernateConnection.HibernateUtil;
import com.webbanquanao.model.ContactEntity;

import com.webbanquanao.model.ProductEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class ContactDaoImpl implements ContactDAO {
    @Override
    public void insert(ContactEntity contact) {
        EntityManager em = HibernateUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();

        try{
            trans.begin();
            em.persist(contact);
            trans.commit();
        }catch (Exception ex){
            trans.rollback();
        }
        finally {
            em.close();
        }
    }
    @Override
    public List<ContactEntity> getAll(){
        EntityManager em = HibernateUtil.getEmFactory().createEntityManager();
        String qString = "FROM ContactEntity ";
        TypedQuery<ContactEntity> q = em.createQuery(qString,ContactEntity.class);
        List<ContactEntity> contactList = new ArrayList<ContactEntity>();
        try{
            contactList = q.getResultList();
            if(contactList == null || contactList.isEmpty())
                contactList= null;
        }finally {
            em.close();
        }
        return contactList;
    }


    @Override
    public void delete(int id)
    {
        EntityManager em = HibernateUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();

        try{
            ContactEntity contact = em.find(ContactEntity.class, id);
            trans.begin();
            em.remove(em.merge(contact));
            trans.commit();
        }catch (Exception ex){
            trans.rollback();
        }
        finally {
            em.close();
        }
    }

    @Override
    public void updateAction(ContactEntity contact) {
        EntityManager em = HibernateUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();

        try{
            trans.begin();
            em.merge(contact);
            trans.commit();
        }catch (Exception ex){
            trans.rollback();
        }
        finally {
            em.close();
        }
    }
    @Override
    public ContactEntity getById(int id){

        EntityManager em = HibernateUtil.getEmFactory().createEntityManager();
        try{
            ContactEntity contact = em.find(ContactEntity.class, id);
            return contact;
        }
        finally {
            em.close();
        }
        /*Transaction transaction = null;
        ContactEntity contact = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();

            contact = session.get(ContactEntity.class, id);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return contact;
        return null;*/
    }
}
