package com.jing;

import com.jing.bean.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot02amqpApplicationTests {
    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    AmqpAdmin amqpAdmin;//用于管理exchange,queue,binding

    @Test
    public void contextLoads() {
    }
//点对点
    @Test
    public void testDirect(){
        Map<String,Object> map = new HashMap<>();
        map.put("msg","first message");
        map.put("data",Arrays.asList("helloworld",123,true));
        //默认使用SimpleMessageConverter，内部是jdk的序列化
        //rabbitTemplate.convertAndSend("exchange.direct","atguigu.news",map);
        rabbitTemplate.convertAndSend("exchange.direct","atguigu.news",new Book("aaaa","bbb"));
     }
     @Test
    public void testReceive(){
        Object object = rabbitTemplate.receiveAndConvert("atguigu.news");
         System.out.println("-----"+object.getClass());
         System.out.println("-----"+object);
     }
//广播
     @Test
    public void testFanout(){
        rabbitTemplate.convertAndSend("exchange.fanout","",new Book("cccc","bbb"));
     }


//amqpAdmin
    @Test
    public void createExchange(){
        amqpAdmin.declareExchange(new DirectExchange("admin.exchange"));
        System.out.println("--done--admin.exchange");
    }
    @Test
    public void createQueue(){
        amqpAdmin.declareQueue(new Queue("admin.queue",true));
        System.out.println("--done--admin.queue");
    }
    @Test
    public void createBingding(){
        amqpAdmin.declareBinding(new Binding("admin.queue",
                Binding.DestinationType.QUEUE,"admin.exchange",
                "admin.queue",null));
        System.out.println("--done--admin.queue");
    }

}
