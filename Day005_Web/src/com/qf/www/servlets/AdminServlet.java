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
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "AdminServlet", value = "/admin")
public class AdminServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DeptService deptService = new DeptServiceImpl();
        List<Dept> allDept = deptService.getAllDept();

        if (allDept != null) {
            request.setAttribute("list", allDept);
            request.getRequestDispatcher("/admin/list.jsp").forward(request, response);
        }

//        PrintWriter writer = response.getWriter();
//        writer.println("<html>");
//        writer.println("<head>");
//        writer.println("<meta charset='utf-8'>");
//        writer.println("<title>查询所有</title>");
//        writer.println("</head>");
//        writer.println("<body>");
//        writer.println("<table border='1'>");
//        writer.println("<tr>");
//        writer.println("<th>部门编号</th>");
//        writer.println("<th>部门名称</th>");
//        writer.println("<th>部门地址</th>");
//        writer.println("<th>操作</th>");
//        writer.println("</tr>");
//        for (Dept dept : allDept) {
//            writer.println("<tr>");
//            writer.println("<td>");
//            writer.println(dept.getEmpno());
//            writer.println("</td>");
//            writer.println("<td>");
//            writer.println(dept.getEname());
//            writer.println("</td>");
//            writer.println("<td>");
//            writer.println(dept.getJob());
//            writer.println("</td>");
//            writer.println("<td>");
//            writer.println("<a href = '#'>修改</a>&nbsp;&nbsp;<a href = '"+"/Day005_Web/delete?no="+dept.getEmpno()+"'>删除</a>");
//            writer.println("</td>");
//            writer.println("</tr>");
//        }
//        writer.println("</table>");
//        writer.println("</body>");
//        writer.println("</html>");

    }
}

