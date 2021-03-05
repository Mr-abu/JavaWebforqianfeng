package com.qf.www.entity;

import java.util.ArrayList;

public class Grade {
    private int id;
    private String name;
    private ArrayList<Student> students;

    @Override
    public String toString() {
        return "Grade{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", students=" + students +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public Grade() {
    }

    public Grade(int id, String name, ArrayList<Student> students) {
        this.id = id;
        this.name = name;
        this.students = students;
    }
}
