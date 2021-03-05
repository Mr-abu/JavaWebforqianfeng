package com.book.www.servlets;

import com.book.www.entity.User;
import com.book.www.service.UserService;
import com.book.www.service.impl.UserServiceImpl;
import com.book.www.utils.MailUtils;
import com.book.www.utils.UUIDUtils;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "InsertUserServlet", value = "/insertUser")
public class InsertUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取数据
        String username = request.getParameter("username");
        String password = request.getParameter("password");
//        String again_password = request.getParameter("again_password");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String realName = request.getParameter("realName");
        String email = request.getParameter("email");

        //发送数据
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setRealName(realName);
        user.setPhone(phone);
        user.setAddress(address);
        user.setEmail(email);
        user.setCode(UUIDUtils.getUUID());
        user.setAccess(true);

        //Test:验证数据
        System.out.println(user.toString());

        //注册
        UserService userService = new UserServiceImpl();
        int i = userService.registerUser(user);

        //发送邮件
        try {
            MailUtils.sendMail(email, user.getCode());
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        response.getWriter().write("注册成功，我们已经发送了一封激活邮件到您的"+user.getEmail()+"中，请及时激活您的账户");


//        if (i > 0) {
////            response.sendRedirect(request.getContextPath() + "/login");
//            System.out.println("注册成功");
//        }

    }
}
