package com.qf.www.service.impl;

import  com.qf.www.beans.Emp;
import com.qf.www.dao.EmpDao;
import com.qf.www.dao.impl.EmpDaoImpl;
import com.qf.www.service.EmpService;

import java.util.Date;
import java.util.List;

public class EmpServiceImpl implements EmpService {
    private EmpDao empDao = new EmpDaoImpl();
    @Override
    public List<Emp> getAllEmp() {
        return empDao.getAllEmp();
    }

    @Override
    public Emp getEmp(int empno) {
        return empDao.getEmp(empno);
    }

    @Override
    public int updateEmp(int empno, String ename, String job, int mgr, Date hiredate, double sal, double comm, int deptno) {
        Emp emp = new Emp(empno, ename, job, mgr,hiredate, sal, comm, deptno);
        return empDao.updateEmp(emp);
    }

    @Override
    public int deleteEmp(int empno) {
        return empDao.deleteEmp(empno);
    }

    @Override
    public int insertEmp(int empno, String ename, String job, int mgr, Date hiredate, double sal, double comm, int deptno) {
        Emp emp = new Emp(empno, ename, job, mgr,hiredate, sal, comm, deptno);
        return empDao.insertEmp(emp);
    }

    @Override
    public List<Emp> getAllEmpByPages(int pageIndex, int pageSize) {
        //获取Servlet传递的当前页码和大小
        //做数据的控制
        pageIndex = (pageIndex - 1)*pageSize;
        return empDao.getAllEmpByPages(pageIndex, pageSize);
    }

    @Override
    public long getEmpcount() {
        return empDao.getEmpcount();
    }


}
