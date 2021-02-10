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

@WebServlet(name = "GetAllServlet", value = "/getall")
public class GetAllServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.调用service
        response.setContentType("text/html;charset=utf-8");
        DeptService deptService = new DeptServiceImpl();
        List<Dept> allDept = deptService.getAllDept();
        PrintWriter writer = response.getWriter();

        //2.手敲页面
        writer.println("<html>");
        writer.println("<head>");
        writer.println("<meta charset='utf-8'/>");
        writer.println("<title>查询所有</title>");
        writer.println("</head>");
        writer.println("<body>");
        writer.println("<table border= '1'>");
        for (Dept dept : allDept) {     //allDept.for
            writer.println("<tr>");
            writer.println("<td>");
            writer.println(dept.getDeptno());
            writer.println("</td>");
            writer.println("<td>");
            writer.println(dept.getDname());
            writer.println("</td>");
            writer.println("<td>");
            writer.println(dept.getLoc());
            writer.println("</td>");
            writer.println("</tr>");
        }
        writer.println("</table>");
        writer.println("</body>");
        writer.println("</html>");
    }
}
