package com.script.utils.addParam;

import com.script.dao.UserDao;
import com.script.entity.Login;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static com.script.utils.validate.DateTypeValidateUtil.validateGetDate;
@Component
public class AddParam {

    private final static Logger logger = Logger.getLogger(AddParam.class);

    @Autowired
    private  UserDao userDao;

    private  SimpleDateFormat format = new SimpleDateFormat("yy-MM-dd HH:mm:ss");

    public  Map addPublishParam(Map map){
        logger.debug("Util层调用:***添加发布NW的必须信息***");
        Login login = userDao.getLoginByUserName(map);  //根据username 获取到userID
        Date date = new Date();
        format = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
        String organtime = format.format(date);
        map.put("organtime",organtime);             //将当前时间存储为发布nw的时间
        map.put("organiser",login.getUser().getId());
        logger.debug("Util层调用:***成功添加发布NW的必须信息***");
        return map;
    }
    public  Map addACCParam(Map map){
        logger.debug("Util层调用:***添加接受NW的必须信息***");
        Login login = userDao.getLoginByUserName(map);  //根据username 获取到userID
        Date date = new Date();
        format = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
        String acctime = format.format(date);
        map.put("acctime",acctime);             //将当前时间存储未接受nw的时间
        map.put("accpter",login.getUser().getId()+"");
        logger.debug("Util层调用:***成功接受NW的必须信息***");
        return map;
    }

    public  Map addEditParam(Map map){
        logger.debug("Util层调用:***添加修改用户的必须信息***");

        Login login = userDao.getLoginByUserName(map);

        validateGetDate(login);

        int user_id = login.getUser().getId();

        int user_ex_id = login.getUser().getUserInfo().getId();

        map.put("user_id",user_id+"");

        if(map.get("userinfo") == null){
            Map temp = new HashMap();
            temp.put("user_ex_id",user_ex_id+"");
            map.put("userinfo",temp);
        }else{
            ((Map)map.get("userinfo")).put("user_ex_id",user_ex_id+"");
        }

        logger.debug("Util层调用:***成功添加修改用户的必须信息***");

        return map;
    }

    public  Map addShareParam(Map map){
        logger.debug("Util层调用:***添加分享的必须信息***");

        Login login = userDao.getLoginByUserName(map);

        validateGetDate(login);

        int user_id = login.getUser().getId();

        Date date = new Date();

        format = new SimpleDateFormat("yy-MM-dd HH:mm:ss");

        String newDate = format.format(date);

        map.put("date",newDate);
        map.put("user_id",user_id);

        logger.debug("Util层调用:***成功添加分享的必须信息***");
        return map;
    }

    public  Map addChatParam(Map map){
        logger.debug("Util层调用:***添加聊天的必须信息***");

        Login login = userDao.getLoginByUserName(map);

        validateGetDate(login);

        int user_id = login.getUser().getId();

        Date date = new Date();

        format = new SimpleDateFormat("yy-MM-dd HH:mm:ss");

        String newDate = format.format(date);

        map.put("date",newDate);
        map.put("user_id",user_id+"");
        logger.debug("Util层调用:***成功添加聊天的必须信息***");

        return map;
    }

    public  Map addChatIdParam(Map map){
        logger.debug("Util层调用:***添加创建聊天的必须信息***");
        Login login = userDao.getLoginByUserName(map);

        validateGetDate(login);

        int user1 = login.getUser().getId();
        map.put("user1",user1+"");

        logger.debug("Util层调用:***成功添加创建聊天的必须信息***");
        return map;
    }
}
