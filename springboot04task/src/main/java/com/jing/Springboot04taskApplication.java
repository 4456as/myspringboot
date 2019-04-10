package com.jing;

import com.jing.service.ScheduledService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling//开启定时任务注解
@EnableAsync//开启Async注解
@SpringBootApplication
public class Springboot04taskApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot04taskApplication.class, args);

    }

}
