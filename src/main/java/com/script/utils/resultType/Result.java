package com.script.utils.resultType;

import com.script.myEnum.ResultCode;

public class Result {
    private ResultCode code;
    private String message;
    private Object date;

    public Result(ResultCode code, String message, Object date) {
        this.code = code;
        this.message = message;
        this.date = date;
    }

    public ResultCode getCode() {
        return code;
    }

    public void setCode(ResultCode code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getDate() {
        return date;
    }

    public void setDate(Object date) {
        this.date = date;
    }
}
