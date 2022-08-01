package com.webbanquanao.service.impl;

import com.webbanquanao.dao.CategoryDao;
import com.webbanquanao.dao.impl.CategoryDaoImpl;
import com.webbanquanao.model.CategoryEntity;
import com.webbanquanao.service.CategoryService;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {
    CategoryDao categoryDao = new CategoryDaoImpl();

    @Override
    public void insert(CategoryEntity category) {
        categoryDao.insert(category);
    }

    @Override
    public void edit(CategoryEntity newCategory) {
        categoryDao.edit(newCategory);
    }

    @Override
    public void delete(int cate_id) {
        categoryDao.detele(cate_id);
    }

    @Override
    public CategoryEntity get(int cate_id) {
        return categoryDao.get(cate_id);
    }

    @Override
    public CategoryEntity get(String cate_name) {
        return categoryDao.getName(cate_name);
    }

    @Override
    public List<CategoryEntity> getAll() {
        return categoryDao.getAll();
    }

    @Override
    public List<CategoryEntity> search(String cate_name) {
        return categoryDao.search(cate_name);
    }
}
