package com.qf.www.servlets;

import com.qf.www.entity.User;
import com.qf.www.service.UserService;
import com.qf.www.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (username == null || username.trim().length() == 0) {
            response.getWriter().println("用户名不能为空！");
            return;
        }
        if (password == null || password.trim().length() == 0) {
            response.getWriter().println("密码不能为空");
            return;
        }

        UserService userService = new UserServiceImpl();
        User user = userService.checkUser(username, password);

        if (user != null ) {

            session.setAttribute("user", user);
            Cookie cookie = new Cookie("userinfo", username + "#" + password);
            cookie.setPath("/");
            cookie.setMaxAge(60*60*24*7);
            response.addCookie(cookie);

            if (user.getAccess()==1) {
                response.sendRedirect("/Day007_Web/admin");
            } else {
                response.sendRedirect("/Day007_Web/getall");
            }

        } else {
            response.sendRedirect("/Day007_Web/fail.html");
        }
    }
}















