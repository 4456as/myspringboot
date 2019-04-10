package com.jing;

import com.jing.bean.Employee;
import com.jing.config.MyRedisConfig;
import com.jing.mapper.EmployeeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot01chacheApplicationTests {
    @Autowired
    EmployeeMapper employeeMapper;
    @Autowired
    RedisTemplate<Object,Employee> empRedisTemplate ;
    @Autowired
    StringRedisTemplate stringRedisTemplate;//操作k-v都是字符串的
    @Autowired
    RedisTemplate redisTemplate;//操作k-v都是对象的
    /*Redis五大数据类型 Stirng List Set集合 Hash散列 ZSet有序集合
    * */
    @Test
    public void test01(){
//        stringRedisTemplate.opsForValue().append("msg","hello");
//        String msg = stringRedisTemplate.opsForValue().get("msg");
//        System.out.println(msg);
        stringRedisTemplate.opsForList().leftPush("mylist","6");
        stringRedisTemplate.opsForList().leftPush("mylist","7");
        stringRedisTemplate.opsForList().leftPush("mylist","8");
        stringRedisTemplate.opsForList().leftPush("mylist","9");
    }
//测试保存对象
    @Test
    public void test02(){
        Employee employee = employeeMapper.getEmpById(101);
        //默认保存对象使用jdk序列化规则
        redisTemplate.opsForValue().set("emp-101",employee);
    }
    @Test
    public void test03(){
        Employee employee = employeeMapper.getEmpById(101);
        //使用自定义序列化规则
        empRedisTemplate.opsForValue().set("emp-101",employee);
    }
    @Test
    public void contextLoads() {
    }

}
