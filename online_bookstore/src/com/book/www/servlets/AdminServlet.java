package com.book.www.servlets;

import com.book.www.entity.Page;
import com.book.www.entity.User;
import com.book.www.entity.UserPage;
import com.book.www.service.BusinessService;
import com.book.www.service.impl.BusinessServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AdminServlet" ,value = "/adminServlet")
public class AdminServlet extends HttpServlet {

    private BusinessService businessService = new BusinessServiceImpl();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String op = request.getParameter("op");
        if ("listUsers".equals(op)) {
            listUsers(request,response);
        }
    }

    //查询所有User
    private void listUsers(HttpServletRequest request,
                           HttpServletResponse response) throws IOException, ServletException {

        //查询所有商品的分页数据
        String num = request.getParameter("num");
        System.out.println(num);//打印num
        UserPage userPage = businessService.getUserPage(num);
        userPage.setUrl("/adminServlet?op=listUsers");
        request.setAttribute("userPage", userPage);
        System.out.println(userPage.toString());//打印UserPage
        request.getRequestDispatcher("/admin/listUsers.jsp").forward(request, response);
    }

    //通过搜索框查询单个User
    private void getOneUser(HttpServletRequest request,
                            HttpServletResponse response) throws IOException, ServletException {
        String userName = request.getParameter("text");
        System.out.println(userName);//打印userName
        User user = businessService.getByName(userName);
        request.setAttribute("user", user);
        System.out.println(user.toString());//打印User
        request.getRequestDispatcher("/admin/getOneUser.jsp").forward(request, response);

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
