package com.book.www.service.impl;

import com.book.www.dao.ClassificationDao;
import com.book.www.dao.impl.ClassificationDaoImpl;
import com.book.www.entity.Classification;
import com.book.www.service.ClassificationService;

import java.util.List;
import java.util.UUID;

public class ClassificationServiceImpl implements ClassificationService {
    private ClassificationDao classificationDao = new ClassificationDaoImpl();

    @Override
    public int insertClass(Classification classification) {
        classification.setId(UUID.randomUUID().toString());
        return classificationDao.insertClass(classification);
    }

    @Override
    public List<Classification> getAllClass() {
        return classificationDao.getAllClass();
    }

    @Override
    public boolean isClassExists(String className) {
        Classification classification = classificationDao.getClassByName(className);
        return classification == null ? false : true;
    }

    @Override
    public int deleteClassByName(String className) {
        return classificationDao.deleteClassByName(className);
    }

    @Override
    public Classification getClassById(String classId) {
        return classificationDao.getOneClass(classId);
    }
}
