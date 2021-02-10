package com.qf.www.servlets;

import javax.servlet.*;
import java.io.IOException;

public class MyServlet implements Servlet {


    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        //初始化
        System.out.println("初始化方法...");
    }

    @Override
    public ServletConfig getServletConfig() {
        System.out.println("获取配置信息方法...");
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("提供服务");

    }

    @Override
    public String getServletInfo() {

        return null;
    }

    @Override
    public void destroy() {

    }
}
