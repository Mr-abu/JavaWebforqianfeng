package com.qf.www.servlet;

import com.alibaba.fastjson.JSON;
import com.qf.www.entity.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "JsonServlet2", value = "/js2")
public class JsonServlet2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String json = request.getParameter("json");
        //利用FastJSON进行转换解析
        Student student = JSON.parseObject(json, Student.class);
        System.out.println(student.getId()+":"+student.getName()+":"+student.getAge());
        response.setCharacterEncoding("utf-8");
        response.getWriter().println("接受成功");
    }
}
