package org.jedis.web.controller;

import org.jedis.entity.Permit;
import org.jedis.service.impl.IuserService;
import org.jedis.utils.MyUtils;
import org.jedis.web.annocation.Module;
import org.jedis.web.annocation.Permissions;
import org.springframework.beans.factory.annotation.Autowired;


import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nastuki on 2016/10/13.
 */

public  class initUtils {
/*
    @Autowired
    private IuserService userService;

    public void inits(){
        System.out.println("权限配置初始化开始...");

        List<Class> clazzs =  MyUtils.getClasssFromPackage("org.jedis.web.controller");
        System.out.println(clazzs.size());
        List<Permit> permits = new ArrayList<Permit>();

        for(Class c : clazzs){
            Class<?> clazz = null;
            try {
                clazz = Class.forName(c.getName());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            Method[] methods = clazz.getMethods();
            Module module = clazz.getDeclaredAnnotation(Module.class);
            if(null!=module){
                for (Method method : methods){
                    if(method.isAnnotationPresent(Permissions.class)){
                        Permissions permissions = method.getDeclaredAnnotation(Permissions.class);
                        this.userService.getPermitDao().savePermit(
                                module.name(),module.value(),permissions.name(),permissions.value());
                    }
                }
            }
        }

        System.out.println("权限配置初始化完成...");
    }*/

}
