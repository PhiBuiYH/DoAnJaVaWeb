package com.webbanquanao.service.impl;

import com.webbanquanao.dao.CartItemDao;
import com.webbanquanao.dao.impl.CartItemDaoImpl;
import com.webbanquanao.model.CartitemEntity;
import com.webbanquanao.service.CartItemService;

import java.util.List;

public class CartItemServiceImpl implements CartItemService {
    CartItemDao cartItemDao = new CartItemDaoImpl();

    @Override
    public void insert(CartitemEntity cartItem) {
        cartItemDao.insert(cartItem);

    }

    @Override
    public void edit(CartitemEntity cartItem) { cartItemDao.edit(cartItem);}

    @Override
    public void delete(CartitemEntity cartitemEntity) {
        cartItemDao.delete(cartitemEntity);
    }

    @Override
    public CartitemEntity get(int id) {
        return cartItemDao.get(id);
    }

    @Override
    public List<CartitemEntity> getAll() {
        return cartItemDao.getAll();
    }
    @Override
    public List<CartitemEntity> getByCartId(int id){
        return cartItemDao.getByCartId(id);
    }

    @Override
    public List<CartitemEntity> search(String keyword) {
        return cartItemDao.search(keyword);
    }

    @Override
    public int getIDCartItem(){ return cartItemDao.getIDCartItem(); }
}

