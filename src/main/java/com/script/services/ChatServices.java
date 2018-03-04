package com.script.services;

import com.script.dao.ChatDao;
import com.script.entity.ChatId;
import com.script.utils.adapter.PositionAdapter;
import com.script.utils.addParam.AddParam;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import static com.script.utils.validate.ChatValidateUtil.*;
import static com.script.utils.validate.DateTypeValidateUtil.validateGetDate;

@Service
public class ChatServices {

    private static final Logger logger = Logger.getLogger(ChatServices.class);

    @Autowired
    private AddParam addParam;

    @Autowired
    private ChatDao dao;

    public void va_chatToUser(Map map){
        logger.debug("services层调用:***向其他用户发送一条消息***");

        validateChatUser(map);

        map = addParam.addChatParam(map);

        dao.chatToUser(map);

        logger.debug("services层调用:***发送消息成功***");
    }

    public void va_chatToNearBy(Map map){
        logger.debug("services层调用:***向附近用户发送一条消息***");

        validateChatNearBy(map);

        map = addParam.addChatParam(map);

        dao.chatToNearBy(map);

        logger.debug("services层调用:***发送消息成功***");
    }

    public List va_getChatWithUser(Map map){

        logger.debug("services层调用:***获取一组聊天***");

        validateGetChat(map);

        List list = dao.getChatWithUser(map);

        logger.debug("services层调用:***获取成功***");
        return list;
    }

    public int va_getChatCountWithUser(Map map){

        logger.debug("services层调用:***获取一组聊天新信息***");

        validateGetChat(map);

        int count = dao.getChatCountWithUser(map);

        logger.debug("services层调用:***获取新信息成功***");
        return count;
    }

    public List va_getChatNearBy(Map map){
        logger.debug("services层调用:***获取聊天室聊天***");

        validateGetChatRoom(map);

        map = PositionAdapter.getPositionRangMap(map);

        List list = dao.getChatNearBy(map);

        logger.debug("services层调用:***获取成功***");
        return list;
    }

    public void va_createChatId(Map map){
        logger.debug("services层调用:***创建一组聊天***");

        map = addParam.addChatIdParam(map);

        validateCreateChatId(map);

        dao.createChatId(map);

        logger.debug("services层调用:***创建成功***");

    }

    public ChatId va_getChatId(Map map){
        logger.debug("controller层调用:***获取一组聊天***");
        try {
            va_createChatId(map);
        }catch (Exception e){
        }

        validateGetChatId(map);

        ChatId chatId = dao.getChatId(map);
        validateGetDate(chatId);

        logger.debug("controller层调用:***获取成功***");

        return chatId;
    }
}
