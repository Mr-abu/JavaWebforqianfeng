package com.book.www.servlets;

import cn.dsna.util.images.ValidateCode;
import com.book.www.entity.User;
import com.book.www.service.UserService;
import com.book.www.service.impl.UserServiceImpl;
import sun.print.PrinterJobWrapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.awt.print.PrinterGraphics;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String username = request.getParameter("username");//获得表单中的username
        String password = request.getParameter("password");//获得表单中的password
        String validate = request.getParameter("validate");//获取表单中的验证码

        if (username == null || username.trim().length() == 0) {    //验证username是否为空
            response.getWriter().write("用户名不能为空！");
            response.setHeader("Refresh", "2;URL="+request.getContextPath()+"/login.jsp");
            return;
        }

        if (password == null || password.trim().length() == 0) {    //验证password是否为空
            response.getWriter().write("密码不能为空");
            response.setHeader("refresh", "2;URL="+request.getContextPath()+"/login.jsp");
            return;
        }

        if (validate == null || validate.trim().length() == 0) {    //验证validate是否为空
            response.getWriter().write("验证码不能为空");
            response.setHeader("refresh", "2;URL="+request.getContextPath()+"/login.jsp");
        }

        UserService userService = new UserServiceImpl();
        User user = userService.userLogin(username, password);//调用userService的userLogin方法

        ValidateCode code = (ValidateCode)session.getAttribute("code");//获得session中验证码
        String validateCode = code.getCode();
        System.out.println(validateCode);//控制台打印validateCode

//        if (validateCode.equalsIgnoreCase(validate)) {

            if ( user != null ) {

                session.setAttribute("user", user);//添加Cookie信息
                Cookie cookie = new Cookie("userinfo", username + "#" + password);
                cookie.setPath("/");
                cookie.setMaxAge(60*60*24*7);
                response.addCookie(cookie);
                request.getSession().setAttribute("user",user); //session中存入user

//                //登陆成功之后
//                if (user.getAccess()==1) {
//                    response.getWriter().write("你是管理员~ 欢迎你");   //管理员登录跳转
//                    response.setHeader("Refresh","2;URL="+request.getContextPath()+"/getBook");
//                } else {
                    response.getWriter().write("登录成功"); //普通用户登录跳转
                    response.setHeader("Refresh","2;URL="+request.getContextPath()+"/listBooks");
//                }

            } else {
                response.getWriter().write("用户名或密码错误， 或者你的账户还没有激活！2秒后转向登录页");
                response.setHeader("refresh", "2;URL="+request.getContextPath()+"/login.jsp");
            }
/*        } else {
            response.getWriter().write("验证码错误");
            response.setHeader("refresh", "2;URL="+request.getContextPath()+"/login.jsp");
        }*/
    }
}
