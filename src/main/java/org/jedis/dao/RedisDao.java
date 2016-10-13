package org.jedis.dao;

import com.dyuproject.protostuff.LinkedBuffer;
import com.dyuproject.protostuff.ProtostuffIOUtil;
import com.dyuproject.protostuff.runtime.RuntimeSchema;
import org.jedis.entity.Permit;
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

    private RuntimeSchema<Permit> schema = RuntimeSchema.createFrom(Permit.class);

    public Jedis getJedis(){
        Jedis jedis = jedisPool.getResource();
        return jedis;
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

    public Permit getSeckill(long seckillId) {
        // redis操作逻辑
        try {
            Jedis jedis = jedisPool.getResource();
            try {
                String key = "seckill:" + seckillId;
                // 并没有实现内部序列化操作
                // get -> byte[] -> 反序列化 -> object[Seckill]
                // 采用自定义序列化
                // protostuff : pojo.
                byte[] bytes = jedis.get(key.getBytes());
                if (bytes != null) {
                    Permit permit = schema.newMessage();
                    ProtostuffIOUtil.mergeFrom(bytes, permit, schema);
                    // seckill被反序列化
                    return permit;
                }
            } finally {
                jedis.close();
            }
        } catch (Exception e) {
            //logger.error(e.getMessage(), e);
        }
        return null;
    }

    public String putSeckill(Permit permit) {
        // set Object(Seckill) -> 序列号 -> byte[]
        try {
            Jedis jedis = jedisPool.getResource();
            try {
                String key = "permit";
                byte[] bytes = ProtostuffIOUtil.toByteArray(permit, schema,
                        LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE));
                // 超时缓存
                int timeout = 60 * 60;
                String result = jedis.setex(key.getBytes(), timeout, bytes);
                return result;
            } finally {
                jedis.close();
            }
        } catch (Exception e) {
            //logger.error(e.getMessage(), e);
        }
        return null;
    }

}
