package com.qf.www.servlets;

import com.qf.www.beans.Dept;
import com.qf.www.beans.Emp;
import com.qf.www.service.DeptService;
import com.qf.www.service.EmpService;
import com.qf.www.service.impl.DeptServiceImpl;
import com.qf.www.service.impl.EmpServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "GetEmpServlet", value = "/getEmp")
public class GetEmpServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String empno = request.getParameter("empno");
        DeptService deptService = new DeptServiceImpl();

        //查询所有部门，填充到页面的下拉列表
        List<Dept> allDept = deptService.getAllDept();

        //查询单个员工
        EmpService empService = new EmpServiceImpl();
        Emp emp = empService.getEmp(Integer.valueOf(empno));

        if (emp != null ) {
            request.setAttribute("emp", emp);
            request.getRequestDispatcher("/update.jsp").forward(request, response);
        }
    }
}
