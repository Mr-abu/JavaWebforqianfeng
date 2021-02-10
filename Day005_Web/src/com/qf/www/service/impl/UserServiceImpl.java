package com.qf.www.service.impl;

import com.qf.www.dao.UserDao;
import com.qf.www.dao.impl.UserDaoImpl;
import com.qf.www.entity.User;
import com.qf.www.service.UserService;

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
