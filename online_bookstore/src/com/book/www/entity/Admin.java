package com.book.www.entity;

public class Admin {    //管理员
    private String id;
    private String administrator;
    private String password;

    @Override
    public String toString() {
        return "Admin{" +
                "id='" + id + '\'' +
                ", administrator='" + administrator + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAdministrator() {
        return administrator;
    }

    public void setAdministrator(String administrator) {
        this.administrator = administrator;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Admin() {
    }

    public Admin(String id, String administrator, String password) {
        this.id = id;
        this.administrator = administrator;
        this.password = password;
    }
}
