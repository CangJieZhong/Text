package Demo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;
import util.RedisUtils;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class Redis_jedisTest {
//	@Autowired
//	private JedisPool jedisPool;
//	@Autowired
//	private JedisCluster jedisCluster;
//	@Test
//	public void test1(){
//		Jedis jedis = jedisPool.getResource();
//		jedis.set("name", "张三");
//		System.out.println(jedis.get("name"));
//	}
//	
//	
//	@Test
//	public void test2(){
//		jedisCluster.set("name", "赵六");
//	}
//	@Test
//	public void test4(){
//		/**
//		 * 添加的是集群的每个节点的服务器的ip,端口号
//		 */
//		Set<HostAndPort>  set = new HashSet<>();
//		set.add(new HostAndPort("127.0.0.1", 6379));
//		set.add(new HostAndPort("127.0.0.1", 6380));
//		set.add(new HostAndPort("127.0.0.1", 6381));
//		set.add(new HostAndPort("127.0.0.1", 6382));
//		set.add(new HostAndPort("127.0.0.1", 6383));
//		set.add(new HostAndPort("127.0.0.1", 6384));
//		//创建集群
//		JedisCluster  jedisCluster  = new JedisCluster(set);
//		                         
//		jedisCluster.set("name", "list1");
//		
//		//  存,取, 删除, 改
//	}
	@Test
	public void test5(){
		RedisUtils.set("a1", "hello world!");
	}
}
