package com.jing.service;

import com.jing.bean.Book;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    @RabbitListener(queues = "atguigu.news")//监听消息队列
    public void receive(Book book){
        System.out.println("gotten message----"+book);
    }
    @RabbitListener(queues="atguigu")
    public void receive02(Message message){//监听   获取消息头信息
        System.out.println(message.getBody());
        System.out.println(message.getMessageProperties());
    }
}
