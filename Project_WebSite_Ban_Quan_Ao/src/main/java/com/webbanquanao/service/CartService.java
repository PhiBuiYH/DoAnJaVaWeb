package com.webbanquanao.service;

import com.webbanquanao.model.CartEntity;
import com.webbanquanao.model.CartitemEntity;

import java.util.List;

public interface CartService {
    void insert(CartEntity cart);

    void edit(CartEntity newCart);

    void delete(int id);

    CartEntity get(int id);

    List<CartEntity> getAll();

    List<CartEntity> getByUserId(int id);

    List<CartEntity> search(String keyword);

    void removeProduct(CartEntity cart, int pId);

    double totalBill(CartEntity cart);

    int getIDCart();

    List<CartitemEntity> getCart(int u_id);

    void UpdateCustomer(int id, int c_id);

    void updateStatus(CartEntity cart);
}
