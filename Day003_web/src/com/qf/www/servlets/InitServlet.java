package com.qf.www.servlets;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class InitServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //初始化参数  -->使用
        //req.getParameter("")请求过来的数据获取 初始化不是请求给来的数据
        //初始化参数 想要获得 --> 配置相关的内容 ServletConfig
        //区分request(浏览器发送请求带过来的)和ServletConfig(初始化自带的)的区别
        //当前servlet所有的配置信息
        ServletConfig servletConfig = this.getServletConfig();
        String username = servletConfig.getInitParameter("username");
        String password = servletConfig.getInitParameter("password");
        System.out.println(username + ":" + password);
    }
}
