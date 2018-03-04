package com.script.utils.validate;

import com.script.myEnum.ResultCode;
import com.script.myException.Exceptions.DefaultException;
import org.apache.log4j.Logger;

import java.util.Map;

import static com.script.utils.validate.DateTypeValidateUtil.*;

public class NWValidateUtil {
    private final static Logger logger = Logger.getLogger(NWValidateUtil.class);

    public static void validateEditFormat(Map map){
        logger.debug("Util调用:***验证编辑NW的格式***");

        validateInteger(map,"nw_id","未获取到notWork ID","错误的ID格式");

        validateString(map,"name","未填写notWork名称");

        validateString(map,"content","未填写notWork具体内容");

        logger.debug("Util调用:***NW编辑格式正确***");
    }
    public static void validateNWFormat(Map map){

        logger.debug("Util调用:***验证发布NW的格式***");

        validateString(map,"name","未填写notWork名称");

        validateString(map,"content","未填写notWork内容");

        validatePosition(map);

        validateString(map,"price","没有定义报酬");

        logger.debug("Util调用:***NW发布格式正确***");

    }

    public static void validateGetOrAccFormat(Map map){

        logger.debug("Util调用:***验证接取NW的格式***");

        validateInteger(map,"nw_id","未填写notWork Id","错误的notWork ID");

        logger.debug("Util调用:***接取NW的格式正确***");
    }

    public static void validateCancleFormat(Map map){
        logger.debug("Util调用:***验证取消NW的格式***");

        validateInteger(map,"nw_id","未填写notWork Id","错误的notWork ID");

        logger.debug("Util调用:***取消NW的格式正确***");

    }

    public static void validateEvaluateNWFormat(Map map){
        logger.debug("Util调用:***验证评价的格式***");

        validateInteger(map,"nw_id","未填写notWork Id","错误的notWork ID");

        validateInteger(map,"user_id","未正确找到该用户，更新失败","错误的User ID");

        validateString(map,"content","未填写评价内容");

        validateInteger(map,"target_id","没有接取不能评价","错误的User ID");

        logger.debug("Util调用:***评价的格式正确***");
    }
}
