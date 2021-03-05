package com.book.www.service.impl;

import com.book.www.dao.BookDao;
import com.book.www.dao.ClassificationDao;
import com.book.www.dao.OrderDao;
import com.book.www.dao.UserDao;
import com.book.www.dao.impl.BookDaoImpl;
import com.book.www.dao.impl.ClassificationDaoImpl;
import com.book.www.dao.impl.OrderDaoImpl;
import com.book.www.dao.impl.UserDaoImpl;
import com.book.www.entity.*;
import com.book.www.service.BusinessService;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.UUID;

public class BusinessServiceImpl implements BusinessService {
    private BookDao bookDao = new BookDaoImpl();
    private ClassificationDao classificationDao = new ClassificationDaoImpl();
    private UserDao userDao = new UserDaoImpl();
    private OrderDao orderDao = new OrderDaoImpl();

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

    @Override
    public int insertClass(Classification classification) {
        classification.setId(UUID.randomUUID().toString());
        return classificationDao.insertClass(classification);
    }

    @Override
    public List<Classification> getAllClass() {
        return classificationDao.getAllClass();
    }

    @Override
    public boolean isClassExists(String className) {
        Classification classification = classificationDao.getClassByName(className);
        return classification == null ? false : true;
    }

    @Override
    public int deleteClassByName(String className) {
        return classificationDao.deleteClassByName(className);
    }

    @Override
    public Classification getClassById(String classId) {
        return classificationDao.getOneClass(classId);
    }

    @Override
    public int registerUser(User user) {
        user.setId(UUID.randomUUID().toString());
        return userDao.insertUser(user);
    }

    @Override
    public User getByCode(String code) {
        return userDao.getByCode(code);
    }

    @Override
    public User getByName(String username) {
        return userDao.getByName(username);
    }

    @Override
    public int activateUser(User user) {
        if (user == null) {
            throw new RuntimeException("数据不能为空");
        }
        if (user.getId() == null) {
            throw new RuntimeException("更新数据的主键不能为空");
        }
        return userDao.updateUser(user);
    }

    @Override
    public User userLogin(String username, String password) {
        User user = userDao.checkUser(username, password);
        if (user == null)
            return null;
        if (!user.isAccess())
            return null;
        return user;
    }

    @Override
    public UserPage getUserPage(String num) {
        int pageNum =1;
        if (num!=null) {
            pageNum= Integer.parseInt(num);
        }
        int totalRecordsNum = userDao.getUserCount();
        UserPage userPage=new UserPage(pageNum, totalRecordsNum);
        List<User> userRecords =userDao.getAllUserByPages(userPage.getPageIndex(), userPage.getPageSize());
        userPage.setUserRecords(userRecords);
        return userPage;
    }

    @Override
    public int createOrder(Order order) {
        if (order==null) {
            throw new RuntimeException("订单不能为空");
        }
        if (order.getUser()==null) {
            throw new RuntimeException("订单的客户不能为空");
        }
        return orderDao.insertOrder(order);
    }

    @Override
    public Order getOrderByNum(String orderNum) {
        return orderDao.getByNum(orderNum);
    }

    @Override
    public int updateOrder(Order order) {
        return orderDao.updateOrder(order);
    }

    @Override
    public int changeOrderStatus(int status, String orderNum) {
        Order order = getOrderByNum(orderNum);
        order.setStatus(status);
        return updateOrder(order);
    }

    @Override
    public List<Order> getOrderByUserId(String userId) {
        return orderDao.getByUserId(userId);
    }

    @Override
    public List<OrderItem> getOrderItemByUserId(String orderNum) {
        return orderDao.getOrderItem(orderNum);
    }
}
