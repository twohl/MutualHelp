package com.script.mapper;

import com.script.entity.ChatId;
import com.script.entity.User;

public interface ChatIdMapper {

    void addChatId(ChatId chatId);

    ChatId selectChatIdByUser(int user1,int user2);
}
