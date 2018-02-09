package com.script.mapper;

import com.script.entity.ChatRoomMessage;

import java.util.Date;

public interface ChatRoomMessageMapper {
    void addChatRoomMessage(ChatRoomMessage chatRoomMessage);

    void delChatRoomMessageBeforeDate(Date date);

    ChatRoomMessage[] selectChatRoomMessageAfterDate(Date date);
}
