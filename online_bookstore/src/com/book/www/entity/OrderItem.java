package com.book.www.entity;

public class OrderItem {
    private String id;
    private int number;
    private float price;
    private Book book;

    @Override
    public String toString() {
        return "OrderItem{" +
                "id='" + id + '\'' +
                ", number=" + number +
                ", price=" + price +
                ", book=" + book +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public OrderItem(String id, int number, float price, Book book) {
        this.id = id;
        this.number = number;
        this.price = price;
        this.book = book;
    }
}
