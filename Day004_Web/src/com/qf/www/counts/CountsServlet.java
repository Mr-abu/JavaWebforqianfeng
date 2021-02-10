package com.qf.www.counts;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CountsServlet", value = "/countss")
public class CountsServlet extends HttpServlet {
//    int num = 0; 成员变量
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        单个servlet的访问次数
//        num++;
//        System.out.println("您是第" + num + "个访问当前页面的");
        ServletContext servletContext = request.getServletContext();
        Integer count = (Integer)servletContext.getAttribute("count");
        if (count == null) {
            count = 1;
            servletContext.setAttribute("count", count);
        } else {
            count++;
            servletContext.setAttribute("count", count);
        }
        response.getWriter().println("您是第" + count + "个访问的");
    }
}
