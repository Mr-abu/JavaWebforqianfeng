package com.qf.www.web;

import com.qf.www.beans.Emp;
import com.qf.www.service.EmpService;
import com.qf.www.service.impl.EmpServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EmpService empService = new EmpServiceImpl();
        List<Emp> allEmp = empService.getAllEmp();

        if (allEmp != null) {
            request.setAttribute("list", allEmp);
            request.getRequestDispatcher("/index.jsp").forward(request, response);  //request.getContextPath() +
        }

    }
}
