package com.qf.www.service;

import com.qf.www.beans.Emp;

import java.util.Date;
import java.util.List;

public interface EmpService {
    List<Emp> getAllEmp();
    Emp getEmp(int empno);
    int updateEmp(int empno, String ename, String job, int mgr, Date hiredate, double sal, double comm, int deptno);
    int deleteEmp(int empno);
    int insertEmp(int empno, String ename, String job, int mgr, Date hiredate, double sal, double comm, int deptno);
}
