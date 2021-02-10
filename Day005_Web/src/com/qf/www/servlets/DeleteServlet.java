package com.qf.www.servlets;

import com.qf.www.dao.impl.DeptDaoImpl;
import com.qf.www.service.DeptService;
import com.qf.www.service.impl.DeptServiceImpl;

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
        String no = request.getParameter("no");
        DeptService deptService = new DeptServiceImpl();

        int delete = deptService.delete(Integer.valueOf(no));
        if (delete > 0) {
            response.sendRedirect("/Day005_Web/admin");
        }
    }
}
