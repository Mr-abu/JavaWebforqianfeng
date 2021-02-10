package com.qf.www.dao.impl;

import com.qf.www.beans.Dept;
import com.qf.www.dao.DeptDao;
import com.qf.www.utils.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class DeptDaoImpl implements DeptDao {
    private QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
    @Override
    public List<Dept> getAllDept() {
        try {
            return queryRunner.query("select *from dept;", new BeanListHandler<Dept>(Dept.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
