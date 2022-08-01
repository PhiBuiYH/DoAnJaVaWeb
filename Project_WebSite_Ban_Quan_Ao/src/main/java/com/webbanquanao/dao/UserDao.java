package com.webbanquanao.dao;


import com.webbanquanao.model.UserEntity;

import java.util.List;

public interface UserDao {
    void insert(UserEntity user);

    void edit(UserEntity user);

    void delete(int id);

    UserEntity get(String userName);

    UserEntity get(int id);

    List<UserEntity> getAll();

    UserEntity search(String userName);

    boolean checkExistEmail(String email);

    boolean checkExistUserName(String userName);

    boolean checkExistAccount(String email, String password);

    UserEntity getUser(String email);
}
