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
import java.io.Writer;

@WebServlet(name = "InsertServlet", value = "/insert")
public class InsertServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        //获取数据
        String deptno = request.getParameter("deptno");
        String dname = request.getParameter("dname");
        String loc = request.getParameter("loc");
        PrintWriter writer = response.getWriter();

        //验证数据的格式
        if (deptno.equals("")||deptno.trim().length()==0) {
            writer.println("部门编号不能为空");
            return;
        }
        if (dname.equals("")||dname.trim().length()==0) {
            writer.println("部门名称不能为空");
            return;
        }
        if (loc.equals("")||loc.trim().length()==0) {
            writer.println("部门地址不能为空");
            return;
        }

        //转换
        Integer deptnos = Integer.valueOf(deptno);

        //封装
        Dept dept = new Dept(deptnos, dname, loc);

        //调用service
        DeptService deptService = new DeptServiceImpl();
        int insert = deptService.insert(dept);

        //判断
        if (insert > 0) {
            //writer.println("新增成功");
            //重定向 代表的是localhost:8080  整个容器
            //response.sendRedirect("/Day002/success.html");
            //转发！ 到查询所有的servlet
            //转发 此处的 / 代表的是   day9_web  转发得是同一个项目下的资源
            request.getRequestDispatcher("/getall").forward(request, response);
        } else {
            //writer.println("新增失败");
            //重定向
            response.sendRedirect("/Day002/fail.html");

        }
    }
}
