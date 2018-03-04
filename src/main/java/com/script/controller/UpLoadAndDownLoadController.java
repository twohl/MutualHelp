package com.script.controller;

import com.script.myEnum.ResultCode;
import com.script.services.UploadAndDownloadServices;
import com.script.utils.adapter.JsonImageAdapter;
import com.script.utils.resultType.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UpLoadAndDownLoadController {

    @Autowired
    UploadAndDownloadServices services;

    @RequestMapping(value = "/getIcon/{user_id}",method = RequestMethod.POST)
    public Result getIcon(HttpServletRequest request,@PathVariable int user_id){

        byte[] icon = services.getIcon(request,user_id);

        String data = icon == null ?null:JsonImageAdapter.getString(icon);

        Result result = new Result(ResultCode.GETDATA_SUCCESS,"头像获取成功",data);
        return result;
    }

    @RequestMapping(value = "/getImage/{share_id}",method = RequestMethod.POST)
    public Result getImage(HttpServletRequest request,@PathVariable int share_id){

        byte[]image = services.getImage(request,share_id);

        String data = image == null ?null:JsonImageAdapter.getString(image);
        Result result = new Result(ResultCode.GETDATA_SUCCESS,"图片获取成功",data);
        return result;
    }
}
