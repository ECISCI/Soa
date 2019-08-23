package com.deepinto.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.Serializable;
import java.util.List;

/**
 * @author Ming
 * @描述 快速响应给客户端Json数据工具类
 */
public class MsResult implements Serializable {

    private static final long serialVersionUID = 1L;

    // 定义jackson对象
    private static final ObjectMapper MAPPER = new ObjectMapper();

    // 响应业务状态
    private Integer status;

    // 响应消息
    private String msg;

    // 响应中的数据
    private Object data;

    // 构造函数
    public MsResult() {

    }

    public static MsResult build(Integer status, String msg, Object data) {
        return new MsResult(status, msg, data);
    }

    public static MsResult build(Integer status, String msg) {
        return new MsResult(status, msg, null);
    }

    /**
     * 成功响应,响应数据集合为null
     */
    public static MsResult ok() {
        return new MsResult(null);
    }

    /**
     * 成功响应,响应成功码,成功信息,数据集合
     *
     * @param data 数据集合
     */
    public static MsResult ok(Object data) {
        return new MsResult(data);
    }

    /**
     * 请求成功响应,但不返回数据集合
     *
     * @param status 成功码
     * @param msg    成功信息
     */
    public static MsResult ok(int status, String msg) {
        return new MsResult(status, msg);
    }

    /**
     * 服务器内部异常响应
     *
     * @param e 错误信息
     * @return
     */
    public static MsResult fail(Exception e) {

        return new MsResult(500, e.toString());
    }

    /**
     * 请求失败响应,错误码,错误信息
     *
     * @param status
     * @param msg
     * @return
     */
    public static MsResult fail(int status, String msg) {
        return new MsResult(status, msg);
    }


    public MsResult(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public MsResult(Object data) {
        this.status = 200;
        this.msg = "OK";
        this.data = data;
    }

    public MsResult(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    /**
     * 将json结果集转化为对象
     *
     * @param jsonData json数据
     * @param clazz    BootResult中的object类型
     * @return
     */
    public static MsResult formatToPojo(String jsonData, Class<?> clazz) {
        try {
            if (clazz == null) {
                return MAPPER.readValue(jsonData, MsResult.class);
            }
            JsonNode jsonNode = MAPPER.readTree(jsonData);
            JsonNode data = jsonNode.get("data");
            Object obj = null;
            if (clazz != null) {
                if (data.isObject()) {
                    obj = MAPPER.readValue(data.traverse(), clazz);
                } else if (data.isTextual()) {
                    obj = MAPPER.readValue(data.asText(), clazz);
                }
            }
            return build(jsonNode.get("status").intValue(), jsonNode.get("msg").asText(), obj);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 没有object对象的转化
     *
     * @param json
     * @return
     */
    public static MsResult format(String json) {
        try {
            return MAPPER.readValue(json, MsResult.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Object是集合转化
     *
     * @param jsonData json数据
     * @param clazz    集合中的类型
     * @return
     */
    public static MsResult formatToList(String jsonData, Class<?> clazz) {
        try {
            JsonNode jsonNode = MAPPER.readTree(jsonData);
            JsonNode data = jsonNode.get("data");
            Object obj = null;
            if (data.isArray() && data.size() > 0) {
                obj = MAPPER.readValue(data.traverse(),
                        MAPPER.getTypeFactory().constructCollectionType(List.class, clazz));
            }
            return build(jsonNode.get("status").intValue(), jsonNode.get("msg").asText(), obj);
        } catch (Exception e) {
            return null;
        }
    }

}
