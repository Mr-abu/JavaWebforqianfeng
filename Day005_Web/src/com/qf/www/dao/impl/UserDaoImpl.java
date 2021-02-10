package com.qf.www.dao.impl;

import com.alibaba.druid.pool.DruidDataSource;
import com.qf.www.dao.UserDao;
import com.qf.www.entity.User;
import com.qf.www.utils.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
    QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
    @Override
    public User checkUser(User user) {
        try {
            return queryRunner.query("select * from user where username = ? and password = ? ;", new BeanHandler<User>(User.class), user.getUsername(), user.getPassword());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
