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

@WebServlet(name = "UpdateServlet", value = "/update")
public class UpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String empno = request.getParameter("empno");
        String ename = request.getParameter("ename");
        String job = request.getParameter("job");

        //非空判断

        DeptService deptService = new DeptServiceImpl();
        int update = deptService.update(Integer.valueOf(empno), ename, job);
        if (update > 0) {
            response.sendRedirect("/Day005_Web/admin");
        }

        //否则，失败了  写个失败页面 5秒跳转查询所有
    }
}
