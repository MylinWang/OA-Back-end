package com.gelin.oa.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.text.SimpleDateFormat;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TimeZone;

public class ResponseUtil {
    private String code;
    private String message;
    private Map data=new LinkedHashMap();




    public ResponseUtil() {
        this.code="0";
        this.message="登录成功";
    }

    public  ResponseUtil(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public  ResponseUtil put(String key,Object value){
        this.data.put(key,value);
        return this;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map getData() {
        return data;
    }

    public void setData(Map data) {
        this.data = data;
    }

    public String toJsonString(){
        ObjectMapper objectMapper=new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        try {
            String string = objectMapper.writeValueAsString(this);
            return string;
        } catch (JsonProcessingException e) {
            throw  new RuntimeException(e);
        }
    }

}
