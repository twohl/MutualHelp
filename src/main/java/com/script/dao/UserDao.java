package com.script.dao;

import com.script.entity.Login;
import com.script.entity.User;
import com.script.mapper.LoginMapper;
import com.script.mapper.UserMapper;
import com.script.myEnum.ResultCode;
import com.script.myException.Exceptions.DefaultException;
import com.script.utils.adapter.JsonImageAdapter;
import com.script.utils.encrypt.EncryptPass;
import com.script.utils.validate.DateTypeValidateUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
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


    public void updatePosition(Map map){
        logger.debug("DAO层调用:***更新user表中的信息***");

        userMapper.updatePosition(map);

        logger.debug("DAO层调用:***表中数据更新成功");

    }

    public void editUserinfo(HttpServletRequest request,Map map){
        logger.debug("DAO层调用:***更新login user user_extend 表中的信息***");

        userMapper.updateUserInfo(map);

        userMapper.updateUser(map);

        String icon;

        if(map.get("icon")!=null&&!"".equals(map.get("icon").toString())){
            icon = (String) map.get("icon");
            byte[] bytes = JsonImageAdapter.getbyte(icon);
            int user_id = Integer.parseInt((String)map.get("user_id"));
            uploadIcon(user_id,bytes,request);

        }

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

    public Map validateUsername(Map map){
        Login login = loginMapper.selectLogin(map);

        if(login !=null){
            throw new DefaultException(ResultCode.REPATE_THE_USERNAME,"重复的用户名");
        }

        String newPass = EncryptPass.encrypt((String)map.get("password"));          //加密

        map.put("password",newPass);

        return map;
    }

    private void uploadIcon(int user_id,byte[] bytes,HttpServletRequest request){
        logger.debug("DAO层调用:***上传文件***");
        String path = request.getServletContext().getRealPath("/icons/");
        String filename = user_id + "_icon";
        File filePath = new File(path, filename);

        if (!filePath.getParentFile().exists()) {
            filePath.getParentFile().mkdirs();
        }
        if(filePath.exists()){
            filePath.delete();
        }
        try {
            FileOutputStream outputStream = new FileOutputStream(filePath);
            outputStream.write(bytes);
            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            throw new DefaultException(ResultCode.UPLOAD_FAILD, "文件上传失败");
        }
        logger.debug("DAO层调用:***图片上传成功***");

    }
}
