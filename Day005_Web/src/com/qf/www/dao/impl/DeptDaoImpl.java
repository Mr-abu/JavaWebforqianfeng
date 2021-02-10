package com.qf.www.dao.impl;

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
            return queryRunner.query("select * from dept; ", new BeanListHandler<Dept>(Dept.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int delete(int no) {
        try {
            //找了半天的错误！！ 这里没有  "delete * from dept where empno = ? " 错误！！
            return queryRunner.update("delete from dept where empno = ?", no);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public Dept getDept(int no) {
        try {
            return queryRunner.query("select *from dept where empno=?;", new BeanHandler<Dept>(Dept.class), no);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int update(Dept dept) {
        try {
           return queryRunner.update("update dept set ename =?, job =? where empno =?", dept.getEname(), dept.getJob(), dept.getEmpno() );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int insert(Dept dept) {
        try {
            return queryRunner.update("insert into dept(empno, ename, job) values (?,?,?); ",dept.getEmpno(), dept.getEname(), dept.getJob());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
