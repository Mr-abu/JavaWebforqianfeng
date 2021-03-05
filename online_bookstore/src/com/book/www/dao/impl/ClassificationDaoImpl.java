package com.book.www.dao.impl;

import com.book.www.dao.ClassificationDao;
import com.book.www.entity.Classification;
import com.book.www.utils.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class ClassificationDaoImpl implements ClassificationDao {
    private QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
    @Override
    public int insertClass(Classification classification) {
        try {
            return queryRunner.update("insert into book_classification (id, classname, description) values (?,?,?)", classification.getId(),classification.getClassname(), classification.getDescription());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<Classification> getAllClass() {
        try {
            return queryRunner.query("select *from book_classification", new BeanListHandler<Classification>(Classification.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Classification getClassByName(String className) {
        try {
            return queryRunner.query("select *from book_classification where classname = ?", new BeanHandler<Classification>(Classification.class), className);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int deleteClassByName(String className) {
        try {
            return queryRunner.update("delete from book_classification where classname = ?", className);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public Classification getOneClass(String classId) {
        try {
            return queryRunner.query("select *from book_classification where id = ?", new BeanHandler<Classification>(Classification.class), classId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
