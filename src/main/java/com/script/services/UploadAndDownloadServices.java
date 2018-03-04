package com.script.services;

import com.script.myEnum.ResultCode;
import com.script.myException.Exceptions.DefaultException;
import com.script.utils.resultType.Result;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.Map;

@Service
public class UploadAndDownloadServices {

    public void va_uploadIcon(Map map){

        HttpServletRequest request = (HttpServletRequest) map.get("request");
        MultipartFile file = (MultipartFile) map.get("file");
        String user_id = (String) map.get("user_id");

        String path = request.getServletContext().getRealPath("/icons/");
        if(!file.isEmpty()){
            String filename = user_id+"_icon";
            File filePath = new File(path,filename);

            if(!filePath.getParentFile().exists()){
                filePath.getParentFile().mkdirs();
            }
            if(filePath.exists()){
                filePath.delete();
            }
            try {
                file.transferTo(new File(path+File.separator+filename));
            } catch (IOException e) {
                throw new DefaultException(ResultCode.UPLOAD_FAILD,"文件上传失败");
            }
        }
    }

    public void va_uploadImage(Map map) {

        HttpServletRequest request = (HttpServletRequest) map.get("request");
        MultipartFile file = (MultipartFile) map.get("file");
        String shareId = (String) map.get("shareId");

        String path = request.getServletContext().getRealPath("/images/");
        if (!file.isEmpty()) {
            String filename = shareId + "_image";
            File filePath = new File(path, filename);

            if (!filePath.getParentFile().exists()) {
                filePath.getParentFile().mkdirs();
            }
            if(filePath.exists()){
                filePath.delete();
            }
            try {
                file.transferTo(new File(path + File.separator + filename));
            } catch (IOException e) {
                throw new DefaultException(ResultCode.UPLOAD_FAILD, "文件上传失败");
            }
        }
    }
    public byte[] getIcon(HttpServletRequest request,int user_id){


        String path = request.getServletContext().getRealPath("/icons/");
        String filename = user_id+"_icon";
        File file = new File(path,filename);
        if(!file.exists()){
            return null;
        }
        byte[] icon;
        try {
             FileInputStream in = new FileInputStream(file);
             ByteArrayOutputStream out = new ByteArrayOutputStream();
             byte[] bb = new byte[2048];
             int ch;
             ch = in.read(bb);
             while(ch!=-1){
                 out.write(bb,0,ch);
                 ch = in.read(bb);
             }
             icon = out.toByteArray();
        } catch (Exception e) {
            throw new DefaultException(ResultCode.ERROR_DATA_NULL,"没有用户头像");
        }
        return icon;
    }

    public byte[] getImage(HttpServletRequest request,int share_id){
        String path = request.getServletContext().getRealPath("/images/");
        String filename = share_id+"_image";
        File file = new File(path,filename);
        if(!file.exists()){
            return null;
        }
        byte[] image;
        try {
            FileInputStream in = new FileInputStream(file);
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            byte[] bb = new byte[2048];
            int ch;
            ch = in.read(bb);
            while(ch!=-1){
                out.write(bb,0,ch);
                ch = in.read(bb);
            }
            image = out.toByteArray();
        } catch (Exception e) {
            throw new DefaultException(ResultCode.ERROR_DATA_NULL,"未获取到图片");
        }
        return image;

    }
}
