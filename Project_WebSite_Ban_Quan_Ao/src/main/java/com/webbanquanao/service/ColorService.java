package com.webbanquanao.service;

import com.webbanquanao.model.ColorEntity;
import com.webbanquanao.model.SkuEntity;

import java.util.List;

public interface ColorService {
    void insert(ColorEntity colorEntity);

    void edit(ColorEntity colorEntity);

    void delete(int id);
    ColorEntity get(int id);
    List<ColorEntity> getAll();

    int getColorId(String color_name);
}
