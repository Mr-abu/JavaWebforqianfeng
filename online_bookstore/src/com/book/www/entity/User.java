package com.book.www.entity;

public class User { //用户

    private String id;
    private String username;
    private String password;
    private String realName;
    private String phone;
    private String address;
    private String email;
    private String code;    //激活码
    private boolean access; //激活状态

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", realName='" + realName + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", code='" + code + '\'' +
                ", access=" + access +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean isAccess() {
        return access;
    }

    public void setAccess(boolean access) {
        this.access = access;
    }

    public User() {
    }

    public User(String id, String username, String password, String realName, String phone, String address, String email, String code, boolean access) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.realName = realName;
        this.phone = phone;
        this.address = address;
        this.email = email;
        this.code = code;
        this.access = access;
    }
}
