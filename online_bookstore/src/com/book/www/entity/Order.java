package com.book.www.entity;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private String orderNum;
    private float price;
    private int number;
    private int status;

    private User user;
    private List<OrderItem> items =new ArrayList<OrderItem>();

    @Override
    public String toString() {
        return "Order{" +
                "orderNum='" + orderNum + '\'' +
                ", price=" + price +
                ", number=" + number +
                ", status=" + status +
                ", user=" + user +
                ", items=" + items +
                '}';
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    public Order() {
    }

    public Order(String orderNum, float price, int number, int status, User user, List<OrderItem> items) {
        this.orderNum = orderNum;
        this.price = price;
        this.number = number;
        this.status = status;
        this.user = user;
        this.items = items;
    }
}
