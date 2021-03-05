package com.book.www.servlets;

import com.book.www.entity.User;
import com.book.www.service.UserService;
import com.book.www.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ActiveServlet", value = "/active.do")
public class ActiveServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取数据
        String code = request.getParameter("code");

        //数据库判断对应code是否存在，（这里就不进行判断了，直接进行比对）state=1&code=null代表激活
        UserService userService = new UserServiceImpl();
        User user = userService.getByCode(code);

        if(user == null){
            response.getWriter().write("发生未知错误，请重新输入");
            return ;
        }

        user.setAccess(true);
        userService.activateUser(user);//更新数据库User

        response.getWriter().write("激活成功！2秒后转向主页");
        response.setHeader("Refresh", "2;URL="+request.getContextPath());

//        //重定向success.jsp
//        request.getRequestDispatcher("/WEB-INF/success.jsp").forward(request,response);

    }
}
