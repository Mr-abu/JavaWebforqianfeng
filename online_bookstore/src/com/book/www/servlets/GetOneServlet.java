package com.book.www.servlets;

import com.book.www.entity.Book;
import com.book.www.entity.Classification;
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

@WebServlet(name = "GetOneServlet" , value = "/getOne")
public class GetOneServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        HttpSession session = request.getSession();

        ClassificationService classificationService = new ClassificationServiceImpl();
        List<Classification> allClass = classificationService.getAllClass();

        //查询单个员工
        BookService bookService = new BookServiceImpl();
        Book book = bookService.getBook(id);

        if (book != null) {
            request.setAttribute("book", book);
            request.setAttribute("allClass",allClass);
            session.setAttribute("allClass", allClass);
            request.getRequestDispatcher("/admin/updateBook.jsp").forward(request, response);
        }
    }
}
