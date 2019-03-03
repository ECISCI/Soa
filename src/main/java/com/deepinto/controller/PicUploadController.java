package com.deepinto.controller;

import com.deepinto.utils.FastDFSClient;
import com.deepinto.utils.JsonUtils;
import com.deepinto.utils.L;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

/**
 * 图片上传
 */
@Controller
public class PicUploadController {

    private String IMAGE_SERVER_URL = "http://192.168.25.133/";

    @RequestMapping(value = "/pic/upload", produces = org.springframework.http.MediaType.TEXT_PLAIN_VALUE + ";charset=utf-8")
    @ResponseBody
    public String uploadPic(MultipartFile uploadFile) {
        try {
            FastDFSClient client = new FastDFSClient("classpath:client.conf");

            // 取文件扩展名
            String originalFilename = uploadFile.getOriginalFilename();
            String extName = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);

            String url = client.uploadFile(uploadFile.getBytes(), extName);
            // 得到一个图片的地址和文件名
            // 补充为完整的url 封装到map中返回
            url = IMAGE_SERVER_URL + url;

            L.i("真实的图片url地址:" + url);

            Map<Object, Object> result = new HashMap();
            result.put("error", 0);
            result.put("url", url);
            String objectToJson = JsonUtils.objectToJson(result);
            return objectToJson;

        } catch (Exception e) {
            e.printStackTrace();

            Map<Object, Object> result = new HashMap();
            result.put("error", 1);
            result.put("message", "图片上传失败:" + e.getMessage());
            return JsonUtils.objectToJson(result);
        }
    }


}
