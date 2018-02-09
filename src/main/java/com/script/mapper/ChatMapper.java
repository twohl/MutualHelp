package com.script.mapper;

import com.script.entity.Chat;
import com.script.entity.User;
import org.apache.ibatis.annotations.Select;

import java.util.Date;

public interface ChatMapper {

    void addChat(Chat chat);

    Chat[] selectChatAfterDate(Date date);

    Chat[] selectChatBeforeDate(Date date);

    void delChatBeforeDate(Date date);


}
