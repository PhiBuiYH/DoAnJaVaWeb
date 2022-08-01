package com.webbanquanao.dao;


import com.webbanquanao.model.CartitemEntity;

import java.util.List;

public interface CartItemDao {
    void insert(CartitemEntity cartItem);

    void edit(CartitemEntity cartItem);

    void delete(CartitemEntity cartitem);

    CartitemEntity get(String name);

    CartitemEntity get(int id);

    List<CartitemEntity> getAll();

    List<CartitemEntity> getByCartId(int id);

    List<CartitemEntity> search(String name);

    int getIDCartItem();
}
