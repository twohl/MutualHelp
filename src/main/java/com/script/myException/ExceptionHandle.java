package com.script.advices;

import com.script.myException.DefaultException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@ResponseBody
public class ExceptionHandle {

    @ExceptionHandler({Exception.class})
    public DefaultException UnknowException(Exception e){
         DefaultException defaultException =
                 new DefaultException(-1,"未知错误");

         return defaultException;
    }
}
