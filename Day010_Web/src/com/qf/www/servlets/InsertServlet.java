package com.qf.www.servlets;

import com.qf.www.service.EmpService;
import com.qf.www.service.impl.EmpServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "InsertServlet", value = "/insert")
public class InsertServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String empno = request.getParameter("empno");
        String ename = request.getParameter("ename");
        String job = request.getParameter("job");
        String mgr = request.getParameter("mgr");
        String sal = request.getParameter("sal");
        String comm = request.getParameter("comm");
        String deptno = request.getParameter("deptno");

        String hiredate = request.getParameter("hiredate");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = null;
        try {
            parse = simpleDateFormat.parse(hiredate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        EmpService empService = new EmpServiceImpl();
        int i = empService.insertEmp(Integer.valueOf(empno), ename, job, Integer.valueOf(mgr), parse, Double.valueOf(sal), Double.valueOf(comm), Integer.valueOf(deptno));

        if (i > 0 ) {
            response.sendRedirect(request.getContextPath() + "/login");
        }
    }
}
