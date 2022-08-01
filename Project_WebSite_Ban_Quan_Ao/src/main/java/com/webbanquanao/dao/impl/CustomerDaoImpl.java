package com.webbanquanao.dao.impl;

import com.webbanquanao.dao.CustomerDao;
import com.webbanquanao.dao.HibernateConnection.HibernateUtil;
import com.webbanquanao.model.CustomerEntity;
import org.hibernate.Session;
import org.hibernate.type.IntegerType;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class CustomerDaoImpl implements CustomerDao {
    @Override
    public void insert(CustomerEntity customerEntity) {
        EntityManager em = HibernateUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();

        try{
            trans.begin();
            em.persist(customerEntity);
            trans.commit();
        }catch (Exception ex){
            trans.rollback();
        }
        finally {
            em.close();
        }
    }

    @Override
    public void edit(CustomerEntity customerEntity) {
        EntityManager em = HibernateUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();

        try{
            trans.begin();
            em.merge(customerEntity);
            trans.commit();
        }catch (Exception ex){
            trans.rollback();
        }
        finally {
            em.close();
        }
    }

    @Override
    public void detele(int id) {
        EntityManager em = HibernateUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();

        try {
            CustomerEntity customerEntity = em.find(CustomerEntity.class, id);
            trans.begin();
            em.remove(em.merge(customerEntity));
            trans.commit();
        } catch (Exception ex) {
            trans.rollback();
        } finally {
            em.close();
        }
    }

    @Override
    public int getCustomerId(int u_id){
        EntityManager em = HibernateUtil.getEmFactory().createEntityManager();
        String qString = "Select c_id from cart where u_id = " + u_id;
        Session getSession = em.unwrap(Session.class);
        getSession.getTransaction().begin();
        int c_id=0;

        try{
            List<Integer> listId;
            listId = getSession.createSQLQuery(qString).getResultList();
            for(Integer id:listId){
                if(id != null){
                    c_id=id;
                    break;
                }
            }
            getSession.close();
        }
        finally {
            em.close();
        }
        return c_id;
    }

    @Override
    public CustomerEntity getCustomer(int id){
        EntityManager em = HibernateUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        CustomerEntity customerEntity = new CustomerEntity();
        try {
            customerEntity = em.find(CustomerEntity.class, id);
        } catch (Exception ex) {
            trans.rollback();
        } finally {
            em.close();
        }
        return customerEntity;
    }

    @Override
    public int getNewIDCustomer(){
        EntityManager em = HibernateUtil.getEmFactory().createEntityManager();
        Session getSession = em.unwrap(Session.class);
        getSession.getTransaction().begin();
        int id = (int) getSession.createSQLQuery("SELECT id FROM customer ORDER BY id DESC LIMIT 1").addScalar("id",new IntegerType()).uniqueResult();
        try{

            getSession.getTransaction().commit();
            getSession.close();
        }
        finally {
            em.close();
        }
        return id;
    }
}
