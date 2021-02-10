package com.qf.www.dao;

import com.qf.www.entity.Dept;

import java.util.List;

public interface DeptDao {
    List<Dept> getAllDept();
    int insert(Dept dept);
}
