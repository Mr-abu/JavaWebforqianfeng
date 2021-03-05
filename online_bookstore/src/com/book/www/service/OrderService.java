package com.book.www.service;

import com.book.www.entity.Order;
import com.book.www.entity.OrderItem;

import java.util.List;

public interface OrderService {
    //生成订单
    int createOrder(Order order);

    //根据订单号查找订单
    Order getOrderByNum(String orderNum);

    //更新订单信息
    int updateOrder(Order order);

    //更新订单状态
    int changeOrderStatus(int status, String orderNum);

    List<Order> getOrderByUserId(String userId);

    List<OrderItem> getOrderItemByUserId(String orderNum);

}