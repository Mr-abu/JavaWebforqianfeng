package com.book.www.service;

import com.book.www.entity.User;

public interface UserService {
    User checkUser(String username, String password);
}
