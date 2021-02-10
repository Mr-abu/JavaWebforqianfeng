package com.qf.www.dao;

import com.qf.www.beans.Emp;

import java.util.List;

public interface EmpDao {
    List<Emp> getAllEmp();
    Emp getEmp(int empno);
    int updateEmp(Emp emp);
    int deleteEmp(int empno);
    int insertEmp(Emp emp);
}
