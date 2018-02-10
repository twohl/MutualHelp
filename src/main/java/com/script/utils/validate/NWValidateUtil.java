package com.script.utils.validate;

import com.script.myEnum.ResultCode;
import com.script.myException.Exceptions.DefaultException;
import org.apache.log4j.Logger;

import java.util.Map;

import static com.script.utils.validate.DateTypeValidateUtil.*;

public class NWValidateUtil {
    private final static Logger logger = Logger.getLogger(NWValidateUtil.class);

    public static void validatePositionFormat(Map map){
        logger.debug("Util调用:***验证位置信息格式***");

        validateDouble(map,"lng","未获取到位置信息","错误的位置信息");

        validateDouble(map,"lat","未获取到位置信息","错误的位置信息");

        logger.debug("Util调用:***位置信息验证成功***");
    }


    public static void validateGetDate(Object obj){

        logger.debug("Util调用:***验证是否取得数据***");
        if(obj == null){
            throw new DefaultException(ResultCode.NODATAINDB_EXCEPTION,"取得数据为空");
        }
        logger.debug("Util调用:***成功取得数据***");
    }

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

        validateDouble(map,"lng","未获取到位置信息","错误的输入类型");

        validateDouble(map,"lat","未获取到位置信息","错误的输入类型");

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

        validateDouble(map,"price","没有定义报酬","错误的price");

        logger.debug("Util调用:***评价的格式正确***");
    }
}
