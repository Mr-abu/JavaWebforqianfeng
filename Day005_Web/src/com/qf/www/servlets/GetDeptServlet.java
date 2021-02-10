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

@WebServlet(name = "GetDeptServlet", value = "/getdept")
public class GetDeptServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String empno = request.getParameter("empno");
        DeptService deptService = new DeptServiceImpl();

        if (empno != null) {
            Dept dept = deptService.getDept(Integer.valueOf(empno));
            request.setAttribute("dept", dept);
            request.getRequestDispatcher("/admin/update.jsp").forward(request, response);
        }
    }
}
