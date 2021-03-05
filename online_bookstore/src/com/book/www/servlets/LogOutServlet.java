package com.book.www.servlets;

import com.sun.corba.se.spi.ior.ObjectKey;

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
            response.sendRedirect(request.getContextPath() + "/login.jsp");
        } else {
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    String name = cookie.getName();
                    if (name.equals("userinfo")) {
                        cookie.setMaxAge(0);
                        response.sendRedirect(request.getContextPath() + "/login.jsp");
                    }

                }
            }
            response.sendRedirect(request.getContextPath() + "/login.jsp");
        }
    }
}
