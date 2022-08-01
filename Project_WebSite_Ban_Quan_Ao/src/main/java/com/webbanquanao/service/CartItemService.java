package com.webbanquanao.service;

import com.webbanquanao.model.CartitemEntity;

import java.util.List;

public interface CartItemService {
    void insert(CartitemEntity cartItem);

    void edit(CartitemEntity cartItem);

    void delete(CartitemEntity cartitemEntity);

    CartitemEntity get(int id);

    List<CartitemEntity> getAll();

    List<CartitemEntity> getByCartId(int id);

    List<CartitemEntity> search(String keyword);

    int getIDCartItem();
}
