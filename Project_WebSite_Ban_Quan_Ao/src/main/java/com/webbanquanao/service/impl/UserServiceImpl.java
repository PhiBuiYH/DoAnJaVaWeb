package com.webbanquanao.service.impl;

import com.webbanquanao.dao.UserDao;
import com.webbanquanao.dao.impl.UserDaoImpl;
import com.webbanquanao.model.UserEntity;
import com.webbanquanao.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoImpl();

    @Override
    public void insert(UserEntity user) {
        userDao.insert(user);
    }

    @Override
    public void edit(UserEntity newUser) {
        UserEntity oldUser = userDao.get(newUser.getId());

        oldUser.setEmail(newUser.getEmail());
        oldUser.setUserName(newUser.getUserName());
        oldUser.setPassword(newUser.getPassword());
        oldUser.setAddress(newUser.getAddress());
        oldUser.setPermission(newUser.getPermission());
        oldUser.setPhone(newUser.getPhone());
        if (newUser.getAvatar() != null) {
            /*// XOA ANH CU DI
            String fileName = oldUser.getAvatar();
            final String dir = "C:\\Users\\mai vien\\eclipse-workspace\\UNIFY\\upload";
            File file = new File(dir + "/" + fileName);
            if (file.exists()) {
                file.delete();
            }
            // THEM ANH MOI*/
            oldUser.setAvatar(newUser.getAvatar());
        }

        userDao.edit(oldUser);
    }

    @Override
    public void delete(int id) {
        userDao.delete(id);
    }

    @Override
    public UserEntity get(String username) {
        return userDao.get(username);
    }

    @Override
    public UserEntity get(int id) {
        return userDao.get(id);
    }

    @Override
    public List<UserEntity> getAll() {
        return userDao.getAll();
    }

    @Override
    public UserEntity search(String username) {
        return userDao.search(username);
    }

    @Override
    public UserEntity login(String username, String password) {
        UserEntity user = this.get(username);
        if (user != null && password.equals(user.getPassword())) {
            return user;
        }

        return null;
    }

    @Override
    public boolean register(String username, String password, String email) {
        if (userDao.checkExistUserName(username)) {
            return false;
        }
        //       userDao.insert(new UserEntity(email, username, password));
        return true;
    }


    public boolean checkExistEmail(String email) {
        return userDao.checkExistEmail(email);
    }

    public boolean checkExistUsername(String username) {
        return userDao.checkExistUserName(username);
    }

    public boolean checkExistAccount(String email, String password) { return userDao.checkExistAccount(email,password);}

    public UserEntity getUser(String email) { return userDao.getUser(email); }
}
