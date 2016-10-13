package org.jedis.service;

import org.jedis.entity.Permit;
import org.jedis.service.impl.IUserService;
import org.jedis.utils.MyUtils;
import org.jedis.web.annocation.Module;
import org.jedis.web.annocation.Permissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/10/13.
 */
@Repository
public class ApplicationListenerImpl implements ApplicationListener {

    @Autowired
    private IUserService userService;

    public IUserService getUserService() {
        return userService;
    }

    public void setUserService(IUserService userService) {
        this.userService = userService;
    }

    @Override
    public void onApplicationEvent(ApplicationEvent arg0) {

/*
        System.out.println("权限配置初始化开始...");

        List<Class> clazzs = MyUtils.getClasssFromPackage("org.jedis.web.controller");
        System.out.println(clazzs.size());
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
                        System.out.print(permissions.name() + "  " + permissions.value() +
                                "  " + module.name() + "  " + module.value());

                        permit.setModuleName(module.name());
                        permit.setModuleValue(module.value());
                        permit.setPermitName(permissions.name());
                        permit.setPermitValue(permissions.value());
                        permits.add(permit);

                        this.userService.getPermitDao().savePermit(module.name(), module.value(), permissions.name(), permissions.value());
                    }
                }
            }
        }

        System.out.println("权限配置初始化完成...");*/
    }
}
