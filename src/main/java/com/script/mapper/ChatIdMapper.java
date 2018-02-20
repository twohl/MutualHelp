package com.script.mapper;

import com.script.entity.ChatId;
import com.script.entity.User;

import java.util.Map;

public interface ChatIdMapper {

    void addChatId(Map map);

    ChatId selectChatIdByUser(Map map);
}
