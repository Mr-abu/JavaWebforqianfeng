package com.qf.www.servlets;

import com.qf.www.entity.Dept;
import com.qf.www.service.DeptService;
import com.qf.www.service.impl.DeptServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "InsertServlet", value = "/insert")
public class InsertServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String empno = request.getParameter("empno");
        String ename = request.getParameter("ename");
        String job = request.getParameter("job");

        DeptService deptService = new DeptServiceImpl();
        int insert = deptService.insert(Integer.valueOf(empno), ename, job);

        if (insert >0) {
            response.sendRedirect("/Day005_Web/admin");
        }
    }
}
