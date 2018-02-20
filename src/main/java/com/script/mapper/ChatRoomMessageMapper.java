package com.script.mapper;

import com.script.entity.ChatRoomMessage;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface ChatRoomMessageMapper {
    void addChatRoomMessage(Map map);

    void delChatRoomMessageBeforeDate(Map map);

    List selectChatRoomMessageAfterDate(Map map);
}
