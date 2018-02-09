package com.script.myException;

import com.script.myEnum.ResultCode;
import com.script.myException.Exceptions.DefaultException;
import com.script.utils.resultType.Result;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@ResponseBody
public class ExceptionHandle {

    private static final Logger logger = Logger.getLogger(ExceptionHandle.class);

    @ExceptionHandler({Exception.class})
    public Result unknowException(Exception e){
         DefaultException defaultException =
                 new DefaultException(ResultCode.UNKNOW_EXCEPTION,"未知错误");
         Result result = new Result(defaultException.getErrorCode(),
                 defaultException.getMessage(),
                 null);
         return result;
    }
    @ExceptionHandler({DefaultException.class})
    public Result returnException(DefaultException e){

        logger.debug("throw Exception:"+e.getMessage());
        Result result = new Result(e.getErrorCode(),e.getMessage(),null);

        return result;
    }
}
