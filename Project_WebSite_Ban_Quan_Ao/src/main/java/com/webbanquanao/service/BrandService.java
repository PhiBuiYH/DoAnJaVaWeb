package com.webbanquanao.service;

import com.webbanquanao.model.BrandEntity;
import com.webbanquanao.model.CategoryEntity;
import com.webbanquanao.model.ProductEntity;
import com.webbanquanao.model.UserEntity;

import java.util.List;

public interface BrandService {
    void insert(BrandEntity brandEntity);
    void edit(BrandEntity brandEntity);
    void delete(int brand_id);
    List<BrandEntity> getAll();
    BrandEntity get(int brand_id);
}
