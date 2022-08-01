package com.webbanquanao.service;

import com.webbanquanao.model.ProductEntity;
import com.webbanquanao.model.SkuEntity;

import java.util.List;

public interface SkuService {
    void insert(SkuEntity skuEntity);

    void edit(SkuEntity skuEntity);

    void delete(int id);
    SkuEntity get(int id);
    List<SkuEntity> getAll();
    boolean checkExistOption(int pro_id,int color_id, int size_id);
    List<SkuEntity> searchByProduct(int pro_id);

    int getSkuId(int p_id, int color_id, int size_id);

    int getMaxQuantity(int p_id, int color_id, int size_id);
}
