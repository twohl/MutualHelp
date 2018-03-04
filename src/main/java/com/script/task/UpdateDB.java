package com.script.task;

import com.script.mapper.ChatMapper;
import com.script.mapper.ChatRoomMessageMapper;
import com.script.mapper.UserMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
public class UpdateDB {
    private static final Logger logger = Logger.getLogger(UpdateDB.class);
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ChatMapper chatMapper;
    @Autowired
    private ChatRoomMessageMapper chatRoomMessageMapper;
    @Scheduled(cron="* 0/5 * * * ? ")
    public void cleanPosition(){
        userMapper.cleanUser();
    }
    @Scheduled(cron = "0 0 0 0/1 * ?")
    public void cleanChatLog(){
        chatMapper.clear();
        chatRoomMessageMapper.clear();
    }
}
