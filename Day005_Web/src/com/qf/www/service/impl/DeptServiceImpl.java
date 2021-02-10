package com.qf.www.service.impl;

import com.qf.www.dao.DeptDao;
import com.qf.www.dao.impl.DeptDaoImpl;
import com.qf.www.entity.Dept;
import com.qf.www.service.DeptService;

import java.util.List;

public class DeptServiceImpl implements DeptService {
    private DeptDao deptDao = new DeptDaoImpl();
    @Override
    public List<Dept> getAllDept() {
        return deptDao.getAllDept();
    }

    @Override
    public int delete(int no) {
        return deptDao.delete(no);
    }

    @Override
    public Dept getDept(int no) {
        return deptDao.getDept(no);
    }

    @Override
    public int update(int empno, String ename, String job) {
        return deptDao.update(new Dept(empno, ename, job));
    }

    @Override
    public int insert(int empno, String ename, String job) {
        return deptDao.insert(new Dept(empno, ename, job));
    }
}
