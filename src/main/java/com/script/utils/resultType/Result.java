package com.script.utils.resultType;

import com.script.myEnum.ResultCode;

public class Result {
    private ResultCode code;
    private String message;
    private Object data;

    public Result(ResultCode code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
