package com.script.controller;


import com.script.entity.Share;
import com.script.myEnum.ResultCode;
import com.script.services.ShareServices;
import com.script.utils.resultType.Result;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/share",method = RequestMethod.POST)
public class ShareController {

    private static final Logger logger = Logger.getLogger(ShareController.class);

    @Autowired
    private ShareServices services;


    @RequestMapping(value = "/write",method = RequestMethod.PUT)
    public Result shareNearBy(HttpServletRequest request,@RequestBody Map map){

        logger.debug("controller层调用:***分享周边***");

         services.shareNearBy(request,map);

        Result result = new Result(ResultCode.SHARE_SUCCESS,"分享成功",null);
        logger.debug("controller层调用:***分享成功***");
        return result;
    }

    @RequestMapping(value = "/getList",method = RequestMethod.POST)
    public Result getShareNearBy(@RequestBody Map map){
        logger.debug("controller层调用:***获取周边的分享***");

        List list = services.getShareNearBy(map);

        Result result = new Result(ResultCode.GETDATA_SUCCESS,"获取列表成功",list);
        logger.debug("controller层调用:***获取分享成功***");
        return result;
    }

    @RequestMapping(value = "/shareInfo",method = RequestMethod.POST)
    public Result getShare(@RequestBody Map map){
        logger.debug("controller层调用:***获取分享的信息***");

        Share share= services.getShare(map);

        Result result = new Result(ResultCode.GETDATA_SUCCESS,"获取信息",share);
        logger.debug("controller层调用:***获取分享成功***");
        return result;
    }
}
