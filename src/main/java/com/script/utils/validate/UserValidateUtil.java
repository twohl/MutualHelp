package com.script.utils.validate;

import com.script.entity.Login;
import com.script.myEnum.ResultCode;
import com.script.myException.Exceptions.DefaultException;
import com.script.utils.encrypt.EncryptPass;
import org.apache.log4j.Logger;

import java.util.Map;

import static com.script.utils.validate.DateTypeValidateUtil.*;

public class UserValidateUtil {

    private final static Logger logger = Logger.getLogger(UserValidateUtil.class);

    public static void validatePositionFormat(Map map){
        logger.debug("Util调用:***验证位置信息格式***");

        validateDouble(map,"lng","未获取到位置信息","错误的位置信息");

        validateDouble(map,"lat","未获取到位置信息","错误的位置信息");

        logger.debug("Util调用:***位置信息验证成功***");
    }


    public static void validateRegistFormat(Map map){
        logger.debug("Util调用:***验证注册格式***");

        validateString(map,"username","未填写用户名");

        validateString(map,"password","未填写密码");

        validateString(map,"nickname","未填写昵称");

        logger.debug("Util调用:***注册格式正确***");
    }

    public static void validateLoginFormat(Map map) throws DefaultException{
        logger.debug("Util调用:***验证登陆格式***");

        validateString(map,"username","用户名不能为空");

        validateString(map,"password","密码不能为空");

        validateString(map,"lastLogin","未知设备,不允许登陆");

        logger.debug("Util调用:***登陆格式证正确***");
    }

    public static void validateLoginResult(Login login, String password){

        logger.debug("Util调用:***验证用户名密码***");
        if(login == null || login.getUser() == null || "".equals(login.getUsername())){
            throw new DefaultException(ResultCode.NORIGHTDATA_EXCEPTION,"用户名不存在");
        }

        if(!login.getPassword().equals(EncryptPass.encrypt(password))){
            throw new DefaultException(ResultCode.NORIGHTDATA_EXCEPTION,"用户名或密码错误");
        }
        logger.debug("Util调用:***用户名密码验证成功***");
    }


    public static void validateGetDate(Object obj){

        logger.debug("Util调用:***验证是否取得数据***");
        if(obj == null){
            throw new DefaultException(ResultCode.NODATAINDB_EXCEPTION,"取得数据为空");
        }
        logger.debug("Util调用:***成功取得数据***");
    }

    public static void validateUpdateUserInfo(Map map){
        logger.debug("Util调用:***验证更新的必要数据是否完整***");

        validateString(map,"username","未获取到用户名，更新错误");

        validateInteger(map,"user_id","未正确找到该用户，更新失败","错误的User ID");

        validateString(map,"nickname","未填写昵称");

        Map userInfo = (Map) map.get("userinfo");

        validateInteger(userInfo,"user_ex_id","未找到该用户信息，更新失败","错误的UserInfo ID");

        logger.debug("Util调用:***验证数据完整***");
    }
}
