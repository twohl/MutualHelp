package com.script.entity;

import java.io.Serializable;

public class ChatId implements Serializable{
    private static final long serialVersionUID = 10;

    private int id;
    private User user1;
    private User user2;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser1() {
        return user1;
    }

    public void setUser1(User user1) {
        this.user1 = user1;
    }

    public User getUser2() {
        return user2;
    }

    public void setUser2(User user2) {
        this.user2 = user2;
    }
}
