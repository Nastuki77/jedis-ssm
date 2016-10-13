package org.jedis.dao;

import org.jedis.dao.impl.IuseDao;
import org.jedis.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Nastuki on 2016/10/8.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class TestDao {

    @Resource
    private IuseDao iuseDao;

    @Resource
    private RedisDao redisDao;

    @Test
    public void getUserById() throws Exception{
        Long id = 1L;
        User user = iuseDao.getUserById(id);
        if(user!=null){
            System.out.print("id:"+user.getId()+"   name:"+user.getUsername());
        }else{
            System.out.print("------------------");
        }

    }

    @Test
    public void getUsers() throws Exception{
        String name = "tom";
        List<User> user = iuseDao.getUsers(name);
        for(User u:user){
            System.out.println(u.toString());
        }
    }

    @Test
    public void redisTest(){
        redisDao.setJedis("NoSql","redis");
        String value = redisDao.getJedis("NoSql");
        System.out.println();
        System.out.println("value:  "+value);
    }

    @Test
    public void redisTest2(){
        String value = redisDao.getJedis("NoSql");
        System.out.println();
        System.out.println("value:  "+value);
    }

}
