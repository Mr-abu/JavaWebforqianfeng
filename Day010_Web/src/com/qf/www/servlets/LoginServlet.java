package com.qf.www.servlets;

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
        String pi = request.getParameter("pageIndex");
        String ps = request.getParameter("pageSize");

        int pageIndex = 0;
        int pageSize = 0;

        if (pi == null) {
            pageIndex = 1;
        } else {
            pageIndex = Integer.valueOf(pi);
        }

        if (ps == null) {
            pageSize = 3;
        } else {
            pageSize = Integer.valueOf(ps);
        }

        EmpService empService = new EmpServiceImpl();
        List<Emp> allEmp = empService.getAllEmpByPages(pageIndex, pageSize);

        int empCount = (int) (empService.getEmpcount());  //Integer.valueOf 不能转换Long类型
        int total = empCount % pageSize == 0?empCount/pageSize : empCount/pageSize+1;

        if (allEmp != null) {
            request.setAttribute("total", total);
            request.setAttribute("pageIndex", pageIndex);
            request.setAttribute("pageSize", pageSize);
            request.setAttribute("list", allEmp);
            request.getRequestDispatcher("/index.jsp").forward(request, response);  //不用request.getContextPath()+
        }

    }
}
