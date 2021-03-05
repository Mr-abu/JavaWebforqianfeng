package com.book.www.entity;

public class Classification {   //分类
    private String id;  //分类号
    private String classname;   //分类名称
    private String description;   //描述

    @Override
    public String toString() {
        return "Classification{" +
                "id='" + id + '\'' +
                ", classname='" + classname + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Classification() {
    }

    public Classification(String id, String classname, String description) {
        this.id = id;
        this.classname = classname;
        this.description = description;
    }
}
