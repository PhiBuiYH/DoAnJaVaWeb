package com.webbanquanao.dao;

import com.webbanquanao.model.CategoryEntity;

import java.util.List;

public interface CategoryDao {
    void insert(CategoryEntity category);

    void edit(CategoryEntity category);

    void detele(int cate_id);

    CategoryEntity get(int cate_id);

    CategoryEntity getName(String cate_name);

    List<CategoryEntity> getAll();

    List<CategoryEntity> search(String keyword);
}
