package com.book.www.servlets;

import cn.dsna.util.images.ValidateCode;
import com.book.www.entity.Admin;
import com.book.www.service.PermissionService;
import com.book.www.service.impl.PermissionServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "AdminLoginServlet" ,value = "/adminLogin")
public class AdminLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String administrator = request.getParameter("administrator");//获得表单中的administrator
        String password = request.getParameter("password");//获得表单中的password
        String validate = request.getParameter("validate");//admin获取表单中的验证码

        if (administrator == null || administrator.trim().length() == 0) {    //验证administrator是否为空
            response.getWriter().write("用户名不能为空！");
            response.setHeader("Refresh", "2;URL="+request.getContextPath()+"/adminLogin.jsp");
            return;
        }

        if (password == null || password.trim().length() == 0) {    //验证password是否为空
            response.getWriter().write("密码不能为空");
            response.setHeader("refresh", "2;URL="+request.getContextPath()+"/adminLogin.jsp");
            return;
        }

        if (validate == null || validate.trim().length() == 0) {    //验证validate是否为空
            response.getWriter().write("验证码不能为空");
            response.setHeader("refresh", "2;URL="+request.getContextPath()+"/adminLogin.jsp");
        }

        PermissionService permissionService = new PermissionServiceImpl();
        Admin admin = permissionService.checkAdmin(administrator, password);

        ValidateCode code = (ValidateCode)session.getAttribute("code");//获得session中验证码
        String validateCode = code.getCode();
        System.out.println(validateCode);//控制台打印validateCode

        if (validateCode.equalsIgnoreCase(validate)) {
            if (admin != null) {
                session.setAttribute("admin", admin);//添加Cookie信息
                Cookie cookie = new Cookie("admininfo", administrator + "#" + password);
                cookie.setPath("/");
                cookie.setMaxAge(60*60*24*7);
                response.addCookie(cookie);
                request.getSession().setAttribute("admin",admin); //session中存入admin

                response.getWriter().write("登陆成功！欢迎你~管理员~");
                response.setHeader("Refresh","2;URL="+request.getContextPath()+"/admin/admin.jsp");
            } else {
                response.getWriter().write("用户名或密码错误！2秒后转向登录页");
                response.setHeader("refresh", "2;URL="+request.getContextPath()+"/adminLogin.jsp");
            }
        } else {
            response.getWriter().write("验证码错误");
            response.setHeader("refresh", "2;URL="+request.getContextPath()+"/adminLogin.jsp");
        }

    }
}
