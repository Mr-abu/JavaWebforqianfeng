package com.book.www.entity;

public class Book {

    private String id;
    private String class_Id;
    private String original_name;
    private String name;
    private float original_price;
    private float price;
    private String description;
    private String author;
    private String translator;
    private String publishing_house;
    private String isbn;
    private String path;    //image的存放路径
    private String filename;    //image的文件名
    private Classification classification;

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", class_Id='" + class_Id + '\'' +
                ", original_name='" + original_name + '\'' +
                ", name='" + name + '\'' +
                ", original_price=" + original_price +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", author='" + author + '\'' +
                ", translator='" + translator + '\'' +
                ", publishing_house='" + publishing_house + '\'' +
                ", isbn='" + isbn + '\'' +
                ", path='" + path + '\'' +
                ", filename='" + filename + '\'' +
                ", classification=" + classification +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClass_Id() {
        return class_Id;
    }

    public void setClass_Id(String class_Id) {
        this.class_Id = class_Id;
    }

    public String getOriginal_name() {
        return original_name;
    }

    public void setOriginal_name(String original_name) {
        this.original_name = original_name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getOriginal_price() {
        return original_price;
    }

    public void setOriginal_price(float original_price) {
        this.original_price = original_price;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTranslator() {
        return translator;
    }

    public void setTranslator(String translator) {
        this.translator = translator;
    }

    public String getPublishing_house() {
        return publishing_house;
    }

    public void setPublishing_house(String publishing_house) {
        this.publishing_house = publishing_house;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public Classification getClassification() {
        return classification;
    }

    public void setClassification(Classification classification) {
        this.classification = classification;
    }

    public Book() {
    }

    public Book(String id, String class_Id, String original_name, String name, float original_price, float price, String description, String author, String translator, String publishing_house, String isbn, String path, String filename, Classification classification) {
        this.id = id;
        this.class_Id = class_Id;
        this.original_name = original_name;
        this.name = name;
        this.original_price = original_price;
        this.price = price;
        this.description = description;
        this.author = author;
        this.translator = translator;
        this.publishing_house = publishing_house;
        this.isbn = isbn;
        this.path = path;
        this.filename = filename;
        this.classification = classification;
    }
}
