package com.script.mapper;

import com.script.entity.Login;

import java.util.Map;

public interface LoginMapper {

    void addLogin(Map map);

    void updateLogin(Map map);

    Login selectLogin(Map map);
}
