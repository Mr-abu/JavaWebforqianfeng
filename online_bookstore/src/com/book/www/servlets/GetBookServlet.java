package com.book.www.servlets;

import com.book.www.entity.Book;
import com.book.www.entity.Classification;
import com.book.www.entity.Page;
import com.book.www.service.BookService;
import com.book.www.service.ClassificationService;
import com.book.www.service.impl.BookServiceImpl;
import com.book.www.service.impl.ClassificationServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "GetBookServlet", value = "/getBook")
public class GetBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookService bookService = new BookServiceImpl();
        ClassificationService classificationService = new ClassificationServiceImpl();
        //查询所有分类
        List<Classification> cl = classificationService.getAllClass();
        request.setAttribute("cl", cl);
        HttpSession session = request.getSession();
        session.setAttribute("cl", cl);
//        System.out.println(cl);//有数据

        //查询所有商品的分页数据
        String num = request.getParameter("num");
        Page page = bookService.getPage(num);
        page.setUrl("/listBooks"); //Url
        request.setAttribute("page",page);
//        System.out.println(page.toString());//
        request.getRequestDispatcher("/admin/indexBook.jsp").forward(request, response);
    }
}
