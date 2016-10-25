package com.jack.json.service;

import java.util.ResourceBundle;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisHelper
{
    private static JedisPool pool = null;
    
    public static String get(String key)
    {
      if (key == null)
      {
        return null;
      }
      Jedis jedis = null;
      String value = null;
      try
      {
        jedis = pool.getResource();
        value = jedis.get(key);
      }
      catch (Exception e)
      {
        pool.returnBrokenResource(jedis);
        //logger.error("RedisHelper get:" + e.toString());
      }
      finally
      {
        returnResource(pool, jedis);
      }
      return value;
    }
    
    public static String set(String key, String value)
    {
      Jedis jedis = null;
      if ((key == null) || (value == null))
      {
        //logger.info("RedisHelper null -- key====" + key + " and value===" + value);
        return null;
      }
      try
      {
        jedis = pool.getResource();
        String str = jedis.set(key, value);
        return str;
      }
      catch (Exception e)
      {
        pool.returnBrokenResource(jedis);
        //logger.error("RedisHelper set:" + e.toString());
        return "0";
      }
      finally
      {
        returnResource(pool, jedis);
      }
    }
    
    public static String setex(String key,int timeout, String value)
    {
      Jedis jedis = null;
      if ((key == null) || (value == null))
      {
        //logger.info("null -- key====" + key + " and value===" + value);
        return null;
      }
      try
      {
        jedis = pool.getResource();
        String str = jedis.setex(key, timeout,value);
        return str;
      }
      catch (Exception e)
      {
        pool.returnBrokenResource(jedis);
        //logger.error("RedisHelper setex:" + e.toString());
        return "0";
      }
      finally
      {
        returnResource(pool, jedis);
      }
    }
    
    
	public static JedisPool getPool() {
		return pool;
	}
	public static void setPool(JedisPool pool) {
		RedisHelper.pool = pool;
	}
	
	private static ResourceBundle bundle = ResourceBundle.getBundle("redis_config");
	
    //private static Logger logger = LoggerFactory.getLogger(RedisHelper.class);
    
    static
    {
		try {
			JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
			// 属性文件读取参数信息
			String[] hostArray = bundle.getString("redis.host").split(",");
			String host     = hostArray[0];
			int port        = Integer.valueOf(bundle.getString("redis.port"));
			int timeout     = Integer.valueOf(bundle.getString("redis.timeout"));
			int maxClient   = Integer.valueOf(bundle.getString("redis.maxclient"));
			String password = bundle.getString("redis.password");
			jedisPoolConfig.setMaxTotal(maxClient);

			jedisPoolConfig.setMaxWaitMillis(10000);
			// 在borrow一个jedis实例时，是否提前进行alidate操作；如果为true，则得到的jedis实例均是可用的；
			jedisPoolConfig.setTestOnBorrow(true);
			// 在还会给pool时，是否提前进行validate操作
			jedisPoolConfig.setTestOnReturn(true);
			if (!"".equals(password)) {
				pool = new JedisPool(jedisPoolConfig, host, port, timeout, password);
			} else {
				pool = new JedisPool(jedisPoolConfig, host, port, timeout);
			}
			
		} catch (Exception ex) {
			//logger.error("RedisHelper redis init failed",ex);
		}
    }
    
    public static void returnResource(JedisPool pool, Jedis jedis)
    {
      if (jedis != null)
      {
        pool.returnResource(jedis);
      }
    }
}