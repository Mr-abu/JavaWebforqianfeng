package com.book.www.dao;

import com.book.www.entity.Classification;

import java.util.List;

public interface ClassificationDao {

    int insertClass (Classification classification);

    List<Classification> getAllClass();

    Classification getClassByName(String className);

    int deleteClassByName(String className);

    Classification getOneClass(String classId);

}
