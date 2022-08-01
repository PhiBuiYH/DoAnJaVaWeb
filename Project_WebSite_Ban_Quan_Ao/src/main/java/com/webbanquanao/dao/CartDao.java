package com.webbanquanao.dao;

import com.webbanquanao.model.CartEntity;
import com.webbanquanao.model.CartitemEntity;

import java.util.List;

public interface CartDao {
    void insert(CartEntity cart);

    void edit(CartEntity cart);

    void delete(int id);

    CartEntity get(String name);

    CartEntity get(int id);

    List<CartEntity> getAll();

    List<CartEntity> getByUserId(int id);

    List<CartEntity> search(String name);

    void removeProduct(CartEntity cart, int pId);

    double totalBill(CartEntity cart);

    int getIDCart();

    List<CartitemEntity> getCart(int u_id);

    void UpdateCustomer(int id, int c_id);

    void updateStatus(CartEntity cart);
}
