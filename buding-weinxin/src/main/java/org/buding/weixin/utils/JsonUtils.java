package org.buding.weixin.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: Administrator
 * \* Date: 2019/6/15 0015
 * \* Time: 13:39
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class JsonUtils {
    public static String toJson(Object obj){
        Gson gson=new GsonBuilder()
                .setPrettyPrinting()
                .create();
        return gson.toJson(obj);
    }
}
