package com.script.dao;

import com.script.entity.NotWork;
import com.script.mapper.NotWorkMapper;
import com.script.mapper.NoteMapper;
import com.script.myEnum.ResultCode;
import com.script.myException.Exceptions.DefaultException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

import static com.script.utils.validate.NWValidateUtil.*;

@Repository
public class NWDao {

    private static final Logger logger = Logger.getLogger(NWDao.class);

    @Autowired
    private NotWorkMapper notWorkMapper;

    @Autowired
    private NoteMapper noteMapper;

    @Transactional
    public void publishNW(Map map){
        logger.debug("DAO层调用:***向notWork表中插入一条新数据***");

        notWorkMapper.addNotWork(map);

        logger.debug("DAO层调用:***向notWork插入数据成功***");
    }
    @Transactional
    public void accNW(Map map){
        logger.debug("DAO层调用:***更新notWork表的状态等信息***");

        validateNWCanAcc(map);              //判断是否可接取

        map.put("state",1);                 //设置state为已接受

        notWorkMapper.updateNoteWork(map);

        logger.debug("DAO层调用:***notWork表更新成功***");

    }

    public NotWork getNW(Map map){
        logger.debug("DAO层调用:***查找nw表中信息***");

        NotWork notWork = notWorkMapper.selectNotWorkById(map);

        logger.debug("DAO层调用:***查找nw表信息成功***");

        return notWork;
    }

    @Transactional
    public void cancleNW(Map map){
        logger.debug("DAO层调用:***更新notWork表的状态等信息***");

        map.put("state",2);

        validateCancleFormat(map);

        validateNWCanCancle(map);

        notWorkMapper.updateNoteWork(map);

        logger.debug("DAO层调用:***notWork表更新成功***");
    }

    public List getNWList(Map map){
        logger.debug("DAO层调用:***获取nw列表***");

        List list = notWorkMapper.selectNotWorkByPosition(map);

        logger.debug("DAO层调用:***nw列表获取成功***");

        return list;
    }
    public void validateNWCanAcc(Map map){
        //判断是否被人接取，接取过的nw不可再次接取
        NotWork notWork = notWorkMapper.selectNotWorkById(map);

        if(notWork.getOrganiser().getId() ==
                Integer.parseInt((String)map.get("accpter"))){
            throw new DefaultException(ResultCode.ACCNW_EXCEPTION,"不能接取自己的notWork");
        }

        if(!(notWork.getState()==0)){
            throw new DefaultException(ResultCode.ACCNW_EXCEPTION,"该NW所处状态,不允许你接取");
        }
    }

    @Transactional
    public void evaluateNW(Map map){

        logger.debug("DAO层调用:***更新notWork表的状态等信息***");

        noteMapper.addNote(map);

        logger.debug("DAO层调用:***更新notWork表的状态成功***");
    }

    public  void validateNWCanCancle(Map map){

        NotWork notWork = notWorkMapper.selectNotWorkById(map);

        if(notWork.getOrganiser().getId() ==
                Integer.parseInt((String)map.get("user_id"))){
            throw new DefaultException(ResultCode.PURVIEW_CER_EXCEPTION,"你没有权限这样做");
        }
    }
}
