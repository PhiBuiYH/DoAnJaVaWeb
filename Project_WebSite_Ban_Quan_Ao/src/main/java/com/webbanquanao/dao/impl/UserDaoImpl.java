package com.webbanquanao.dao.impl;

import com.webbanquanao.dao.UserDao;
import com.webbanquanao.dao.HibernateConnection.HibernateUtil;
import com.webbanquanao.model.UserEntity;

import javax.persistence.*;
import java.util.List;

public class UserDaoImpl  implements UserDao{
    @Override
    public void insert(UserEntity user) {
        EntityManager em = HibernateUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();

        try{
            trans.begin();
            em.persist(user);
            trans.commit();
        }catch (Exception ex){
            trans.rollback();
        }
        finally {
            em.close();
        }
    }

    @Override
    public void edit(UserEntity user) {

        EntityManager em = HibernateUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();

        try{
            trans.begin();
            em.merge(user);
            trans.commit();
        }catch (Exception ex){
            trans.rollback();
        }
        finally {
            em.close();
        }
    }

    @Override
    public void delete(int id) {

        EntityManager em = HibernateUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();

        try{
            UserEntity userEntity = em.find(UserEntity.class, id);
            trans.begin();
            em.remove(em.merge(userEntity));
            trans.commit();
        }catch (Exception ex){
            trans.rollback();
        }
        finally {
            em.close();
        }
    }

    @Override
    public UserEntity get(String username) {
        EntityManager em = HibernateUtil.getEmFactory().createEntityManager();
        try{
            UserEntity userEntity = em.find(UserEntity.class, username);
            return userEntity;
        }
        finally {
            em.close();
        }
    }

    @Override
    public UserEntity get(int id) {

        EntityManager em = HibernateUtil.getEmFactory().createEntityManager();
        try{
            UserEntity userEntity = em.find(UserEntity.class, id);
            return userEntity;
        }
        finally {
            em.close();
        }
    }

    @Override
    public List<UserEntity> getAll() {
        EntityManager em = HibernateUtil.getEmFactory().createEntityManager();
        String qString = "FROM UserEntity ";
        TypedQuery<UserEntity> q = em.createQuery(qString,UserEntity.class);
        List<UserEntity> userEntities;
        try{
            userEntities = q.getResultList();
            if(userEntities == null || userEntities.isEmpty())
                userEntities = null;
        }finally {
            em.close();
        }
        return userEntities;
    }

    @Override
    public UserEntity search(String keyword) {
        EntityManager em = HibernateUtil.getEmFactory().createEntityManager();
        String qString = "SELECT u FROM UserEntity u "+
                "WHERE u.email LIKE CONCAT('%',:keyword,'%')";
        TypedQuery<UserEntity> q = em.createQuery(qString,UserEntity.class);
        q.setParameter("keyword",keyword);

        UserEntity userEntities;
        try{
            userEntities=q.getSingleResult();
            return userEntities;
        }
        catch (NoResultException e){
            return null;
        }
        finally {
            em.close();
        }
    }

    @Override
    public boolean checkExistEmail(String email) {

        EntityManager em = HibernateUtil.getEmFactory().createEntityManager();
        String qString = "SELECT u FROM UserEntity u "+
                "WHERE u.email=:keyword";
        TypedQuery<UserEntity> q = em.createQuery(qString,UserEntity.class);
        q.setParameter("keyword",email);

        List<UserEntity> userEntities;
        try{
            userEntities=q.getResultList();

        }
        catch (NoResultException e){
            return  false;
        }
        finally {
            em.close();
        }
        if(userEntities.size()>0 &&userEntities!=null)
            return true;
        return false;
    }

    @Override
    public boolean checkExistUserName(String username) {
        EntityManager em = HibernateUtil.getEmFactory().createEntityManager();
        String qString = "SELECT u FROM UserEntity u "+
                "WHERE u.userName=:keyword";
        TypedQuery<UserEntity> q = em.createQuery(qString,UserEntity.class);
        q.setParameter("keyword",username);

        List<UserEntity> userEntities;
        try{
            userEntities=q.getResultList();

        }
        catch (NoResultException e){
            return  false;
        }
        finally {
            em.close();
        }
        if(userEntities.size()>0 &&userEntities!=null)
            return true;
        return false;
    }

    @Override
    public boolean checkExistAccount(String email, String password){
        EntityManager em = HibernateUtil.getEmFactory().createEntityManager();
        String qString = "SELECT u FROM UserEntity u "+
                "WHERE u.email=:keyemail and u.password=:keypass";
        TypedQuery<UserEntity> q = em.createQuery(qString,UserEntity.class);
        q.setParameter("keyemail",email);
        q.setParameter("keypass",password);
        List<UserEntity> userEntities;
        try{
            userEntities=q.getResultList();

        }
        catch (NoResultException e){
            return  false;
        }
        finally {
            em.close();
        }
        if(userEntities.size()>0 &&userEntities!=null)
            return true;
        return false;
    }

    @Override
    public UserEntity getUser(String email) {

        EntityManager em = HibernateUtil.getEmFactory().createEntityManager();
        String qString = "SELECT u FROM UserEntity u "+
                "WHERE u.email=:email";
        TypedQuery<UserEntity> q = em.createQuery(qString,UserEntity.class);
        q.setParameter("email",email);

        UserEntity userEntity;
        try{
            userEntity = q.getSingleResult();
        }
        catch (NoResultException e){
            return null;
        }
        finally {
            em.close();
        }
        return userEntity;
    }
}
