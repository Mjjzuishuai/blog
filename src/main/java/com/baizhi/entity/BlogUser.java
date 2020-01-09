package com.baizhi.entity;

import java.io.Serializable;

public class BlogUser implements Serializable {
    private String id;
    private String name;
    private String password;

    public BlogUser(String id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public BlogUser() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "BlogUser{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
