package org.jedis.dao;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Created by Nastuki on 2016/10/8.
 */
public class RedisDao {

    private JedisPool jedisPool;

    public RedisDao(String ip, int port) {
        jedisPool = new JedisPool(ip, port);
    }


    public void setJedis(String key,String value){
        Jedis jedis = jedisPool.getResource();
        try{
            jedis.set(key,value);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            jedis.close();
        }
    }

    public String getJedis(String key){
        Jedis jedis = jedisPool.getResource();
        try{
            String value = jedis.get(key);
            return value;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            jedis.close();
        }
        return null;
    }

}
