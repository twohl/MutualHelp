package com.script.services;

import com.script.dao.ShareDao;
import com.script.entity.Share;
import com.script.utils.addParam.AddParam;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

import static com.script.utils.adapter.PositionAdapter.getPositionRangMap;
import static com.script.utils.addParam.AddParam.*;
import static com.script.utils.validate.DateTypeValidateUtil.validateGetDate;
import static com.script.utils.validate.DateTypeValidateUtil.validatePosition;
import static com.script.utils.validate.ShareValidateUtil.*;

@Service
public class ShareServices {

    private static final Logger logger = Logger.getLogger(ShareServices.class);



    @Autowired
    private AddParam addParam;
    @Autowired
    private ShareDao dao;


    public void shareNearBy(HttpServletRequest request,Map map){
        logger.debug("services层调用:***分享周边***");

        validateShare(map);             //验证传入参数的正确性

        map = addParam.addShareParam(map);

        dao.shareNearBy(request,map);

        logger.debug("services层调用:***分享成功***");
    }

    public List getShareNearBy(Map map){
        logger.debug("services层调用:***获取周边的分享***");
        validatePosition(map);          //验证参数正确性
        map = getPositionRangMap(map);
        List list = dao.getShareNearBy(map);
        logger.debug("services层调用:***获取分享成功***");
        return list;
    }

    public Share getShare(Map map){
        logger.debug("services层调用:***获取分享的信息***");

        validateGetShare(map);

        Share share= dao.getShare(map);

        validateGetDate(share);
        logger.debug("services层调用:***获取分享成功***");
        return share;
    }

}
