package com.book.www.dao;

import com.book.www.entity.User;

import java.util.List;

public interface UserDao {

    User checkUser(String username, String password);

    int insertUser(User user);

    User getByCode(String code);

    User getByName(String username);

    int updateUser(User user);

    int getUserCount();

    List<User> getAllUserByPages(int pageIndex, int pageSize);
}
