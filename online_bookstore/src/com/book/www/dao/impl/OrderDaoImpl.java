package com.book.www.dao.impl;

import com.book.www.dao.OrderDao;
import com.book.www.entity.Book;
import com.book.www.entity.Order;
import com.book.www.entity.OrderItem;
import com.book.www.entity.User;
import com.book.www.utils.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class OrderDaoImpl implements OrderDao {
    private QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
    @Override
    public int insertOrder(Order order) {
        try {
            int i = queryRunner.update("insert into order (orderNum , price, number, status, userId) values (?,?,?,?,?)",
                    order.getOrderNum(), order.getPrice(), order.getNumber(), order.getStatus(), order.getUser()==null?null:order.getUser().getId());
            List<OrderItem> items = order.getItems();
            for (OrderItem item : items) {
                queryRunner.update("insert into orderitem (id, number, price, orderNum, bookId) values (?,?,?,?,?)",
                        item.getId(), item.getNumber(), item.getPrice(), order.getOrderNum(), item.getBook()==null?null:item.getBook().getId());
            }
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public Order getByNum(String orderNum) {
        try {
            Order order =queryRunner.query("select *from order where OrderNum= ?", new BeanHandler<Order>(Order.class), orderNum);
            if (order != null) {
                User user = queryRunner.query("select *from user where id =(select userId from order where orderNum= ?)",
                        new BeanHandler<User>(User.class), orderNum);
                order.setUser(user);
            }
            return order;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int updateOrder(Order order) {
        try {
            return queryRunner.update("update order set price=?,number=?,status=? where orderNum=?",order.getPrice(),order.getNumber(),order.getStatus(),order.getOrderNum());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<Order> getByUserId(String userId) {
        try {
            List<Order> orders = queryRunner.query("select *from order where userId =? order by orderNum desc",new BeanListHandler<Order>(Order.class), userId);
            if (orders!=null) {
                User user = queryRunner.query("select *from user where id= ?", new BeanHandler<User>(User.class), userId);
                for (Order order : orders) {
                    order.setUser(user);
                }
            }
            return orders;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<OrderItem> getOrderItem(String orderNum) {
        try {
            List<OrderItem> items= queryRunner.query("select *from orderitem where orderNum =?", new BeanListHandler<OrderItem>(OrderItem.class), orderNum);
            if (items!=null) {
                for (OrderItem item : items) {
                    Book book =queryRunner.query("select *from book where id=(select bookId from orderitem where id =?)",new BeanHandler<Book>(Book.class), item.getId());
                    item.setBook(book);
                }
            }
            return items;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
