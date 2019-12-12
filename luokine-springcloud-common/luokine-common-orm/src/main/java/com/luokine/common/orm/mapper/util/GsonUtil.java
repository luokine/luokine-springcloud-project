package com.luokine.common.orm.mapper.util;



import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;
import java.util.Map;

public class GsonUtil {

    private GsonUtil() {
    }

    private static Gson gson = null;

    static {
        if (gson == null) {
            gson = new Gson();
        }
    }


    /**
     * 对象转成json
     * @param object
     * @return
     */
    public static String ObjectToString(Object object){
        String jsonString = null;
        if(gson != null){
            jsonString = gson.toJson(object);
        }
        return jsonString;
    }

    /**
     * 字符串转成bean
     * @param jsonString
     * @param classOfT
     * @param <T>
     * @return
     */
    public static <T> T GsonToBean(String jsonString , Class<T>  classOfT){
        T t = null;
        if (gson != null){
            t = gson.fromJson(jsonString, classOfT);
        }
        return t;
    }

    /**
     * json字符串转成map
     * @param gsonString
     * @param <T>
     * @return
     */
    public static <T> Map<String, T> GsonToMaps(String gsonString) {
        Map<String, T> map = null;
        if (gson != null) {
            map = gson.fromJson(gsonString, new TypeToken<Map<String, T>>() {
            }.getType());
        }
        return map;
    }

    /**
     * json字符串转成list
     * @param gsonString
     * @param cls
     * @param <T>
     * @return
     */
    public static <T> List<T> GsonToList(String gsonString, Class<T> cls) {
        List<T> list = null;
        if (gson != null) {
            list = gson.fromJson(gsonString, new TypeToken<List<T>>() {
            }.getType());
        }
        return list;
    }

    /**
     * json字符串转成list中有map的
     * @param gsonString
     * @param <T>
     * @return
     */
    public static <T> List<Map<String, T>> GsonToListMaps(String gsonString) {
        List<Map<String, T>> list = null;
        if (gson != null) {
            list = gson.fromJson(gsonString,
                    new TypeToken<List<Map<String, T>>>() {
                    }.getType());
        }
        return list;
    }

    /**
     * 将map转换成bean
     * @param map
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> String MapToGson(Map<String , Object> map ,T clazz){
        String jsonString = null;
        if(gson != null){
            jsonString = gson.toJson(map);
        }
        return jsonString;
    }
}

