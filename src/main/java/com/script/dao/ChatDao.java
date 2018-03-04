package com.script.dao;


import com.script.entity.ChatId;
import com.script.mapper.ChatIdMapper;
import com.script.mapper.ChatMapper;
import com.script.mapper.ChatRoomMessageMapper;
import com.script.myEnum.ResultCode;
import com.script.myException.Exceptions.DefaultException;
import com.script.utils.resultType.Result;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Repository
public class ChatDao {

    private static final Logger logger = Logger.getLogger(ChatDao.class);

    @Autowired
    private ChatMapper chatMapper;

    @Autowired
    private ChatIdMapper chatIdMapper;

    @Autowired
    private ChatRoomMessageMapper chatRoomMessageMapper;

    public void chatToUser(Map map){
        logger.debug("DAO层调用:***向Chat表中添加一条数据***");

        chatMapper.addChat(map);

        logger.debug("DAO层调用:***chat表数据添加成功***");

    }

    public void chatToNearBy(Map map){
        logger.debug("DAO层调用:***向ChatRoom表中添加一条数据***");

        chatRoomMessageMapper.addChatRoomMessage(map);

        logger.debug("DAO层调用:***chatRoom表数据添加成功***");

    }

    public List getChatWithUser(Map map){
        logger.debug("DAO层调用:***查找Chat表中数据***");

        List list = chatMapper.selectChatAfterDate(map);

        logger.debug("DAO层调用:***查找成功***");
        return list;
    }

    public int getChatCountWithUser(Map map){
        logger.debug("DAO层调用:***查找Chat表中数据***");

        int count = chatMapper.selectChatCountAfterDate(map);

        logger.debug("DAO层调用:***查找成功***");
        return count;
    }

    public List getChatNearBy(Map map){
        logger.debug("DAO层调用:***查找ChatRoom表中数据***");

        List list = chatRoomMessageMapper.selectChatRoomMessageAfterDate(map);

        logger.debug("DAO层调用:***查找成功***");
        return list;
    }
    @Transactional
    public ChatId getChatId(Map map){
        logger.debug("DAO层调用:***查找ChatId表中数据***");

        ChatId chatId = chatIdMapper.selectChatIdByUser(map);

        logger.debug("DAO层调用:***查找成功***");
        return  chatId;
    }

    @Transactional
    public void createChatId(Map map){
        logger.debug("DAO层调用:***向ChatId表中添加一条数据***");

        ChatId chatId = chatIdMapper.selectChatIdByUser(map);

        if(chatId != null){
            throw new DefaultException(ResultCode.REPATE_CHATID,"重复的chatID");
        }

        chatIdMapper.addChatId(map);

        logger.debug("DAO层调用:***chatId表数据添加成功***");

    }
}
