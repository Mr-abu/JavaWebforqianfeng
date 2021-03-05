package com.book.www.dao.impl;

import com.book.www.dao.UserDao;
import com.book.www.entity.User;
import com.book.www.utils.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements UserDao {
    private QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());

    @Override
    public User checkUser(String username, String password) {
        try {
            return queryRunner.query("select *from user where username =? and password =?", new BeanHandler<User>(User.class), username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int insertUser(User user) {
        try {
            return queryRunner.update("insert into user (id, username, password, realName, phone, address, email, code, access) values (?,?,?,?,?,?,?,?,?)",
                    user.getId(), user.getUsername(), user.getPassword(), user.getRealName(), user.getPhone(), user.getAddress(), user.getEmail(), user.getCode(), user.isAccess());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public User getByCode(String code) {
        try {
            return queryRunner.query("select *from user where code =?", new BeanHandler<User>(User.class), code);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User getByName(String username) {
        try {
            return queryRunner.query("select *from user where username =?", new BeanHandler<User>(User.class), username);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int updateUser(User user) {
        try {
            return queryRunner.update("update user set username =?, password =?, realName =?, phone =?, address =?, email =?, code =?, access =? where id= ?",
                    user.getUsername(), user.getPassword(), user.getRealName(), user.getPhone(), user.getAddress(), user.getEmail(), user.getCode(), user.isAccess(), user.getId() );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int getUserCount() {
        try {
            Long num = (Long) queryRunner.query("select count(id) from user", new ScalarHandler<>(1));
            return num.intValue();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<User> getAllUserByPages(int pageIndex, int pageSize) {
        try {
            List<User> users = queryRunner.query("select *from user limit ?, ?", new BeanListHandler<User>(User.class), pageIndex, pageSize);
            return users;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
