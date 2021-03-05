package com.qf.www.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "JsonServlet", value = "/js")
public class JsonServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String json1 = "{'id':1, 'name':'JAVAEE-1910', 'students':[{'id':101, 'name':'刘艺', 'age':16},{'id':102, 'name':'小李', 'age':22}]}";
        response.setCharacterEncoding("utf-8");
        response.getWriter().println(json1);
    }
}
