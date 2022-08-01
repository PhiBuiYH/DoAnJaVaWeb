package com.webbanquanao.service;

import com.webbanquanao.model.UserEntity;

import java.util.List;

public interface UserService {
    void insert(UserEntity user);

    void edit(UserEntity user);

    void delete(int id);

    UserEntity get(String username);

    UserEntity get(int id);

    UserEntity login(String username, String password);

    boolean register(String email, String password, String username);

    List<UserEntity> getAll();

    UserEntity search(String keyword);

    boolean checkExistEmail(String email);

    boolean checkExistUsername(String username);

    boolean checkExistAccount(String email, String password);

    UserEntity getUser(String email);
}
