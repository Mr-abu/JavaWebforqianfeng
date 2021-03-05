package com.book.www.service;

import com.book.www.entity.*;

import java.util.List;

public interface BusinessService {
    //Book
    int insertBook(Book book);  //添加图书

    int deleteBook(String id); //删除图书

    int updateBook(Book book);  //更改图书

    Page getPage(String num);   //根据用户要查看的页码，返回封装了所有分页信息的page对象

    Page getPage(String num, String classId);   //根据用户要查看的页码和种类，返回封装了所有分页信息的page对象

    Book getBook(String id);   //通过BookId查询某一本书


    //Class
    int insertClass (Classification classification);//添加分类

    List<Classification> getAllClass();//查询分类

    boolean isClassExists(String className);//根据分类名称查询该分类是否可用

    int deleteClassByName(String className); //删除分类

    Classification getClassById(String classId); //根据分类id查询分类信息


    //User
    int registerUser(User user); //用户注册

    User getByCode(String code); //根据激活码获取用户信息

    User getByName(String username); //根据用户名获取用户信息

    int activateUser(User user); //激活用户的账户

    User userLogin(String username, String password); //根据用户名或密码登录，如果账户没有激活就返回null

    UserPage getUserPage(String num);   //根据用户要查看的页码，返回封装了所有分页信息的page对象


    //Order
    int createOrder(Order order);//生成订单

    Order getOrderByNum(String orderNum); //根据订单号查找订单


    int updateOrder(Order order);//更新订单信息


    int changeOrderStatus(int status, String orderNum);//更新订单状态

    List<Order> getOrderByUserId(String userId);

    List<OrderItem> getOrderItemByUserId(String orderNum);
}
