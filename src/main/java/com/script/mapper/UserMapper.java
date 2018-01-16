package com.script.mapper;

import com.script.entity.User;

import java.util.List;

public interface UserMapper {
    void addUser(User user);
    User selectUserByName(String name);
    List<User> selectAllUser();
}
