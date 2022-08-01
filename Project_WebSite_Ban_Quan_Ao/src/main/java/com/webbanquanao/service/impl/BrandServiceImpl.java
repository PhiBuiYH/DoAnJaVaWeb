package com.webbanquanao.service.impl;

import com.webbanquanao.dao.BrandDao;
import com.webbanquanao.dao.impl.BrandDaoImpl;
import com.webbanquanao.model.BrandEntity;
import com.webbanquanao.model.CategoryEntity;
import com.webbanquanao.service.BrandService;

import java.util.List;

public class BrandServiceImpl implements BrandService {
    BrandDao brandDao = new BrandDaoImpl();

    @Override
    public void insert(BrandEntity brandEntity) {
        brandDao.insert(brandEntity);
    }

    @Override
    public void edit(BrandEntity brandEntity) {
        brandDao.edit(brandEntity);
    }

    @Override
    public void delete(int brand_id) {
        brandDao.detele(brand_id);
    }
    @Override
    public List<BrandEntity> getAll() {
        return brandDao.getAll();
    }
    @Override
    public BrandEntity get(int brand_id) {
        return brandDao.get(brand_id);
    }
}
