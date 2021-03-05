package com.book.www.dao;

import com.book.www.entity.Book;

import java.util.List;

public interface BookDao {

    int insertBook(Book book);  //添加图书

    int deleteBook(String id); //删除图书

    int updateBook(Book book);  //更改图书

    int getBookCount(); //查询图书总数量

    int getBookCount(String classId);   //查询某一种类图书数量

    List<Book> getAllBookByPages(int pageIndex, int pageSize);  //分页查询所有图书

    List<Book> getAllBookByPages(int pageIndex, int pageSize, String classId);  //分页查询某一种类图书

    Book getBook(String id);   //通过BookId查询某一本书


}
