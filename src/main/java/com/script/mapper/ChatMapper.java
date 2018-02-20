package com.script.mapper;

import com.script.entity.Chat;
import com.script.entity.User;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface ChatMapper {

    void addChat(Map map);

    List selectChatAfterDate(Map map);

    void delChatBeforeDate(Map map);


}
