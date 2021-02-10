package com.qf.www.dao.impl;

import com.qf.www.dao.DeptDao;
import com.qf.www.entity.Dept;
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
            List<Dept> list = queryRunner.query("select *from dept;", new BeanListHandler<Dept>(Dept.class));
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int insert(Dept dept) {
        try {
            int update = queryRunner.update("insert into dept (deptno, dname, loc)values(?,?,?)", dept.getDeptno(), dept.getDname(), dept.getLoc());
            return update;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
