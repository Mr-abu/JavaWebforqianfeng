package com.qf.www.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

//@WebServlet(name = "LoginServlet" , value = "/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if ("aqiang".equals(username) && "123456".equals(password)) {   //不用双引号 "123456".equals("password") 错误
            //存在Session中
            session.setAttribute("username", username);
            //浏览器关了存在Cookie中
            Cookie cookie = new Cookie("userinfo", username + "#" + password);
            cookie.setPath("/");
            cookie.setMaxAge(60*60*24*7);
            response.addCookie(cookie);
            response.sendRedirect("/Day005_Web/welcome.html");
        } else {
            response.sendRedirect("/Day005_Web/fail.html");
        }
    }
}
