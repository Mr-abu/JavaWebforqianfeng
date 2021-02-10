package com.qf.www.service.impl;

import com.qf.www.beans.Dept;
import com.qf.www.dao.DeptDao;
import com.qf.www.dao.impl.DeptDaoImpl;
import com.qf.www.service.DeptService;

import java.util.List;

public class DeptServiceImpl implements DeptService {
    private DeptDao deptDao = new DeptDaoImpl();
    @Override
    public List<Dept> getAllDept() {
        return deptDao.getAllDept();
    }
}
