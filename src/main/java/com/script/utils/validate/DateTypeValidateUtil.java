package com.script.utils.validate;

import com.script.myEnum.ResultCode;
import com.script.myException.Exceptions.DefaultException;

import java.text.SimpleDateFormat;
import java.util.Map;

public class DateTypeValidateUtil {

    public static void validateString(Map map, String name,String errorMessage){
        String var1 = (String) map.get(name);
        if(var1 == null || "".equals(var1)){
            throw new DefaultException(ResultCode.ERROR_DATA_NULL,errorMessage);
        }
    }

    public static void validateInteger(Map map, String name,String errorMessage,String errorFormatMessage){
        String var1 = (String) map.get(name);
        if(var1 == null || "".equals(var1)){
            throw new DefaultException(ResultCode.ERROR_DATA_NULL,errorMessage);
        }
        try{
            Integer.parseInt(var1);
        }catch(Exception e){
            throw new DefaultException(ResultCode.ERROR_INTEGER_FORMAT,errorFormatMessage);
        }
    }

    public static void validateDouble(Map map, String name,String errorMessage,String errorFormatMessage){
        String var1 = (String) map.get(name);
        if(var1 == null || "".equals(var1)){
            throw new DefaultException(ResultCode.ERROR_DATA_NULL,errorMessage);
        }
        try{
            Double.parseDouble(var1);
        }catch(Exception e){
            throw new DefaultException(ResultCode.ERROR_DOUBLE_FORMAT,errorFormatMessage);
        }
    }

    public static void validateDate(Map map, String name,String errorMessage,String errorFormatMessage){
        String var1 = (String) map.get(name);
        if(var1 == null || "".equals(var1)){
            throw new DefaultException(ResultCode.ERROR_DATA_NULL,errorMessage);
        }
        try{
            SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
            sdf.parse(var1);
        }catch(Exception e){
            throw new DefaultException(ResultCode.ERROR_DATE_FORMAT,errorFormatMessage);
        }
    }
}
