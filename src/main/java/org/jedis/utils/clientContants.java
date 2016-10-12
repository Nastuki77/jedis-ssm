package org.jedis.utils;

import java.util.*;

/**
 * Created by Nastuki on 2016/10/9.
 */
public class clientContants {

    public static  Map<String, String> getAppConfigs() {

        Map<String,String> configMap = new HashMap<String, String>();
        ResourceBundle myConfig = ResourceBundle.getBundle("url");

        configMap.put("baseUrl",myConfig.getString("baseUrl"));
        configMap.put("jsUrl",myConfig.getString("jsUrl"));
        configMap.put("cssUrl",myConfig.getString("cssUrl"));
        configMap.put("imageUrl",myConfig.getString("imageUrl"));

        return configMap;
    }

}
