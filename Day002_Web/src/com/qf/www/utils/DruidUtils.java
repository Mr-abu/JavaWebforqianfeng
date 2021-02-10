package com.qf.www.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DruidUtils {
    private static DruidDataSource dataSource;
    static {
        Properties properties = new Properties();
        InputStream resourceAsStream = DruidUtils.class.getClassLoader().getResourceAsStream("database.properties");
        try {
            properties.load(resourceAsStream);
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
