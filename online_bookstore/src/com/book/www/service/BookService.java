package com.book.www.service;

import com.book.www.dao.ClassificationDao;
import com.book.www.entity.Book;
import com.book.www.entity.Classification;
import com.book.www.entity.Page;

import java.util.List;

public interface BookService {

    int insertBook(Book book);  //添加图书

    int deleteBook(String id); //删除图书

    int updateBook(Book book);  //更改图书

    Classification getClassById(String classId);    //根据分类id查询分类信息

    Page getPage(String num);   //根据用户要查看的页码，返回封装了所有分页信息的page对象

    Page getPage(String num, String classId);   //根据用户要查看的页码和种类，返回封装了所有分页信息的page对象

    Book getBook(String id);   //通过BookId查询某一本书

//    int getBookCount(); //查询图书总数量
//
//    int getBookCount(String classId);   //查询某一种类图书数量
//
//    List<Book> getAllBookByPages(int pageIndex, int pageSize);  //分页查询所有图书
//
//    List<Book> getAllBookByPages(int pageIndex, int pageSize, String classId);  //分页查询某一种类图书


}
