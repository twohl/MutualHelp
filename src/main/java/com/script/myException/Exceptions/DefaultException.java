package com.script.myException.Exceptions;

import com.script.myEnum.ResultCode;

public class DefaultException extends RuntimeException {

    private ResultCode errorCode;
    private String message;

    public DefaultException(ResultCode errorCode,String message){
        this.errorCode = errorCode;
        this.message = message;
    }

    public ResultCode getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(ResultCode errorCode) {
        this.errorCode = errorCode;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
