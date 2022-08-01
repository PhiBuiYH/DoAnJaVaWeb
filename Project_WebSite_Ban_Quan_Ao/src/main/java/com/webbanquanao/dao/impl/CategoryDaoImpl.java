package com.webbanquanao.dao.impl;

import com.webbanquanao.dao.CategoryDao;
import com.webbanquanao.dao.HibernateConnection.HibernateUtil;
import com.webbanquanao.model.CategoryEntity;

import javax.persistence.*;
import java.util.List;

public class CategoryDaoImpl implements CategoryDao {
    @Override
    public void insert(CategoryEntity category) {
        EntityManager em = HibernateUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();

        try{
            trans.begin();
            em.persist(category);
            trans.commit();
        }catch (Exception ex){
            trans.rollback();
        }
        finally {
            em.close();
        }
    }

    @Override
    public void edit(CategoryEntity category) {
        EntityManager em = HibernateUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();

        try{
            trans.begin();
            em.merge(category);
            trans.commit();
        }catch (Exception ex){
            trans.rollback();
        }
        finally {
            em.close();
        }
    }

    @Override
    public void detele(int cate_id) {
        EntityManager em = HibernateUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();

        try{
            CategoryEntity categoryEntity = em.find(CategoryEntity.class, cate_id);
            trans.begin();
            em.remove(em.merge(categoryEntity));
            trans.commit();
        }catch (Exception ex){
            trans.rollback();
        }
        finally {
            em.close();
        }
    }

    @Override
    public CategoryEntity get(int cate_id)
    {
        EntityManager em = HibernateUtil.getEmFactory().createEntityManager();
        try{
            CategoryEntity categoryEntity = em.find(CategoryEntity.class, cate_id);
            return categoryEntity;
        }
        finally {
            em.close();
        }
    }

    @Override
    public CategoryEntity getName(String cate_name)
    {
        EntityManager em = HibernateUtil.getEmFactory().createEntityManager();
        String qString = "SELECT c FROM CategoryEntity c "+
                "WHERE c.cateName = :cate_name";
        TypedQuery<CategoryEntity> q = em.createQuery(qString, CategoryEntity.class);
        q.setParameter("cate_name",cate_name);
        try{
            CategoryEntity categoryEntity = q.getSingleResult();
            return categoryEntity;
        }
        catch (NoResultException e){
            return null;
        }
        finally {
            em.close();
        }
    }

    @Override
    public List<CategoryEntity> getAll(){
        EntityManager em = HibernateUtil.getEmFactory().createEntityManager();
        String qString = "FROM CategoryEntity";
        TypedQuery<CategoryEntity> q = em.createQuery(qString,CategoryEntity.class);
        List<CategoryEntity> categoryEntities;
        try{
            categoryEntities = q.getResultList();
            if(categoryEntities == null || categoryEntities.isEmpty())
                categoryEntities = null;
        }finally {
            em.close();
        }
        return categoryEntities;
    }

    @Override
    public List<CategoryEntity> search(String keyword){
        EntityManager em = HibernateUtil.getEmFactory().createEntityManager();
        String qString = "SELECT c FROM CategoryEntity c "+
                "WHERE c.cateName LIKE CONCAT('%',:keyword,'%')";
        TypedQuery<CategoryEntity> q = em.createQuery(qString, CategoryEntity.class);
        q.setParameter("keyword",keyword);

        List<CategoryEntity> categoryEntities;
        try{
            categoryEntities=q.getResultList();
            return categoryEntities;
        }
        catch (NoResultException e){
            return null;
        }
        finally {
            em.close();
        }
    }
}
