package com.script.dao;

import java.io.Serializable;

public class Login implements Serializable{
    private static final long serialVersionUID = 3;
    private String username;
    private String password;
    private User user;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
