package com.script.services;

import com.script.dao.NWDao;
import com.script.dao.UserDao;
import com.script.entity.Login;
import com.script.entity.NotWork;
import com.script.utils.addParam.AddParam;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static com.script.utils.adapter.PositionAdapter.getPositionRangMap;
import static com.script.utils.addParam.AddParam.*;
import static com.script.utils.validate.DateTypeValidateUtil.*;
import static com.script.utils.validate.NWValidateUtil.*;

@Service
public class NWServices {

    private static final Logger logger = Logger.getLogger(NWServices.class);

    private static final SimpleDateFormat format = new SimpleDateFormat("yy-MM-dd HH:mm:ss");


    @Autowired
    private AddParam addParam;
    @Autowired
    private NWDao dao;

    @Autowired
    private UserDao userDao;

    public void va_publishNW(Map map){
        logger.debug("services层调用:***发布notwork***");

        map = addParam.addPublishParam(map);             //添加时间，添加必备参数

        validateNWFormat(map);                  //验证发布格式

        dao.publishNW(map);

        logger.debug("services层调用:***notwork发布成功***");
    }

    public void va_accNW(Map map){

        logger.debug("services层调用:***接取notWork***");

        map = addParam.addACCParam(map);                     //添加时间，添加必备参数

        validateGetOrAccFormat(map);                     //验证接受nw格式

        dao.accNW(map);

        logger.debug("services层调用:***接取成功***");

    }

    public void va_cancleNW(Map map){
        logger.debug("services层调用:***取消notwork***");

        validateCancleFormat(map);          //验证取消nw格式

        Login login = userDao.getLoginByUserName(map);

        map.put("user_id",login.getUser().getId()+"");

        dao.cancleNW(map);

        logger.debug("services层调用:***取消notWork成功***");
    }

    public void va_evaluateNW(Map map){
        logger.debug("services层调用:***评价notwork***");

        validateEvaluateNWFormat(map);        //验证评价格式

        dao.evaluateNW(map);

        logger.debug("services层调用:***评价成功***");
    }

    public List va_getNWList(Map map){

        logger.debug("services层调用:***获取nw列表***");

        validatePosition(map);

        map = getPositionRangMap(map);

        List list = dao.getNWList(map);

        logger.debug("services层调用:***nw列表获取成功***");
        return list;
    }

    public NotWork va_getNW(Map map){

        logger.debug("serveices层调用:***获取nw信息***");
        validateGetOrAccFormat(map);

        NotWork notWork = dao.getNW(map);

        validateGetDate(notWork);
        logger.debug("services层调用:***获取nw信息成功***");
        return notWork;
    }

    public void va_editNW(Map map){
        logger.debug("services层调用:***修改nw信息***");

        validateEditFormat(map);

        dao.editNW(map);

        logger.debug("sercices层调用:***nw信息修改成功***");
    }

}
