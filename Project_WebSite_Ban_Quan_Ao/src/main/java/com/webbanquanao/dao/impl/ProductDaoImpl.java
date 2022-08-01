package com.webbanquanao.dao.impl;

import clojure.lang.Obj;
import com.webbanquanao.dao.HibernateConnection.HibernateUtil;
import com.webbanquanao.dao.ProductDao;
import com.webbanquanao.model.CategoryEntity;
import com.webbanquanao.model.ProductEntity;
import com.webbanquanao.model.SkuEntity;
import com.webbanquanao.service.CategoryService;
import com.webbanquanao.service.impl.CategoryServiceImpl;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ProductDaoImpl implements ProductDao {

    @Override
    public void insert(ProductEntity product){
        EntityManager em = HibernateUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();

        try{
            trans.begin();
            em.persist(product);
            trans.commit();
        }catch (Exception ex){
            trans.rollback();
        }
        finally {
            em.close();
        }

    }

    @Override
    public void edit(ProductEntity product){
        EntityManager em = HibernateUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();

        try{
            trans.begin();
            em.merge(product);
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
            ProductEntity productEntity = em.find(ProductEntity.class, id);
            trans.begin();
            em.remove(em.merge(productEntity));
            trans.commit();
        }catch (Exception ex){
            trans.rollback();
        }
        finally {
            em.close();
        }
    }

    @Override
    public ProductEntity get(int id){
        EntityManager em = HibernateUtil.getEmFactory().createEntityManager();
        try{
            ProductEntity productEntity = em.find(ProductEntity.class, id);
            return productEntity;
        }
        finally {
            em.close();
        }
    }

    @Override
    public List<ProductEntity> getAll(){
        EntityManager em = HibernateUtil.getEmFactory().createEntityManager();
        String qString = "FROM ProductEntity ";
        TypedQuery<ProductEntity> q = em.createQuery(qString,ProductEntity.class);
        List<ProductEntity> productList = new ArrayList<ProductEntity>();
        try{
            productList = q.getResultList();
            if(productList == null || productList.isEmpty())
                productList= null;
        }finally {
            em.close();
        }
        return productList;
    }
    @Override
    public List<ProductEntity> getByPage(int offset, int limit){
        EntityManager em = HibernateUtil.getEmFactory().createEntityManager();
        String qString = "FROM ProductEntity ";
        TypedQuery<ProductEntity> q = em.createQuery(qString,ProductEntity.class);
        q.setFirstResult(offset);
        q.setMaxResults(limit);
        List<ProductEntity> productList = new ArrayList<ProductEntity>();
        try{
            productList = q.getResultList();
            if(productList == null || productList.isEmpty())
                productList= null;
        }finally {
            em.close();
        }
        return productList;
    }
    @Override
    public List<ProductEntity> getByPageAndPrice(double priceStart,double priceEnd, int offset, int limit){
        EntityManager em = HibernateUtil.getEmFactory().createEntityManager();
        String qString = "FROM ProductEntity P where P.price >= :priceStart and P.price <= : priceEnd";
        TypedQuery<ProductEntity> q = em.createQuery(qString,ProductEntity.class);
        q.setParameter("priceStart",priceStart);
        q.setParameter("priceEnd",priceEnd);
        q.setFirstResult(offset);
        q.setMaxResults(limit);
        List<ProductEntity> productList = new ArrayList<ProductEntity>();
        try{
            productList = q.getResultList();
            if(productList == null || productList.isEmpty())
                productList= null;
        }finally {
            em.close();
        }
        return productList;
    }
    @Override
    public List<ProductEntity> searchByPageAndCategory(String cate_name,int offset, int limit){
        EntityManager em = HibernateUtil.getEmFactory().createEntityManager();
        String qString = "FROM ProductEntity P Where P.categoryEntity.cateName =:cate_name ";
        TypedQuery<ProductEntity> q = em.createQuery(qString,ProductEntity.class);
        q.setParameter("cate_name",cate_name);
        q.setFirstResult(offset);
        q.setMaxResults(limit);
        List<ProductEntity> productList = new ArrayList<ProductEntity>();
        try{
            productList = q.getResultList();
            if(productList == null || productList.isEmpty())
                productList= null;
        }finally {
            em.close();
        }
        return productList;

    }
    @Override
    public List<ProductEntity> search(String keyword)
    {

        return null;
    }

    @Override
    public List<ProductEntity> searchByCategory(String cate_name){
        EntityManager em = HibernateUtil.getEmFactory().createEntityManager();
        String qString = "FROM ProductEntity P Where P.categoryEntity.cateName =:cate_name ";
        TypedQuery<ProductEntity> q = em.createQuery(qString,ProductEntity.class);
        q.setParameter("cate_name",cate_name);
        List<ProductEntity> productList = new ArrayList<ProductEntity>();
        try{
            productList = q.getResultList();
            if(productList == null || productList.isEmpty())
                productList= null;
        }finally {
            em.close();
        }
        return productList;

    }

    @Override
    public List<ProductEntity> searchByName(String productName) {
        EntityManager em = HibernateUtil.getEmFactory().createEntityManager();
        String qString = "FROM ProductEntity P where P.name like :productName";
        TypedQuery<ProductEntity> q = em.createQuery(qString,ProductEntity.class);
        q.setParameter("productName","%"+productName+"%");
        List<ProductEntity> productList = new ArrayList<ProductEntity>();
        try{
            productList = q.getResultList();
            if(productList == null || productList.isEmpty())
                productList= null;
        }finally {
            em.close();
        }
        return productList;
    }
    public List<ProductEntity> searchByPrice(double priceStart,double priceEnd){
        EntityManager em = HibernateUtil.getEmFactory().createEntityManager();
        String qString = "FROM ProductEntity P where P.price >= :priceStart and P.price <= : priceEnd";
        TypedQuery<ProductEntity> q = em.createQuery(qString,ProductEntity.class);
        q.setParameter("priceStart",priceStart);
        q.setParameter("priceEnd",priceEnd);
        List<ProductEntity> productList = new ArrayList<ProductEntity>();
        try{
            productList = q.getResultList();
            if(productList == null || productList.isEmpty())
                productList= null;
        }finally {
            em.close();
        }
        return productList;
    }

    public Object[] searchByProperties(List<Object> value, int offset, int limit)
    {

        EntityManager em = HibernateUtil.getEmFactory().createEntityManager();

        String qString = "select Sku.productEntity FROM SkuEntity Sku Where 1=1 ";
        if (value.get(0) !=null) {
            qString+=" and Sku.productEntity.categoryEntity.cateId =:cate_id ";
        }
        if (value.get(1) !=null) {
            qString += " and Sku.colorEntity.colorId =:color_id ";
        }
        if(value.get(2)!=null) {
            qString+= " and Sku.sizeEntity.sizeId =:size_id ";
        }
        qString += "and Sku.productEntity.price >=:start_price and Sku.productEntity.price <=:end_price ";
        if(value.get(5)!=null) {
            qString += "and Sku.productEntity.brandEntity.brandId =:brand_id ";
        }
        qString += "GROUP BY Sku.productEntity";
//        Query q = em.createQuery(qString);

        TypedQuery<ProductEntity> q = em.createQuery(qString,ProductEntity.class);


        if (value.get(0) !=null) {
            q.setParameter("cate_id",(int) value.get(0));
        }
        if (value.get(1) !=null) {
            q.setParameter("color_id",(int) value.get(1));
        }
        if(value.get(2)!=null) {
            q.setParameter("size_id",(int) value.get(2));
        }
        if(value.get(3)!=null && value.get(4) !=null ) {
            q.setParameter("start_price",1.0*(int) value.get(3));
            q.setParameter("end_price",1.0*(int) value.get(4));
        }
        if (value.get(5)!=null) {
            q.setParameter("brand_id",value.get(5));
        }

        List<ProductEntity> productListCount = new ArrayList<ProductEntity>();
        try{
            productListCount = q.getResultList();
            if(productListCount == null || productListCount.isEmpty())
                productListCount= null;
        }finally {
//            em.close();
        }

        int totalProduct=(productListCount==null?0:productListCount.size());

        q.setFirstResult(offset);
        q.setMaxResults(limit);

        List<ProductEntity> productList = new ArrayList<ProductEntity>();
        try{
            productList = q.getResultList();
            if(productList == null || productList.isEmpty())
                productList= null;
        }finally {
            em.close();
        }

        Object[] result ={productList,totalProduct};

        return result ;
    }
}
