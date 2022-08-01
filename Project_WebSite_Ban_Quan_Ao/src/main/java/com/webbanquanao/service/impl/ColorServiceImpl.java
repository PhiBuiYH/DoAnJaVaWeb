package com.webbanquanao.service.impl;

import com.webbanquanao.dao.ColorDao;
import com.webbanquanao.dao.SizeDao;
import com.webbanquanao.dao.impl.ColorDaoImpl;
import com.webbanquanao.dao.impl.SizeDaoImpl;
import com.webbanquanao.model.ColorEntity;
import com.webbanquanao.model.SizeEntity;
import com.webbanquanao.service.ColorService;

import java.util.List;

public class ColorServiceImpl implements ColorService {
    ColorDao colorDao = new ColorDaoImpl();
    @Override
    public void insert(ColorEntity colorEntity){
        colorDao.insert(colorEntity);
    }

    @Override
    public void edit(ColorEntity colorEntity) {
        ColorEntity oldColor = colorDao.get(colorEntity.getColorId());

        oldColor.setColorName(colorEntity.getColorName());

        colorDao.edit(colorEntity);

    }

    @Override
    public void delete(int id) {
        colorDao.delete(id);

    }

    @Override
    public ColorEntity get(int id) {
        return colorDao.get(id);
    }
    @Override
    public List<ColorEntity> getAll() {
        return colorDao.getAll();
    }

    @Override
    public int getColorId(String color_name) { return colorDao.getColorId(color_name); }
}
