package com.servicedesk.api.models;

import java.sql.Timestamp;

public class User {
    private long id;
    private String name;
    private final String email;
    private String password;
    private final long createdAt;
    private long updatedAt;

    public long getCreatedAt() {
        return createdAt;
    }

    public long getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(long updatedAt) {
        this.updatedAt = updatedAt;
    }

    public User(String email) {
        this.email = email;
        this.createdAt = new Timestamp(System.currentTimeMillis()).getTime();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Name: " + this.getName() + " | Email: " + this.getEmail();
    }
}
