package org.jedis.web.bean;

import org.jedis.entity.Permit;
import org.jedis.service.impl.IUserService;
import org.jedis.utils.MyUtils;
import org.jedis.web.annocation.Module;
import org.jedis.web.annocation.Permissions;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/10/14.
 */
public class PermitBean implements InitializingBean {

    @Autowired
    private IUserService userService;

    public void init() {

        System.out.println("bean Init start...");

        List<Class> clazzs = MyUtils.getClasssFromPackage("org.jedis.web.controller");
        List<Permit> permits = new ArrayList<Permit>();
        Permit permit = null;
        for (Class c : clazzs) {
            Class<?> clazz = null;
            try {
                clazz = Class.forName(c.getName());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            Method[] methods = clazz.getMethods();
            Module module = clazz.getDeclaredAnnotation(Module.class);
            if (null != module) {
                for (Method method : methods) {
                    if (method.isAnnotationPresent(Permissions.class)) {
                        Permissions permissions = method.getDeclaredAnnotation(Permissions.class);
                        permit = new Permit();
                        permit.setModuleName(module.name());
                        permit.setModuleValue(module.value());
                        permit.setPermitName(permissions.name());
                        permit.setPermitValue(permissions.value());

                        permits.add(permit);
                    }
                }
            }
        }
        this.userService.savePermitList(permits);
        System.out.println("bean Init end...");
    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }


    public void destroy() {
        System.out.println("bean Init destory...");
    }

}
