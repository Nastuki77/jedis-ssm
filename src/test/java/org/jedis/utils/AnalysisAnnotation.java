package org.jedis.utils;

import org.jedis.entity.Allows;
import org.jedis.web.annocation.Module;
import org.jedis.web.annocation.Permissions;
import org.junit.Test;
import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Controller;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nastuki on 2016/10/13.
 */
public class AnalysisAnnotation {
    @Test
    public void getAnnotation() throws Exception{
        List<Class> clazzs =  MyUtils.getClasssFromPackage("org.jedis.web.controller");
        System.out.println(clazzs.size());
        List<Allows> Allows = new ArrayList<Allows>();
        for(Class c : clazzs){
            Class<?> clazz = Class.forName(c.getName());
            Method[] methods = clazz.getMethods();
            boolean permissionsExist =  clazz.isAnnotationPresent(Controller.class);
            Module module = clazz.getDeclaredAnnotation(Module.class);
            if(null!=module){
                System.out.println(c.getName()+": Module --->"+module.value()+"    "+module.name());
                for (Method method : methods){
                    if(method.isAnnotationPresent(Permissions.class)){
                        Permissions permissions = method.getDeclaredAnnotation(Permissions.class);
                        System.out.println(c.getName()+": permissions --->"+permissions.value()+"    "+permissions.name());
                        Allows.add(new Allows(module.name()+"-"+module.value(),permissions.name()+"-"+permissions.value()));
                    }
                }
            }
        }
    }
}
