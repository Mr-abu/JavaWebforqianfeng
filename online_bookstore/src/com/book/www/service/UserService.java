package com.book.www.service;

import com.book.www.entity.User;

public interface UserService {

//    User checkUser(String username, String password);
//
//    int insertUser(User user);
//
//    User getByCode(String code);
//
//    int updateUser(User user);

    //用户注册
    int registerUser(User user);

    //根据激活码获取用户信息
    User getByCode(String code);

    //激活用户的账户
    int activateUser(User user);

    //根据用户名或密码登录，如果账户没有激活就返回null
    User userLogin(String username, String password);
    
}
