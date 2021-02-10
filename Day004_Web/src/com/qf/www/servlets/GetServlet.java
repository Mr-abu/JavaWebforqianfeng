package com.qf.www.servlets;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "GetServlet" ,value = "/gs")
public class GetServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        ServletContext servletContext = request.getServletContext();
        //回话窗口
        Object username = session.getAttribute("username");
        //当前应用 无关客户端 服务器关闭销毁
        Object password = servletContext.getAttribute("password");
//        servletContext.removeAttribute("password");

        String username1 = servletContext.getInitParameter("username");
        String password1 = servletContext.getInitParameter("password");

        System.out.println(username);
        System.out.println(password);
        System.out.println("初始化的" + username1 + ":" + password1);//remove移除不了


//        ServletContext servletContext = request.getServletContext();
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
