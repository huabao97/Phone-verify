package com.example.redisdemo1;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Set;

@SpringBootTest
class RedisDemo1ApplicationTests {

    @Test
    void contextLoads() {
        Jedis jedis=new Jedis("192.168.217.128",6379);
        String pong=jedis.ping();
        System.out.println(pong);
        jedis.close();
    }

    @Test
    void contextLoads1() {
        Jedis jedis=new Jedis("192.168.217.128",6379);
        jedis.set("k1","v1");
        jedis.set("k2","v2");
        Set<String> keys=jedis.keys("*");
        for(String key:keys){
            System.out.println(key);
        }
        System.out.println(jedis.exists("k1"));
        System.out.println(jedis.ttl("k1"));
        System.out.println(jedis.get("k1"));
        jedis.close();
    }

    @Test
    void contextLoads2() {
        Jedis jedis=new Jedis("192.168.217.128",6379);
        jedis.mset("str1","v1","str2","v2","str3","v3");
        System.out.println(jedis.mget("str1","str2","str3"));
        jedis.close();
    }

    @Test
    void contextLoads3() {
        Jedis jedis=new Jedis("192.168.217.128",6379);
        List<String> list=jedis.lrange("mylist",0,-1);
        for(String elem:list){
            System.out.println(elem);
        }
        jedis.close();
    }


}
