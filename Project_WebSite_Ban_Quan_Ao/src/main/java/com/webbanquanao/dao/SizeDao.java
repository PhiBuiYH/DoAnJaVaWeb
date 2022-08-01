package com.webbanquanao.dao;

import com.webbanquanao.model.SizeEntity;
import com.webbanquanao.model.SkuEntity;

import java.util.List;

public interface SizeDao {
    void insert(SizeEntity sizeEntity);

    void edit(SizeEntity sizeEntity);

    void delete(int id);
    SizeEntity get(int id);
    List<SizeEntity> getAll();
    int getSizeId(String size_name);

}
