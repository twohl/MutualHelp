package com.script.controller;

import com.alibaba.fastjson.JSON;
import com.script.entity.User;
import com.script.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserMapper userMapper;
    @ResponseBody
    @RequestMapping("/registy")
    public String registy(){
        User user = userMapper.selectUserByname("ali");
        return JSON.toJSONString(user,true);
    }
}
