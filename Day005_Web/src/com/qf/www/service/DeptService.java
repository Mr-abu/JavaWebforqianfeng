package com.qf.www.service;

import com.qf.www.entity.Dept;

import java.util.List;

public interface DeptService {
    List<Dept> getAllDept();
    int delete(int no);
    Dept getDept(int no);
    int update(int empno, String ename, String job);
    int insert(int empno, String ename, String job);
}
