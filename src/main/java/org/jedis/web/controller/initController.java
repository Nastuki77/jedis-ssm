package org.jedis.web.controller;

import org.jedis.dao.RedisDao;
import org.jedis.entity.Permit;
import org.jedis.utils.MyUtils;
import org.jedis.web.annocation.Module;
import org.jedis.web.annocation.Permissions;
import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Jedis;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/10/13.
 */
public class initController {

    @Autowired
    private RedisDao redisDao;

    public void inti() throws IOException {

        List<Class> clazzs = MyUtils.getClasssFromPackage("org.jedis.web.controller");
        System.out.println(clazzs.size());
        List<Permit> permits = new ArrayList<Permit>();
        Permit permit = null;
        Jedis jedis = redisDao.getJedis();
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = null;
        oos = new ObjectOutputStream(bos);

       /* System.out.println(" set object return \t" + setObjectRet);
        byte[] bs = redis.get("mingyuan".getBytes());
        ByteArrayInputStream bis = new ByteArrayInputStream(bs);
        ObjectInputStream inputStream = new ObjectInputStream(bis);
        Person readObject = (Person) inputStream.readObject();
        System.out.println(" read object \t" + readObject.toString());
        inputStream.close();
        bis.close();
        redis.disconnect();*/

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
                        permit = new Permit();
                        Permissions permissions = method.getDeclaredAnnotation(Permissions.class);
                        permit.setModuleName(module.name());
                        permit.setModuleValue(module.value());
                        permit.setPermitName(permissions.name());
                        permit.setPermitValue(permissions.value());
                        permits.add(permit);
                    }
                }
            }
            if (oos != null) {
                try {
                    oos.writeObject(permits);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            byte[] byteArray = bos.toByteArray();
            String setObjectRet = redisDao.getJedis().set("permit".getBytes(), byteArray);
        }

    }
}
