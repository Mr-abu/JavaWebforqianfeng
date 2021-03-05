package com.book.www.service.impl;

import com.book.www.dao.OrderDao;
import com.book.www.dao.impl.OrderDaoImpl;
import com.book.www.entity.Order;
import com.book.www.entity.OrderItem;
import com.book.www.service.OrderService;

import java.util.List;

public class OrderServiceImpl implements OrderService {
    private OrderDao orderDao = new OrderDaoImpl();

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
