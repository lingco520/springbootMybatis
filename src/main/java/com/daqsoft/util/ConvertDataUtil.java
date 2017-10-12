package com.daqsoft.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ConvertDataUtil {

    /**
     * map转为json格式字符串
     * @param map
     * @return
     */
    public static String mapToJsonStr(Object map)
    {
        String result = "";
        if(map == null)
        {
            return result;
        }

        ObjectMapper mapper = new ObjectMapper();
        try {
            result = mapper.writeValueAsString(map);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 将json格式字符串转化为map
     * @param json
     * @return
     */
    public static Map<Object, Object> jsonstrToMap(String json)
    {
        Map<Object, Object> map = null;
        ObjectMapper mapper = new ObjectMapper();
        try {
            map = mapper.readValue(json, new TypeReference<TreeMap<String,String>>(){});
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 将json格式字符串转换为List
     * @param json
     * @return
     */
    public static List<Map<Object, Object>> jsonstrToList(String json)
    {
        List<Map<Object, Object>> map = null;
        ObjectMapper mapper = new ObjectMapper();
        try {
            map = mapper.readValue(json, new TypeReference<TreeMap<String,String>>(){});
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }

}
