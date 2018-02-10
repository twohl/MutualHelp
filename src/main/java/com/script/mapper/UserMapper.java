package com.script.mapper;

import com.script.entity.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    void addUser(Map map);

    void addUserInfo(Map map);

    void updateUser(Map map);

    void updateUserInfo(Map map);

    List<User> selectUserByPosition(Map map);

    User selectUserById(Map map);
}
