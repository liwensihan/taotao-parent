package test;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by lenovo on 2018-04-19.
 */
public class TestJedisCluster {
    public static void main(String[] args) {
        testJedisCluster();
    }
    public static void testJedisCluster(){
        //创建构造参数Set类型，集合中每个元素是HostAndPort类型
        Set<HostAndPort> nodes = new HashSet<>();
        //向集合中添加节点
        nodes.add(new HostAndPort("192.168.156.15", 6379));
        nodes.add(new HostAndPort("192.168.156.16", 6379));
        nodes.add(new HostAndPort("192.168.156.17", 6379));
        nodes.add(new HostAndPort("192.168.156.18", 6379));
        nodes.add(new HostAndPort("192.168.156.19", 6379));
        nodes.add(new HostAndPort("192.168.156.20", 6379));
        //创建JedisCluster对象
        JedisCluster jedisCluster = new JedisCluster(nodes);
        //直接使用jedisCluster，自带连接池，jedisCluster可以是单例的
        jedisCluster.set("jedis-cluster", "hello jedis cluster");
        String result = jedisCluster.get("jedis-cluster");
        System.out.println(result);
        //系统关闭前关闭jedisCluster
        jedisCluster.close();
    }
}
