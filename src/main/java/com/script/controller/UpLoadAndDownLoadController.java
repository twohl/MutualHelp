package com.script.controller;

import com.script.myEnum.ResultCode;
import com.script.services.UploadAndDownloadServices;
import com.script.utils.resultType.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

import java.util.Map;

@RestController
public class UpLoadAndDownLoadController {

    @Autowired
    UploadAndDownloadServices services;

    @RequestMapping(value = "/upload/icon",method = RequestMethod.POST)
    public Result uploadIcon(HttpServletRequest request,
                             @RequestParam("icon")MultipartFile file,
                             @RequestParam("username")String username){

        services.uploadIcon(request,file,username);
        Result result = new Result(ResultCode.UPLOAD_SUCCESS,"文件上传成功",null);

        return result;
    }
    @RequestMapping(value = "/upload/imag",method = RequestMethod.POST)
    public Result uploadImage(HttpServletRequest request,
                              @RequestParam("image") MultipartFile file,
                              @RequestParam("shareId") int shareId){
        services.uploadImage(request,file,shareId);

        Result result = new Result(ResultCode.UPLOAD_SUCCESS,"文件上传成功",null);

        return result;
    }

    @RequestMapping(value = "/getIcon",method = RequestMethod.POST)
    public Result getIcon(HttpServletRequest request,@RequestBody Map map){

        byte[] icon = services.va_getIcon(request,map);

        Result result = new Result(ResultCode.GETDATA_SUCCESS,"头像获取成功",icon);
        return result;
    }

    @RequestMapping(value = "/getImage",method = RequestMethod.POST)
    public Result getImage(HttpServletRequest request,@RequestBody Map map){

        byte[]image = services.va_getImage(request,map);

        Result result = new Result(ResultCode.GETDATA_SUCCESS,"图片获取成功",image);
        return result;
    }
}
