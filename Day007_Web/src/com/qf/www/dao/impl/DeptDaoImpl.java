package com.qf.www.dao.impl;

import com.alibaba.druid.pool.DruidDataSource;
import com.qf.www.dao.DeptDao;
import com.qf.www.entity.Dept;
import com.qf.www.utils.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
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

    @Override
    public int delete(int no) {
        try {
            return queryRunner.update("delet from detp where empno =?;", no);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
