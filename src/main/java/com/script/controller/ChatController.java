package com.script.controller;

import com.script.entity.ChatId;
import com.script.myEnum.ResultCode;
import com.script.services.ChatServices;
import com.script.utils.resultType.Result;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/chat",method = RequestMethod.POST)
public class ChatController {

    private static final Logger logger = Logger.getLogger(ChatController.class);

    @Autowired
    private ChatServices services;

    @RequestMapping(value = "/chatUser",method = RequestMethod.PUT)
    public Result chatToUser(@RequestBody Map map){
        logger.debug("controller层调用:***向其他用户发送一条消息***");

        services.va_chatToUser(map);

        Result result = new Result(ResultCode.SEND_MESSAGE_SUCCESS,"发送消息成功",null);
        logger.debug("controller层调用:***发送消息成功***");
        return result;
    }

    @RequestMapping(value = "/chatNearBy",method = RequestMethod.PUT)
    public Result chatToNearBy(@RequestBody Map map){
        logger.debug("controller层调用:***向附近用户发送一条消息***");

        services.va_chatToNearBy(map);

        Result result = new Result(ResultCode.SEND_MESSAGE_SUCCESS,"发送消息成功",null);
        logger.debug("controller层调用:***发送消息成功***");
        return result;
    }

    @RequestMapping(value = "/addChatId",method = RequestMethod.POST)
    public Result createChatId(@RequestBody Map map){
        logger.debug("controller层调用:***创建一组聊天***");

        services.va_createChatId(map);

        Result result = new Result(ResultCode.GETDATA_SUCCESS,"创建聊天成功",null);
        logger.debug("controller层调用:***创建成功***");
        return result;

    }

    @RequestMapping(value = "/getChatId",method = RequestMethod.POST)
    public Result getChatId(@RequestBody Map map){
        logger.debug("controller层调用:***获取一组聊天***");

        ChatId chatId = services.va_getChatId(map);
        Result result = new Result(ResultCode.GETDATA_SUCCESS,"获取消息成功",chatId);
        logger.debug("controller层调用:***获取成功***");

        return result;
    }

    @RequestMapping(value = "/getChat",method = RequestMethod.POST)
    public Result getChatWithUser(@RequestBody Map map){
        logger.debug("controller层调用:***获取一组聊天***");

        List list = services.va_getChatWithUser(map);

        Result result = new Result(ResultCode.GETDATA_SUCCESS,"获取消息成功",list);
        logger.debug("controller层调用:***获取成功***");
        return result;
    }
    @RequestMapping(value = "/getChatNear",method = RequestMethod.POST)
    public Result getChatNearBy(@RequestBody Map map){
        logger.debug("controller层调用:***获取聊天室聊天***");

        List list = services.va_getChatNearBy(map);

        Result result = new Result(ResultCode.GETDATA_SUCCESS,"获取消息成功",list);
        logger.debug("controller层调用:***获取成功***");
        return result;
    }
}
