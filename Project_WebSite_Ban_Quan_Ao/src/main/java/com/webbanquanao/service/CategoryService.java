package com.webbanquanao.service;

import com.webbanquanao.model.CategoryEntity;

import java.util.List;

public interface CategoryService {
    void insert(CategoryEntity category);

    void edit(CategoryEntity category);

    void delete(int cate_id);

    CategoryEntity get(int cate_id);

    CategoryEntity get(String cate_name);

    List<CategoryEntity> getAll();

    List<CategoryEntity> search(String cate_name);
}
