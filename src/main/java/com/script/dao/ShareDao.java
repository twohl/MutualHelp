package com.script.dao;

import com.script.entity.Share;
import com.script.mapper.ShareMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class ShareDao {

    private static final Logger logger = Logger.getLogger(ShareDao.class);

    @Autowired
    private ShareMapper shareMapper;

    public void shareNearBy(Map map){
        logger.debug("DAO层调用:***分享周边***");

        shareMapper.addShare(map);

        logger.debug("DAO层调用:***分享成功***");
    }

    public List getShareNearBy(Map map){
        logger.debug("DAO层调用:***获取周边的分享***");

        List list = shareMapper.selectShareByPosition(map);

        logger.debug("DAO层调用:***获取分享成功***");

        return list;
    }

    public Share getShare(Map map){

        logger.debug("services层调用:***获取分享的信息***");

        Share share= shareMapper.selectShareById(map);

        logger.debug("services层调用:***获取分享成功***");

        return share;
    }
}
