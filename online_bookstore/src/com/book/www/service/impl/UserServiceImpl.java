package com.book.www.service.impl;

import com.book.www.dao.UserDao;
import com.book.www.dao.impl.UserDaoImpl;
import com.book.www.entity.User;
import com.book.www.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();
    @Override
    public User checkUser(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        return userDao.checkUser(user);
    }
}
