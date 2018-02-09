package com.script.controller;

import com.script.entity.User;
import com.script.myEnum.ResultCode;
import com.script.services.UserServices;
import com.script.utils.resultType.Result;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    private static final Logger logger = Logger.getLogger(UserController.class);
    @Autowired
    private UserServices services;

    @RequestMapping("/regist")
    public Result regist(@RequestBody Map map){

        logger.debug("controller层调用:***开始注册***");
        services.regist(map);
         Result result = new Result(ResultCode.REGIST_SUCCESS,"注册成功",null);
        logger.debug("controller层调用结束:***完成注册***");
        return result;
    }

    @RequestMapping("/login")
    public Result login(@RequestBody Map map){

        logger.debug("controller层调用:***输入用户名密码,开始登陆***");
        User user = services.login(map);
        Result result = new Result(ResultCode.LOGIN_SUCCESS,"登陆成功",user);
        logger.debug("controller层调用:***登陆成功***");

        return result;
    }

    @RequestMapping("/userList")
    public Result getUserList(@RequestBody Map map){

        logger.debug("controller层调用:***获取用户列表***");
        List list = services.va_getUserList(map);
        Result result = new Result(ResultCode.GETDATA_SUCCESS,"列表获取成功",list);
        logger.debug("controller层调用:***获取用户列表成功***");
        return result;
    }

    @RequestMapping("/userInfo/{id}")
    public Result getUserInfo(@PathVariable("id") int id){

        logger.debug("controller层调用:***获取用户详细信息***");

        User user = services.getUser(id);
        Result result = new Result(ResultCode.GETDATA_SUCCESS,"用户信息拉取成功",user);

        logger.debug("controller层调用:***获取用户详细信息成功***");
        return result;
    }

    @RequestMapping("/edit")
    public Result EditUserInfo(@RequestBody Map map){

        logger.debug("controller层调用:***修改用户个人信息***");

        services.va_editUserinfo(map);

        Result result = new Result(ResultCode.DATAUPDATE_SUCCESS,"用户信息修改成功",null);
        logger.debug("controller层调用:***用户个人信息修改成功***");

        return result;
    }
}
