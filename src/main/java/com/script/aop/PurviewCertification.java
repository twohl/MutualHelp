package com.script.aop;

import com.script.dao.UserDao;
import com.script.mapper.LoginMapper;
import com.script.myEnum.ResultCode;
import com.script.myException.Exceptions.DefaultException;
import com.script.utils.resultType.Result;
import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.xml.bind.DataBindingException;
import java.util.Map;

@Component
@Aspect
public class PurviewCertification {

    private final static Logger logger = Logger.getLogger(PurviewCertification.class);


    @Autowired
    private UserDao userDao;

    @Pointcut("execution(public * com.script.services.*.va_*(*))")
    public void PurviewCut(){}


    @Before(value = "PurviewCut()&&args(map)")
    public void PurviewCertifi(Map map){

        logger.debug("aop:***验证权限***");

        String username = (String) map.get("username");

        String lastLogin = (String) map.get("lastLogin");


        if(username == null || "".equals(username)){
            throw new DefaultException(ResultCode.NOLOGIN_EXCEPTION,"还没有登陆,请您登陆");
        }
        if(lastLogin == null || "".equals(lastLogin)){
            throw new DefaultException(ResultCode.PURVIEW_CER_EXCEPTION,"登陆过期,请重新登陆");
        }

        String realLastLogin = userDao.getLoginByUserName(map).getLastLogin();
        if(!lastLogin.equals(realLastLogin)){
            throw new DefaultException(ResultCode.PURVIEW_CER_EXCEPTION,"登陆过期,请重新登陆");
        }
        logger.debug("aop:***权限验证成功***");

    }
}
