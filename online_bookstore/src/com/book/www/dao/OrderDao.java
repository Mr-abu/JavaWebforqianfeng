package com.book.www.dao;

import com.book.www.entity.Order;
import com.book.www.entity.OrderItem;

import java.util.List;

public interface OrderDao {
    int insertOrder(Order order);

    Order getByNum(String orderNum);

    int updateOrder(Order order);

    //订单号降序排序
    List<Order> getByUserId(String userId);
    List<OrderItem> getOrderItem(String orderNum);
}
