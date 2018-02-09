package com.script.services;

import com.script.dao.UserDao;
import com.script.entity.Login;
import com.script.entity.User;
import com.script.myEnum.ResultCode;
import com.script.myException.Exceptions.DefaultException;
import com.script.utils.adapter.PositionAdapter;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.script.utils.validate.ValidateUtil.*;

@Service
public class UserServices {

    private final static Logger logger = Logger.getLogger(UserServices.class);

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

        Login login = dao.getLoginByUserName(map);

        if(login !=null){
            throw new DefaultException(ResultCode.REPATE_THE_USERNAME,"重复的用户名");
        }

        dao.regist(map);                                        //注册

        logger.debug("services层调用:***注册成功***");

    }

    public User getUser(int id){

        logger.debug("services层调用:***获取用户详细信息***");

        User user = dao.getUser(id);                            //获取用户详细信息

        validateGetDate(user);                                  //验证是否取得数据

        logger.debug("services层调用:***获取用户详细信息成功***");

        return user;
    }

    public void va_editUserinfo(Map map){
        logger.debug("services层调用:***修改用户信息***");

        //添加传入参数缺省的必须参数

        map = addEditParam(map);

        //验证传入参数完整性

        validateUpdateUserInfo(map);

        dao.editUserinfo(map);

        logger.debug("services层调用:***修改用户信息成功***");
    }
    public List va_getUserList(Map map){

        logger.debug("services层调用:***获取用户列表***");

        validatePositionFormat(map);                            //验证传入参数，是否获取到位置信息

        map = PositionAdapter.getPositionRangMap(map);          //将位置信息转换为范围位置信息

        List list = dao.getUserList(map);                       //获取用户列表

        logger.debug("services层调用:***获取用户列表成功***");

        return list;
    }


    /**
     *
     * 添加前台传过来不完整的数据
     *
     * @param map
     * @return
     */
    private Map addEditParam(Map map){
        logger.debug("Services层调用:***添加修改用户的必须信息***");

        Login login = dao.getLoginByUserName(map);

        validateGetDate(login);

        int user_id = login.getUser().getId();

        int user_ex_id = login.getUser().getUserInfo().getId();

        map.put("user_id",user_id);

        if(map.get("userinfo") == null){
            Map temp = new HashMap();
            temp.put("user_ex_id",user_ex_id);
            map.put("userinfo",temp);
        }else{
            ((Map)map.get("userinfo")).put("user_ex_id",user_ex_id);
        }

        logger.debug("Services层调用:***成功添加修改用户的必须信息***");

        return map;
    }

}
