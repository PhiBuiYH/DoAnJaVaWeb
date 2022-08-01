package com.webbanquanao.service;

import clojure.lang.Obj;
import com.webbanquanao.model.ProductEntity;

import java.util.List;
import java.util.Map;

public interface ProductService {
    void insert(ProductEntity product);

    void edit(ProductEntity product);

    void delete(int id);

    ProductEntity get(int id);

    List<ProductEntity> getAll();

    List<ProductEntity> search(String name);

    List<ProductEntity> searchByCategory(String cate_name);

    List<ProductEntity> searchByName(String productName);

    List<ProductEntity> searchByPrice(double priceStart,double priceEnd);

    List<ProductEntity> getByPage(int offset, int limit);

    List<ProductEntity> getByPageAndPrice(double priceStart,double priceEnd,int offset, int limit);

    List<ProductEntity> searchByPageAndCategory(String cate_name,int offset, int limit);

    public Object[] searchByProperties(List<Object> map,int offset, int limit);
}
