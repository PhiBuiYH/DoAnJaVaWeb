package com.webbanquanao.dao.impl;

import com.webbanquanao.dao.ColorDao;
import com.webbanquanao.dao.HibernateConnection.HibernateUtil;
import com.webbanquanao.model.ColorEntity;
import com.webbanquanao.model.SizeEntity;
import org.hibernate.Session;
import org.hibernate.type.IntegerType;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class ColorDaoImpl implements ColorDao {
    @Override
    public void insert(ColorEntity colorEntities){
        EntityManager em = HibernateUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();

        try{
            trans.begin();
            em.persist(colorEntities);
            trans.commit();
        }catch (Exception ex){
            trans.rollback();
        }
        finally {
            em.close();
        }

    }

    @Override
    public void edit(ColorEntity colorEntities){
        EntityManager em = HibernateUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();

        try{
            trans.begin();
            em.merge(colorEntities);
            trans.commit();
        }catch (Exception ex){
            trans.rollback();
        }
        finally {
            em.close();
        }
    }

    @Override
    public void delete(int id)
    {
        EntityManager em = HibernateUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();

        try{
            ColorEntity colorEntities = em.find(ColorEntity.class, id);
            trans.begin();
            em.remove(em.merge(colorEntities));
            trans.commit();
        }catch (Exception ex){
            trans.rollback();
        }
        finally {
            em.close();
        }
    }
    @Override
    public ColorEntity get(int id){
        EntityManager em = HibernateUtil.getEmFactory().createEntityManager();
        try{
            ColorEntity colorEntities = em.find(ColorEntity.class, id);
            return colorEntities;
        }
        finally {
            em.close();
        }
    }
    @Override
    public List<ColorEntity> getAll() {
        EntityManager em = HibernateUtil.getEmFactory().createEntityManager();
        String qString = "FROM ColorEntity ";
        TypedQuery<ColorEntity> q = em.createQuery(qString,ColorEntity.class);
        List<ColorEntity> colorEntities;
        try{
            colorEntities = q.getResultList();
            if(colorEntities == null || colorEntities.isEmpty())
                colorEntities = null;
        }finally {
            em.close();
        }
        return colorEntities;
    }

    @Override
    public int getColorId(String color_name){
        EntityManager em = HibernateUtil.getEmFactory().createEntityManager();
        String qString = "Select color_id From color Where color_name = '" + color_name + "'";
        Session getSession = em.unwrap(Session.class);
        getSession.getTransaction().begin();
        int id;

        try{
            id = (int) getSession.createSQLQuery(qString).addScalar("color_id",new IntegerType()).uniqueResult();
            getSession.close();
        }
        finally {
            em.close();
        }
        return id;
    }
}
