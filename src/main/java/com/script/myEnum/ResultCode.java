package com.script.myEnum;

public enum ResultCode {
    /**
     * 返回状态码
     */

    REGIST_SUCCESS(200),                   //注册成功


    LOGIN_SUCCESS(210),                    //登陆成功
    GETDATA_SUCCESS(211),                  //获取列表等数据成功


    DATAUPDATE_SUCCESS(220),               //用户信息更新成功


    /**
     * 异常信息码
     */

    NODATA_EXCEPTION(300),                 //未找到数据异常
    NOUSERNAME_EXCEPTION(301),             //未填写用户名异常
    NOPASSWORD_EXCEPTION(302),             //未填写密码异常
    NONICKNAME_EXCEPTION(303),             //未填写昵称异常
    NOPOSITION_EXCEPTION(304),              //未获取到位置信息异常
    NOLOGIN_EXCEPTION(305),                 //未登录异常
    NOLOGININFO_EXCEPTION(306),             //未提交登陆设备


    NORIGHTUSERNAME_EXCEPTION(310),       //不正确的用户名
    NORIGHTPASSWORD_EXCEPTION(311),       //不正确的密码


    PURVIEW_CER_EXCEPTION(320),             //权限验证异常


    REPATE_THE_USERNAME(330),               //重复的用户名






    NOREFER_USER_EXCEPTION(400),          //未关联到用户异常
    NOREFER_USERINFO_EXCEPTION(401),      //未关联到用户详细信息异常



    UNKNOW_EXCEPTION(-1);                  //未定义异常

    int code;

    ResultCode(int code){
        this.code = code;
    }
}
