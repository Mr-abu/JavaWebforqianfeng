package com.qf.www.servlets;

import com.qf.www.service.EmpService;
import com.qf.www.service.impl.EmpServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteServlet", value = "/delete")
public class DeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String empno = request.getParameter("empno");
        EmpService empService = new EmpServiceImpl();
        int i = empService.deleteEmp(Integer.valueOf(empno));

        if (i > 0) {
            response.sendRedirect(request.getContextPath() + "/login");
        }
    }
}
