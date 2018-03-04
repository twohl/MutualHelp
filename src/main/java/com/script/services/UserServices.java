package com.script.services;

import com.script.dao.UserDao;
import com.script.entity.Login;
import com.script.entity.User;
import com.script.myEnum.ResultCode;
import com.script.myException.Exceptions.DefaultException;
import com.script.utils.adapter.PositionAdapter;
import com.script.utils.addParam.AddParam;
import com.script.utils.encrypt.EncryptPass;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.script.utils.addParam.AddParam.*;
import static com.script.utils.validate.DateTypeValidateUtil.validateGetDate;
import static com.script.utils.validate.DateTypeValidateUtil.validatePosition;
import static com.script.utils.validate.UserValidateUtil.*;

@Service
public class UserServices {

    private final static Logger logger = Logger.getLogger(UserServices.class);

    @Autowired
    private AddParam addParam;

    @Autowired
    private UserDao dao;


    public User login(Map map){


        logger.debug("services层调用:***登陆***");
        validateLoginFormat(map);                                //验证传入参数的正确性
        Login login = dao.login(map);                           //进行登陆

        User user = login.getUser();
        logger.debug("services层调用:***登陆成功***");
        return user;

    }


    public void regist(Map map){

        logger.debug("services层调用:***开始注册***");

        validateRegistFormat(map);                              //验证注册信息的完整性

        dao.regist(map);                                        //注册

        logger.debug("services层调用:***注册成功***");

    }

    public User getUser(Map map){

        logger.debug("services层调用:***获取用户详细信息***");

        if(map.get("user_id") == null)
            map = addParam.addUpPos(map);

        User user = dao.getUser(map);                            //获取用户详细信息

        validateGetDate(user);                                  //验证是否取得数据

        logger.debug("services层调用:***获取用户详细信息成功***");

        return user;
    }

    public void va_editUserinfo(HttpServletRequest request,Map map){
        logger.debug("services层调用:***修改用户信息***");

        //添加传入参数缺省的必须参数

        map = addParam.addEditParam(map);

        //验证传入参数完整性

        validateUpdateUserInfo(map);

        dao.editUserinfo(request,map);

        logger.debug("services层调用:***修改用户信息成功***");
    }
    public List va_getUserList(Map map){

        logger.debug("services层调用:***获取用户列表***");

        validatePosition(map);                            //验证传入参数，是否获取到位置信息

        map = PositionAdapter.getPositionRangMap(map);          //将位置信息转换为范围位置信息

        List list = dao.getUserList(map);                       //获取用户列表

        logger.debug("services层调用:***获取用户列表成功***");

        return list;
    }

    public void va_updatePosition(Map map){

        logger.debug("services层调用:***定时发送检测位置信息***");

        map = addParam.addUpPos(map);

        dao.updatePosition(map);

        logger.debug("services层调用:***检测成功***");


    }


}
