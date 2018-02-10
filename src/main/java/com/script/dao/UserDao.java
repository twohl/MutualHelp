package com.script.dao;

import com.script.entity.Login;
import com.script.entity.User;
import com.script.mapper.LoginMapper;
import com.script.mapper.UserMapper;
import com.script.myEnum.ResultCode;
import com.script.myException.Exceptions.DefaultException;
import com.script.utils.encrypt.EncryptPass;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

import static com.script.utils.validate.UserValidateUtil.*;

@Repository
public class UserDao {

    private final static Logger logger = Logger.getLogger(UserDao.class);

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private LoginMapper loginMapper;

    @Transactional
    public Login login(Map map){

        logger.debug("DAO层调用:***获取login表中信息***");

        Login login = loginMapper.selectLogin(map);     //查找login表中是否存在对应数据

        validateLoginResult(
                login,
                (String)map.get("password"));                   //验证登陆是否成功

        loginMapper.updateLogin(map);

        logger.debug("DAO调用:***获取信息成功***");

        return login;

    }

    @Transactional
    public void regist(Map map){

        logger.debug("DAO层调用:***向user,user_extend表中增加一条数据，添加新用户***");

        validateUsername(map);           //验证用户名是否可注册

        userMapper.addUserInfo(map);    //向user_extend中添加新数据,

        userMapper.addUser(map);        //向user表中增加新数据,注册一个新用户信息;

        logger.debug("DAO层调用:***向login表中增加一条新数据,注册用户,设置用户名密码***");

        loginMapper.addLogin(map);      //向login表中增加新数据,关联到用户,并且设置用户名密码;

    }

    public User getUser(Map map){

        logger.debug("DAO层调用:***查找User详细信息***");

        User user = userMapper.selectUserById(map);

        logger.debug("DAO层调用:***信息查找成功***");

        return user;

    }

    @Transactional
    public void editUserinfo(Map map){
        logger.debug("DAO层调用:***更新login user user_extend 表中的信息***");

        userMapper.updateUserInfo(map);

        userMapper.updateUser(map);

        logger.debug("DAO层调用:***表中数据更新成功");

    }
    public List getUserList(Map map){
        logger.debug("DAO层调用:***查找User表中在特定Position中的User***");

        List list = userMapper.selectUserByPosition(map);

        logger.debug("DAO层调用:***查找User成功***");
        return list;
    }

    public Login getLoginByUserName(Map map){

        logger.debug("DAO层调用:***查找login表***");

        Login login = loginMapper.selectLogin(map);

        logger.debug("DAO层调用:***查找成功***");

        return login;
    }

    @Transactional
    public Map validateUsername(Map map){
        Login login = loginMapper.selectLogin(map);

        if(login !=null){
            throw new DefaultException(ResultCode.REPATE_THE_USERNAME,"重复的用户名");
        }

        String newPass = EncryptPass.encrypt((String)map.get("password"));          //加密

        map.put("password",newPass);

        return map;
    }
}
