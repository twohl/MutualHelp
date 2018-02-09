package com.script.utils.validate;

import com.script.myEnum.ResultCode;
import com.script.myException.Exceptions.DefaultException;

import java.util.Map;

public class ValidateMapFormat {

    public static void validateUserNameAndPassWordFormat(Map map) throws DefaultException{
        String username = (String)map.get("username");
        String password = (String)map.get("password");

        if(username == null || "".equals(username)){
            throw new DefaultException(ResultCode.NOUSERNAME_EXCEPTION,"用户名不能为空");
        }

        if(password == null || "".equals(password)){
            throw new DefaultException(ResultCode.NOPASSWORD_EXCEPTION,"密码不能为空");
        }

    }


}
