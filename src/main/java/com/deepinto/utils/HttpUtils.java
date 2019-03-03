package com.deepinto.utils;

import com.alibaba.fastjson.JSONObject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author Ming
 * @描述 Http请求及响应工具类  针对移动端json数据交互
 */
public class HttpUtils {

    /**
     * @return 请求参数封装成Json数据
     * @描述 获取请求参数
     */
    public static String getPotJsonParam(HttpServletRequest request) throws Exception {

        String param = null;
        try {
            BufferedReader streamReader = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"));
            StringBuilder responseStrBuilder = new StringBuilder();
            String inputStr;
            while ((inputStr = streamReader.readLine()) != null)
                responseStrBuilder.append(inputStr);

            JSONObject jsonObject = JSONObject.parseObject(responseStrBuilder.toString());
            param = jsonObject.toJSONString();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return param;

    }

    /**
     * @描述 向客户端响应Json数据
     */
    public static void responseWrite(HttpServletResponse response, String json) throws Exception {

        response.setContentType("type=text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }
}
