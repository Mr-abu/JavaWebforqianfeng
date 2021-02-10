package com.qf.www.entity;

public class Address {
    private String name;
    private String zipCode;

    @Override
    public String toString() {
        return "address{" +
                "name='" + name + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Address() {
    }

    public Address(String name, String zipCode) {
        this.name = name;
        this.zipCode = zipCode;
    }
}
