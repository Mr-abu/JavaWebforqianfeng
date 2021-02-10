package com.qf.www.service;

import com.qf.www.entity.Dept;

import java.util.List;

public interface DeptService {

    List<Dept> getAllDept();
    int insert(Dept dept);
}
