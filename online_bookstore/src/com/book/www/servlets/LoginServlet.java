package com.book.www.servlets;

import com.book.www.entity.User;
import com.book.www.service.UserService;
import com.book.www.service.impl.UserServiceImpl;
import sun.print.PrinterJobWrapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.awt.print.PrinterGraphics;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        UserService userService = new UserServiceImpl();
        User user = userService.checkUser(username, password);
        PrintWriter writer = response.getWriter();
        if (user != null ) {

            session.setAttribute("user", user);
            Cookie cookie = new Cookie("userinfo", username + "#" + password);
            cookie.setPath("/");
            cookie.setMaxAge(60*60*24*7);
            response.addCookie(cookie);

            if (user.getAccess()==1) {
                System.out.println("<h1>你是管理员</h1>");
            } else {
                System.out.println("<h1>登陆成功</h1>");
            }

        } else {
            System.out.println("<h1>登陆失败</h1>");
        }
    }
}
