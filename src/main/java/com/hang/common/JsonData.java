package com.hang.common;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class JsonData {

    private boolean ret;

    private String msg;

    private Object data;

    public static JsonData success(){
        JsonData jsonData = new JsonData();
        jsonData.setRet(true);
        return jsonData;
    }

    public static JsonData success(String msg){
        JsonData jsonData = new JsonData();
        jsonData.setRet(true);
        jsonData.setMsg(msg);
        return jsonData;
    }

    public static JsonData success(Object data){
        JsonData jsonData = new JsonData();
        jsonData.setRet(true);
        jsonData.setData(data);
        return jsonData;
    }

    public static JsonData success(String msg,Object data){
        JsonData jsonData = new JsonData();
        jsonData.setRet(true);
        jsonData.setMsg(msg);
        jsonData.setData(data);
        return jsonData;
    }

    public static JsonData fail() {
        JsonData jsonData = new JsonData();
        jsonData.setRet(false);
        return jsonData;
    }

    public static JsonData fail(String msg){
        JsonData jsonData = new JsonData();
        jsonData.setRet(false);
        jsonData.setMsg(msg);
        return jsonData;
    }

    public static JsonData fail(Object data){
        JsonData jsonData = new JsonData();
        jsonData.setRet(false);
        jsonData.setData(data);
        return jsonData;
    }

    public static JsonData fail(String msg,Object data){
        JsonData jsonData = new JsonData();
        jsonData.setRet(false);
        jsonData.setData(data);
        jsonData.setMsg(msg);
        return jsonData;
    }

    public Map<String, Object> toMap() {
        Map<String,Object> map = new HashMap<>();
        map.put("ret",ret);
        map.put("data",data);
        map.put("msg",msg);
        return map;
    }
}