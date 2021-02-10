package com.qf.www.servlets;

import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SafeServlet" ,value = "/ss")
public class SafeServlet extends HttpServlet {
    //线程不安全。。每个线程访问的数据都可能是不准确的
    //多个线程访问一个Servlet(对象)。共享成员变量
    int num = 0;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        num++;
        System.out.println("当前num值为：" + num);
    }
}
