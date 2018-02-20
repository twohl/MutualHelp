package com.script.utils.validate;

import org.apache.log4j.Logger;

import java.util.Map;

import static com.script.utils.validate.DateTypeValidateUtil.*;

public class ShareValidateUtil {
    private final static Logger logger = Logger.getLogger(ShareValidateUtil.class);


    public static void validateShare(Map map){
        logger.debug("Util调用:***验证Share格式***");

        validateString(map,"title","未填写分享名称");

        validatePosition(map);

        validateString(map,"content","未填写分享内容");

        logger.debug("Util调用:***Share格式验证成功***");

    }

    public static void validateGetShare(Map map){
        logger.debug("Util调用:***验证获取Share格式***");

        validateInteger(map,"share_id","未获取到id","错误的ID格式");

        logger.debug("Util调用:***获取Share格式验证成功***");

    }

}
