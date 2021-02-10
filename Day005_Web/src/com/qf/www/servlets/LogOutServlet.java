package com.qf.www.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "LogOutServlet", value = "/logout")
public class LogOutServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Object user = session.getAttribute("user");
        if (user != null) {
            session.removeAttribute("user");
            response.sendRedirect("/Day005_Web/login.html");
        } else {
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    String name = cookie.getName();
                    if (name.equals("userinfo")) {
                        cookie.setMaxAge(0);
                        response.sendRedirect("/Day005_Web/login.html");
                    }
                }
            }
            response.sendRedirect("/Day005_Web/login.html");
            request.getRequestDispatcher("/Day005_Web/login.html");
        }

    }
}
