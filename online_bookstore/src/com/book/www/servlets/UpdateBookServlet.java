package com.book.www.servlets;

import com.book.www.entity.Book;
import com.book.www.entity.Classification;
import com.book.www.service.BookService;
import com.book.www.service.impl.BookServiceImpl;
import com.book.www.utils.UploadUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@WebServlet(name = "UpdateBookServlet" ,value = "/updateBook")
public class UpdateBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String original_name = request.getParameter("original_name");
        String name = request.getParameter("name");
        String author = request.getParameter("author");
        String translator = request.getParameter("translator");
        String publishing_house = request.getParameter("publishing_house");
        String isbn = request.getParameter("isbn");
        String original_price = request.getParameter("original_price");
        String price = request.getParameter("price");
        String description = request.getParameter("description");
        String classId = request.getParameter("classId");

        System.out.println("original_name"+original_name);//✘   //From表单的name没有
        System.out.println("name:"+name);
        System.out.println("author:"+author);
        System.out.println("translator:"+translator);//✘
        System.out.println("publishing_house:"+publishing_house);//✘
        System.out.println("isbn:"+isbn);//✘
        System.out.println("original_price:"+original_price);//✘
        System.out.println("price"+price);
        System.out.println("description:"+description);
        System.out.println("classId:"+classId);

        String realPath = request.getServletContext().getRealPath("/WEB-INF/upload");
        File file = new File(realPath);
        if (!file.exists()) {
            file.mkdirs();
        }
        Collection<Part> parts = request.getParts();
        for (Part part : parts) {
//            String name1 = part.getName();
//            System.out.println(name1);
            String fileName = part.getSubmittedFileName();
            if (fileName != null) {
                //判断上传文件格式是否符合要求
                List<String> fileNames = new ArrayList<String>();
                fileNames.add(".jpg");
                fileNames.add(".png");
                fileNames.add(".bmp");
                fileNames.add(".gif");
                String backZui = fileName.substring(fileName.lastIndexOf("."));
                if (!fileName.contains(backZui)) {
                    response.getWriter().write(fileName + "不符合要求上传！");
                    continue;
                }
                //通过工具类获取文件的唯一名称
                String newFileName = UploadUtils.newFileName(fileName);
                //通过工具类获得打散二级三级目录
                String newFilePath = UploadUtils.newFilePath(realPath, fileName);
                //是文件  文件上传(路径+资源)
                part.write(newFilePath+File.separator+newFileName);
                part.delete();//清除临时缓冲区

                System.out.println(newFileName);
                System.out.println(newFilePath);

                request.setAttribute("newFileName", newFileName);
                request.setAttribute("newFilePath", newFilePath);
            } else {
//                String name2 = part.getName();
//                String parameter = request.getParameter(name2);
//                System.out.println(parameter);
            }
        }

        String newFileName = (String)request.getAttribute("newFileName");
        String newFilePath = (String)request.getAttribute("newFilePath");
        System.out.println(newFileName);
        System.out.println(newFilePath);
        Book book = new Book();
        Classification classification = new Classification();
        classification.setId(classId);  //没有执行
        book.setClassification(classification);
        book.setName(name);
        book.setOriginal_name(original_name);
        book.setPrice(Float.valueOf(price));
        book.setOriginal_price(Float.valueOf(original_price));
        book.setDescription(description);
        book.setAuthor(author);
        book.setTranslator(translator);
        book.setPublishing_house(publishing_house);
        book.setIsbn(isbn);
        book.setPath(newFilePath);
        book.setFilename(newFileName);
        BookService bookService = new BookServiceImpl();

        System.out.println(book.toString());
        int i = bookService.updateBook(book);
        System.out.println(book.toString());
        if (i > 0) {
            response.getWriter().write("修改成功！");
        }
    }
}
