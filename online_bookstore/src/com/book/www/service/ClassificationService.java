package com.book.www.service;

import com.book.www.entity.Classification;

import java.util.List;

public interface ClassificationService {
    //添加分类
    int insertClass (Classification classification);

    //查询分类
    List<Classification> getAllClass();

    //根据分类名称查询该分类是否可用
    boolean isClassExists(String className);

    //删除分类
    int deleteClassByName(String className);

    //根据分类id查询分类信息
    Classification getClassById(String classId);

}
