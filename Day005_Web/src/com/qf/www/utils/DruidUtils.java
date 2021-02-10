package com.qf.www.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

public class DruidUtils {
    private static DruidDataSource dataSource;  //?为什么是静态

    static {
        Properties properties = new Properties();
        try {
            properties.load(DruidUtils.class.getClassLoader().getResourceAsStream("database.properties"));
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static DruidDataSource getDataSource() {
        return dataSource;
    }
}
