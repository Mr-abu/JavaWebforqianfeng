package com.qf.www.logins;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response)                                                                                                                                                                                                                                                                                                       ;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //......获得浏览器发送的请求数据
        //request包含了所有的请求相关的内容
        //Tomcat7及以后GET请求已经修改了编码，POST没改
        //如果post请求出现了乱码，修改请求内容的编码格式

        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("浏览器发送的数据为：" +username+ ":" +password);

        //前端验证格式，后端验证值的准确性
        if (username.equals("高强")&&password.equals("123456")) {
            response.getWriter().println("登陆成功！");
        } else {
            response.getWriter().println("登陆失败~");
        }
    }
}
