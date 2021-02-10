package com.qf.www.dao;

import com.qf.www.entity.User;
import com.sun.xml.internal.txw2.output.DumpSerializer;

import java.util.List;

public interface UserDao {
    User checkUser(User user);
}
