package redisdemo;

/**
 * @author CBeann
 * @create 2020-03-25 0:06
 */

import redis.clients.jedis.Jedis;

public class MyRedis {

    public static void main(String args[]) {
        // 连接redis服务
        Jedis jedis = new Jedis("39.105.30.146", 6379);
        jedis.auth("123456");
        // 查看服务是否运行
        System.out.println("Server is running: " + jedis.ping());

        String name=jedis.get("name");
        System.out.println(name);


    }

}