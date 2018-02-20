package com.script.utils.validate;

import org.apache.log4j.Logger;

import java.util.Map;

import static com.script.utils.validate.DateTypeValidateUtil.*;

public class ChatValidateUtil {

    private final static Logger logger = Logger.getLogger(ChatValidateUtil.class);


    public static void validateChatUser(Map map){
        logger.debug("Util调用:***验证聊天参数是否完整***");

        validateInteger(map,"chat_id","未指定聊天对象","错误对象的类型");

        validateString(map,"content","没有填写发送内容");

        logger.debug("Util调用:***聊天参数完整***");

    }
    public static void validateChatNearBy(Map map){
        logger.debug("Util调用:***验证聊天参数是否完整***");

        validatePosition(map);

        validateString(map,"content","没有填写发送内容");

        logger.debug("Util调用:***聊天参数完整***");
    }

    public static void validateGetChat(Map map){
        logger.debug("Util调用:***验证获取消息格式***");

        validateDate(map,"date","未指定获取日期","不正确的日期格式");

        validateInteger(map,"chat_id","未获取到该会话","不正确的ID");
        logger.debug("Util调用:***获取消息格式正确***");
    }
    public static void validateGetChatRoom(Map map){
        logger.debug("Util调用:***验证获取消息格式***");

        validateDate(map,"date","未指定获取日期","不正确的日期格式");

        logger.debug("Util调用:***获取消息格式正确***");
    }

    public static void validateCreateChatId(Map map){
        logger.debug("Util调用:***验证创建聊天参数格式***");


        validateInteger(map,"user1","缺少用户","错误的用户ID");

        validateInteger(map,"user2","缺少用户","错误的用户ID");

        logger.debug("Util调用:***创建聊天参数格式正确***");
    }

    public static void validateGetChatId(Map map){
        logger.debug("Util调用:***验证获取聊天格式参数***");


        validateInteger(map,"user1","缺少用户","错误的用户ID");

        validateInteger(map,"user2","缺少用户","错误的用户ID");

        logger.debug("Util调用:***获取聊天参数格式正确***");
    }
}
