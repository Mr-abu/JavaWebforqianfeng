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

@WebServlet(name = "UpdateUserServlet", value = "/updateUser")
public class UpdateUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");
        String realName = request.getParameter("realName");
        String email = request.getParameter("email");
        String address = request.getParameter("address");

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setPhone(phone);
        user.setRealName(realName);
        user.setEmail(email);
        user.setAddress(address);

        System.out.println(user.toString());//测试

        UserService userService = new UserServiceImpl();
        System.out.println(user.toString());
        int i =userService.activateUser(user);

        if (i >0 ) {
            response.getWriter().write("修改成功！");
        } else {
            response.getWriter().write("修改失败！");
        }
    }
}
