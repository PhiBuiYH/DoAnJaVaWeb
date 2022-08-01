package com.webbanquanao.dao.impl;

import com.webbanquanao.dao.HibernateConnection.HibernateUtil;
import com.webbanquanao.dao.SizeDao;
import com.webbanquanao.model.SizeEntity;
import com.webbanquanao.model.SkuEntity;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.type.IntegerType;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class SizeDaoImpl implements SizeDao {
    @Override
    public void insert(SizeEntity sizeEntity){
        EntityManager em = HibernateUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();

        try{
            trans.begin();
            em.persist(sizeEntity);
            trans.commit();
        }catch (Exception ex){
            trans.rollback();
        }
        finally {
            em.close();
        }

    }

    @Override
    public void edit(SizeEntity sizeEntity){
        EntityManager em = HibernateUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();

        try{
            trans.begin();
            em.merge(sizeEntity);
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
            SizeEntity skuEntity = em.find(SizeEntity.class, id);
            trans.begin();
            em.remove(em.merge(skuEntity));
            trans.commit();
        }catch (Exception ex){
            trans.rollback();
        }
        finally {
            em.close();
        }
    }
    @Override
    public SizeEntity get(int id){
        EntityManager em = HibernateUtil.getEmFactory().createEntityManager();
        try{
            SizeEntity sizeEntity = em.find(SizeEntity.class, id);
            return sizeEntity;
        }
        finally {
            em.close();
        }
    }
    @Override
    public List<SizeEntity> getAll() {
        EntityManager em = HibernateUtil.getEmFactory().createEntityManager();
        String qString = "FROM SizeEntity ";
        TypedQuery<SizeEntity> q = em.createQuery(qString,SizeEntity.class);
        List<SizeEntity> sizeEntities;
        try{
            sizeEntities = q.getResultList();
            if(sizeEntities == null || sizeEntities.isEmpty())
                sizeEntities = null;
        }finally {
            em.close();
        }
        return sizeEntities;
    }

    @Override
    public int getSizeId(String size_name){
        EntityManager em = HibernateUtil.getEmFactory().createEntityManager();
        String qString = "Select Size_id From size Where Size_name = '" + size_name + "'";
        Session getSession = em.unwrap(Session.class);
        getSession.getTransaction().begin();
        int id;

        try{
             id = (int) getSession.createSQLQuery(qString).addScalar("Size_id",new IntegerType()).uniqueResult();
            getSession.close();
        }
        finally {
            em.close();
        }
        return id;
    }
}
