package com.script.dao;

import com.script.entity.Share;
import com.script.mapper.ShareMapper;
import com.script.myEnum.ResultCode;
import com.script.myException.Exceptions.DefaultException;
import com.script.utils.adapter.JsonImageAdapter;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Repository
public class ShareDao {

    private static final Logger logger = Logger.getLogger(ShareDao.class);

    @Autowired
    private ShareMapper shareMapper;

    @Transactional
    public void shareNearBy(HttpServletRequest request,Map map){
        logger.debug("DAO层调用:***分享周边***");

        shareMapper.addShare(map);

        String image;

        if(map.get("image")!=null&&!"".equals(map.get("image"))){
            image = (String) map.get("image");
            byte[] bytes = JsonImageAdapter.getbyte(image);
            int share_id = Integer.parseInt((String)map.get("share_id"));
            uploadImage(share_id,bytes,request);

        }

        logger.debug("DAO层调用:***分享成功***");

    }

    public List getShareNearBy(Map map){
        logger.debug("DAO层调用:***获取周边的分享***");

        List list = shareMapper.selectShareByPosition(map);

        logger.debug("DAO层调用:***获取分享成功***");

        return list;
    }

    public Share getShare(Map map){

        logger.debug("services层调用:***获取分享的信息***");

        Share share= shareMapper.selectShareById(map);

        logger.debug("services层调用:***获取分享成功***");

        return share;
    }

    private void uploadImage(int share_id, byte[] bytes, HttpServletRequest request){
        logger.debug("DAO层调用:***上传文件***");
        String path = request.getServletContext().getRealPath("/images/");
        String filename = share_id + "_image";
        File filePath = new File(path, filename);

        if (!filePath.getParentFile().exists()) {
            filePath.getParentFile().mkdirs();
        }
        if(filePath.exists()){
            filePath.delete();
        }
        try {
            FileOutputStream outputStream = new FileOutputStream(filePath);
            outputStream.write(bytes);
            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            throw new DefaultException(ResultCode.UPLOAD_FAILD, "文件上传失败");
        }
        logger.debug("DAO层调用:***图片上传成功***");

    }
}
