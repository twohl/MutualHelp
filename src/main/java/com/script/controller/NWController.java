package com.script.controller;

import com.script.entity.NotWork;
import com.script.myEnum.ResultCode;
import com.script.services.NWServices;
import com.script.utils.resultType.Result;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/nw")
public class NWController {

    private static final Logger logger = Logger.getLogger(NWController.class);

    @Autowired
    private NWServices services;

    @RequestMapping(value = "/publish",method = RequestMethod.PUT)
    public Result publishNW(@RequestBody Map map){

        logger.debug("controller层调用:***发布一个notwork***");

        services.va_publishNW(map);

        Result result = new Result(ResultCode.NWPUBLISH_SUCCESS,"发布成功",null);
        logger.debug("controller层调用:***notwork发布成功***");
        return result;
    }

    @RequestMapping(value = "/acc",method = RequestMethod.POST)
    public Result accNW(@RequestBody Map map){

        logger.debug("controller层调用:***接受notWork***");

        services.va_accNW(map);

        logger.debug("controller层调用:***成功接取notWork***");

        Result result = new Result(ResultCode.NWACC_SUCCESS,"接取成功",null);
        return result;
    }

    @RequestMapping(value = "/cancle",method = RequestMethod.POST)
    public Result cancleNW(@RequestBody Map map){

        logger.debug("controller层调用:***取消notWork***");

        services.va_cancleNW(map);

        logger.debug("controller层调用:***成功取消notWork***");

        Result result = new Result(ResultCode.NWCANCLE_SUCCESS,"取消成功",null);
        return result;
    }

    @RequestMapping(value = "/complite",method = RequestMethod.POST)
    public Result compliteNW(@RequestBody Map map){

        logger.debug("controller层调用:***完成notWork***");

        services.va_compliteNW(map);

        logger.debug("controller层调用:***成功完成notWork***");

        Result result = new Result(ResultCode.NWCANCLE_SUCCESS,"完成NotWork",null);
        return result;
    }

    @RequestMapping(value = "/evaluate")
    public Result evaluateNW(@RequestBody Map map){

        logger.debug("controller层调用:***评价完成的NW***");

        services.va_evaluateNW(map);

        logger.debug("controller层调用:***评价成功***");

        Result result = new Result(ResultCode.EVALUATE_SUCCESS,"评价成功",null);
        return result;
    }

    @RequestMapping(value = "/nwList",method = RequestMethod.POST)
    public Result getNWList(@RequestBody Map map){

        logger.debug("controller层调用:***获取nw列表***");
        List list = services.va_getNWList(map);
        Result result = new Result(ResultCode.GETDATA_SUCCESS,"获取列表成功",list);
        logger.debug("controller层调用:***获取nw列表成功***");
        return result;
    }

    @RequestMapping(value = "/nwInfo",method = RequestMethod.POST)
    public Result getNW(@RequestBody Map map){
        logger.debug("controller层调用:***获取nw详细信息***");
        NotWork notWork = services.va_getNW(map);
        Result result = new Result(ResultCode.GETDATA_SUCCESS,"获取信息成功",notWork);
        logger.debug("controller层调用:***获取nw信息成功***");
        return result;
    }

    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    public Result editNW(@RequestBody Map map){
        logger.debug("controller层调用:***修改nw信息***");

        services.va_editNW(map);

        logger.debug("controller层调用:***nw信息修改成功***");

        Result result = new Result(ResultCode.DATAUPDATE_SUCCESS,"信息修改成功",null);

        return result;
    }
    @RequestMapping(value = "/getUserNW",method = RequestMethod.POST)
    public Result getUserNW(@RequestBody Map map){
        logger.debug("controller层调用:***拉取nw信息***");

        List list = services.va_getUserNW(map);

        logger.debug("controller层调用:***nw信息拉取成功***");

        Result result = new Result(ResultCode.GETDATA_SUCCESS,"拉取信息成功",list);

        return result;
    }
}
