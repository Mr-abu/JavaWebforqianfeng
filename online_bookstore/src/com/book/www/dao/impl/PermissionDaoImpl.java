package com.book.www.dao.impl;

import com.book.www.dao.PermissionDao;
import com.book.www.entity.Admin;
import com.book.www.utils.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class PermissionDaoImpl implements PermissionDao {
    private QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());

    @Override
    public Admin checkAdmin(String administrator, String password) {
        try {
            return queryRunner.query("select *from admin where administrator =? and password =? ", new BeanHandler<Admin>(Admin.class), administrator, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
