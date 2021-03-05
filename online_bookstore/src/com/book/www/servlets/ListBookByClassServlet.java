package com.book.www.servlets;

import com.book.www.dao.ClassificationDao;
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
import java.io.IOException;
import java.util.List;

@WebServlet(name = "listBookByClassServlet", value = "/listBookByClass")
public class ListBookByClassServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookService bookService = new BookServiceImpl();
        ClassificationService classificationService = new ClassificationServiceImpl();
        List<Classification> cl = classificationService.getAllClass();
        request.setAttribute("cl", cl);
        System.out.println(cl);//

        //查询所有商品的分页数据
        String num =request.getParameter("num");
        String classId =request.getParameter("classId");
        Page page =bookService.getPage(num, classId);

        page.setUrl("/listBookByClass"); //Url
        request.setAttribute("page", page);

        System.out.println(page.toString());//

        try {
            request.getRequestDispatcher("/main.jsp").forward(request, response);
        } catch (ServletException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
