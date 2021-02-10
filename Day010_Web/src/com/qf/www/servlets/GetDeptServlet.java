package com.qf.www.servlets;

import com.qf.www.beans.Dept;
import com.qf.www.service.DeptService;
import com.qf.www.service.impl.DeptServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "GetDeptServlet" , value = "/getDept")
public class GetDeptServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DeptService deptService = new DeptServiceImpl();
        List<Dept> allDept = deptService.getAllDept();

        if (allDept != null) {
            request.setAttribute("allDept", allDept);
            request.getRequestDispatcher("/insert.jsp").forward(request, response);
        }
    }
}
