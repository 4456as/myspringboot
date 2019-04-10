package com.jing;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot04taskApplicationTests {
    @Autowired
    JavaMailSenderImpl mailSender;
    @Test
    public void contextLoads() {
        //简单邮件
        SimpleMailMessage simpleMailMessage= new SimpleMailMessage();
        simpleMailMessage.setSubject("开会通知");
        simpleMailMessage.setText("今晚七点开会");
        simpleMailMessage.setTo("2802146854@qq.com");
        simpleMailMessage.setFrom("jinghuamuzhao@163.com");

        mailSender.send(simpleMailMessage);
    }
//复杂消息邮件
    public void test02() throws MessagingException {
        //
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);

        mimeMessageHelper.setSubject("开会通知");
        mimeMessageHelper.setText("<b style='color:red'>今晚七点开会</b>",true);
        mimeMessageHelper.setTo("2802146854@qq.com");
        mimeMessageHelper.setFrom("jinghuamuzhao@163.com");
        //上传文件
        mimeMessageHelper.addAttachment("1.jpg",new File("C:\\Users\\jingh\\Pictures\\IQIYISnapShot\\1.jpg"));
        mimeMessageHelper.addAttachment("2.jpg",new File("C:\\Users\\jingh\\Pictures\\IQIYISnapShot\\2.jpg"));
        mailSender.send(mimeMessage);
    }

}
