package com.qf.www.logins;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获得Session
        HttpSession session = request.getSession();
        //在Session里找对应的用户名是是否存在
        String username = (String) session.getAttribute("username");    //强转
        //如果Session里没有username, 则跳转到登录页面
        if (username==null) {
            String username1 = request.getParameter("username");
            String password = request.getParameter("password");
            //把值存在session里
            if (username1.equals("aqiang")) {    // username.equals("aqiang") -->NullPointerException
                session.setAttribute("username", username1);
                response.sendRedirect("/Day003/index.html");
                return;
            }
            response.sendRedirect("/Day003/login.html");
        } else{
            if (username.equals("aqiang")) {
                request.getRequestDispatcher("index.html").forward(request, response);
            }
        }
    }
}
