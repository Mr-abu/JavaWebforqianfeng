package com.qf.www.service;

import com.qf.www.entity.User;

public interface UserService {
    User checkUser(String username, String password);
}
