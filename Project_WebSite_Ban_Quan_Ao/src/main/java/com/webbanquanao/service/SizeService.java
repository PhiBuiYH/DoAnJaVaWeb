package com.webbanquanao.service;

import com.webbanquanao.model.SizeEntity;

import java.util.List;

public interface SizeService {
    void insert(SizeEntity sizeEntity);

    void edit(SizeEntity sizeEntity);

    void delete(int id);
    SizeEntity get(int id);
    List<SizeEntity> getAll();
    int getSizeId(String size_name);

}
