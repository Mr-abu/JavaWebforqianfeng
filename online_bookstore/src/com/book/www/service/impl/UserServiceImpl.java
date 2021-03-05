package com.book.www.service.impl;

import com.book.www.dao.UserDao;
import com.book.www.dao.impl.UserDaoImpl;
import com.book.www.entity.User;
import com.book.www.service.UserService;

import java.util.UUID;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();

    @Override
    public int registerUser(User user) {
        user.setId(UUID.randomUUID().toString());
        return userDao.insertUser(user);
    }

    @Override
    public User getByCode(String code) {
        return userDao.getByCode(code);
    }

    @Override
    public int activateUser(User user) {
        if (user == null) {
            throw new RuntimeException("数据不能为空");
        }
        if (user.getId() == null) {
            throw new RuntimeException("更新数据的主键不能为空");
        }
        return userDao.updateUser(user);
    }

    @Override
    public User userLogin(String username, String password) {
        User user = userDao.checkUser(username, password);
        if (user == null)
            return null;
        if (!user.isAccess())
            return null;
        return user;
    }

//    @Override
//    public User checkUser(String username, String password) {
//        User user = new User();
//        user.setUsername(username);
//        user.setPassword(password);
//        return userDao.checkUser(user);
//    }
//
//    @Override
//    public int insertUser(String username, String password, String realname, String phone, String address, String email) {
//        User user = new User(username, password, realname, phone, address, email);
//        return userDao.insertUser(user);
//    }
}
