package com.book.www.dao.impl;

import com.book.www.dao.UserDao;
import com.book.www.entity.User;
import com.book.www.utils.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
    QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
    @Override
    public User checkUser(User user) {
        try {
            return queryRunner.query("select *from store_users where username = ? and password = ? ;", new BeanHandler<User>(User.class), user.getUsername(), user.getPassword());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
