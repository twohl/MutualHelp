package com.script.utils.adapter;

import com.script.myEnum.ResultCode;
import com.script.myException.Exceptions.DefaultException;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class JsonImageAdapter {

    public static String getString(byte[] data){
        String finalData=null;
        //压缩图片

        try {
            ByteArrayOutputStream bout = new ByteArrayOutputStream();
            GZIPOutputStream gzip = new GZIPOutputStream(bout);
            gzip.write(data);
            gzip.finish();
            gzip.close();
            finalData = bout.toString("ISO-8859-1");
            bout.close();
        } catch (Exception e) {
            throw new DefaultException(ResultCode.ERROR_DATE_FORMAT,"获取图片失败");
        }

        return finalData;
    }

    public static byte[] getbyte(String data){
        byte[] result = null;
        try {
            ByteArrayOutputStream bout = new ByteArrayOutputStream();
            byte[] buffer = data.getBytes("ISO-8859-1");
            ByteArrayInputStream bin = new ByteArrayInputStream(buffer);
            GZIPInputStream gzip = new GZIPInputStream(bin);
            byte[] bytes = new byte[2048];
            int ch = gzip.read(bytes);
            while(ch!=-1){
                bout.write(bytes,0,ch);
                ch = gzip.read(bytes);
            }
            gzip.close();
            bin.close();
            result = bout.toByteArray();
            bout.close();
        } catch (Exception e) {
            throw new DefaultException(ResultCode.ERROR_DATE_FORMAT,"上传图片失败");
        }
        return result;
    }
}
