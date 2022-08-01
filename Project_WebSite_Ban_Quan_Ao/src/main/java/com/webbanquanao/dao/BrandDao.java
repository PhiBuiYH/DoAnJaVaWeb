package com.webbanquanao.dao;

import com.webbanquanao.model.BrandEntity;
import com.webbanquanao.model.CategoryEntity;

import java.util.List;

public interface BrandDao {
    void insert(BrandEntity brandEntity);
    void edit(BrandEntity brandEntity);

    void detele(int brand_id);
    List<BrandEntity> getAll();
    BrandEntity get(int brand_id);
}
