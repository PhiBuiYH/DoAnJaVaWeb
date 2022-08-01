package com.webbanquanao.service.impl;

import com.webbanquanao.dao.CartDao;
import com.webbanquanao.dao.impl.CartDaoImpl;
import com.webbanquanao.model.CartEntity;
import com.webbanquanao.model.CartitemEntity;
import com.webbanquanao.service.CartService;

import java.util.List;

public class CartServiceImpl implements CartService {
    CartDao cartDao = new CartDaoImpl();

    @Override
    public List<CartEntity> search(String name) {
        return cartDao.search(name);
    }

    @Override
    public void insert(CartEntity cart) {
        cartDao.insert(cart);

    }

    @Override
    public List<CartEntity> getAll() {
        return cartDao.getAll();
    }

    public List<CartEntity> getByUserId(int id) {
        return cartDao.getByUserId(id);
    }

    @Override
    public CartEntity get(int id) {
        return cartDao.get(id);
    }

    @Override
    public void edit(CartEntity cart) { cartDao.edit(cart); }

    @Override
    public void delete(int id) {
        cartDao.delete(id);
    }

    @Override
    public void removeProduct(CartEntity cart, int pId){
        cartDao.removeProduct(cart, pId);
    }

    @Override
    public double totalBill(CartEntity cart) { return cartDao.totalBill(cart);}

    @Override
    public int getIDCart() { return cartDao.getIDCart(); }

    @Override
    public List<CartitemEntity> getCart(int u_id) { return cartDao.getCart(u_id); }

    @Override
    public void UpdateCustomer(int id, int c_id) { cartDao.UpdateCustomer(id,c_id); }

    @Override
    public void updateStatus(CartEntity cart) {
        int status = cart.getStatus();
        if (status==2) {
            status=0;
        }
        else {
            status +=1;
        }
        cart.setStatus(status);
        cartDao.updateStatus(cart);
    }
}
