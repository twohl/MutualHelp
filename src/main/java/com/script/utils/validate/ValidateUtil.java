package com.script.utils.validate;

import com.script.entity.Login;
import com.script.myEnum.ResultCode;
import com.script.myException.Exceptions.DefaultException;
import com.script.utils.jiami.JiaMiPass;
import org.apache.log4j.Logger;

import java.util.Map;

public class ValidateUtil {

    private final static Logger logger = Logger.getLogger(ValidateUtil.class);

    public static void validatePositionFormat(Map map){
        logger.debug("Util调用:***验证位置信息格式***");
        Double lng = Double.parseDouble((String) map.get("lng"));

        Double lat = Double.parseDouble((String) map.get("lat"));

        if(lng == null || lat ==null){
            throw new DefaultException(ResultCode.NOPOSITION_EXCEPTION,"未获取到位置信息");
        }

        logger.debug("Util调用:***位置信息验证成功***");

    }


    public static void validateRegistFormat(Map map){
        logger.debug("Util调用:***验证注册格式***");

        /**
         * 取得map中需要的值
         */

        String username = (String)map.get("username");

        String password = (String)map.get("password");

        String nickName = (String)map.get("nickname");

        if(username == null || "".equals(username)){
            throw new DefaultException(ResultCode.NOUSERNAME_EXCEPTION,"未填写用户名");
        }

        if(password == null || "".equals(password)){
            throw new DefaultException(ResultCode.NOPASSWORD_EXCEPTION,"未填写密码");
        }

        if(nickName == null || "".equals(nickName)){
            throw new DefaultException(ResultCode.NONICKNAME_EXCEPTION,"未填写昵称");
        }

        logger.debug("Util调用:***注册格式正确***");
    }

    public static void validateLoginFormat(Map map) throws DefaultException{
        String username = (String)map.get("username");
        String password = (String)map.get("password");
        String lastLogin = (String)map.get("lastLogin");
        logger.debug("Util调用:***验证登陆格式***");
        if(username == null || "".equals(username)){
            throw new DefaultException(ResultCode.NOUSERNAME_EXCEPTION,"用户名不能为空");
        }

        if(password == null || "".equals(password)){
            throw new DefaultException(ResultCode.NOPASSWORD_EXCEPTION,"密码不能为空");
        }

        if(lastLogin == null || "".equals(lastLogin)){
            throw new DefaultException(ResultCode.NOLOGININFO_EXCEPTION,"未知设备,不允许登陆");
        }
        logger.debug("Util调用:***登陆格式证正确***");
    }

    public static void validateLoginResult(Login login, String password){

        logger.debug("Util调用:***验证用户名密码***");
        if(login == null || login.getUser() == null || "".equals(login.getUsername())){
            throw new DefaultException(ResultCode.NORIGHTUSERNAME_EXCEPTION,"用户名不存在");
        }

        if(!login.getPassword().equals(JiaMiPass.jiami(password))){
            throw new DefaultException(ResultCode.NORIGHTPASSWORD_EXCEPTION,"用户名或密码错误");
        }
        logger.debug("Util调用:***用户名密码验证成功***");
    }
    public static void validateGetDate(Object obj){

        logger.debug("Util调用:***验证是否取得数据***");
        if(obj == null){
            throw new DefaultException(ResultCode.NODATA_EXCEPTION,"取得数据为空");
        }
        logger.debug("Util调用:***成功取得数据***");
    }

    public static void validateUpdateUserInfo(Map map){
        logger.debug("Util调用:***验证更新的必要数据是否完整***");

        String username = (String) map.get("username");

        Integer user_id = (Integer) map.get("user_id");

        Map userInfo = (Map) map.get("userinfo");

        if(username == null || "".equals(username)){
            throw new DefaultException(ResultCode.NOUSERNAME_EXCEPTION,"未获取到用户名，更新错误");
        }

        if(user_id == null){
            throw new DefaultException(ResultCode.NOREFER_USER_EXCEPTION,"未正确找到该用户，更新失败");
        }

        if(userInfo == null || userInfo.get("user_ex_id") == null){
            throw new DefaultException(ResultCode.NOREFER_USERINFO_EXCEPTION,"未找到该用户信息，更新失败");
        }




        logger.debug("Util调用:***验证数据完整***");
    }
}
