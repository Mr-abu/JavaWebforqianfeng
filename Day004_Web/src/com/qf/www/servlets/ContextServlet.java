package com.qf.www.servlets;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebServlet(name = "ContextServlet", value = "/cs")
public class ContextServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        //1.GenericServlet提供的方法 推荐✔
//        ServletContext servletContext = this.getServletContext();
//        //2.通过ServletConfig
//        ServletContext servletContext1 = this.getServletConfig().getServletContext();
        //3.通过request获取 推荐✔ (常用)
        ServletContext servletContext2 = request.getServletContext();
//        //4.通过session获取
//        ServletContext servletContext3 = request.getSession().getServletContext();

//        System.out.println(servletContext);
//        System.out.println(servletContext1);
        System.out.println(servletContext2);
//        System.out.println(servletContext3);
        System.out.println("项目发布路径:" + servletContext2.getRealPath("/"));
        System.out.println("获取servlet信息:" + servletContext2.getServerInfo());
        System.out.println("获取上下文路径:" + servletContext2.getContextPath());

        HttpSession session = request.getSession();
        session.setAttribute("username", "aqiang");
        servletContext2.setAttribute("password","1234");

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
