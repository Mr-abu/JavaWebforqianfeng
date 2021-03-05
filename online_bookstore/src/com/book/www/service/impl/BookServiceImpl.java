package com.book.www.service.impl;

import com.book.www.dao.BookDao;
import com.book.www.dao.impl.BookDaoImpl;
import com.book.www.entity.Book;
import com.book.www.entity.Classification;
import com.book.www.entity.Page;
import com.book.www.service.BookService;

import java.util.List;
import java.util.UUID;

public class BookServiceImpl implements BookService {
    private BookDao bookDao = new BookDaoImpl();


    @Override
    public int insertBook(Book book) {
        if(book==null)
            throw new IllegalArgumentException("error");
        if(book.getClassification()==null)
            throw new IllegalArgumentException("error");
        book.setId(UUID.randomUUID().toString());
        return bookDao.insertBook(book);
    }

    @Override
    public int deleteBook(String id) {
        return bookDao.deleteBook(id);
    }

    @Override
    public int updateBook(Book book) {
        if(book==null)
            throw new IllegalArgumentException("error");
        if(book.getClassification()==null)
            throw new IllegalArgumentException("error");
        return bookDao.updateBook(book);
    }

    @Override
    public Classification getClassById(String classId) {
        return null;
    }

    @Override
    public Page getPage(String num) {
        int pageNum = 1;
        if (num != null) {
            pageNum=Integer.parseInt(num);
        }
        int totalRecordsNum = bookDao.getBookCount();
        Page page = new Page(pageNum, totalRecordsNum);
        System.out.println(totalRecordsNum);
        System.out.println("pageIndex"+page.getPageIndex());
        System.out.println("pageSize"+page.getPageSize());
        List<Book> records = bookDao.getAllBookByPages(page.getPageIndex(),page.getPageSize());
        if (records == null) {
            System.out.println("没有数据");
        } else {
            System.out.println("有数据");
        }
        page.setRecords(records);
        return page;
    }

    @Override
    public Page getPage(String num, String classId) {
        int pageNum = 1;
        if (num!= null) {
            pageNum = Integer.parseInt(num);
        }
        int totalRecordsNum = bookDao.getBookCount(classId);
        Page page = new Page(pageNum, totalRecordsNum);
        List<Book> records = bookDao.getAllBookByPages(page.getPageIndex(), page.getPageSize(), classId);
        page.setRecords(records);
        return page;
    }

    @Override
    public Book getBook(String id) {
        return bookDao.getBook(id);
    }
}
