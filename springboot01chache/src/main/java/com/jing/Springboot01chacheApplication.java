package com.jing;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@MapperScan("com.jing.mapper")
@SpringBootApplication
@EnableCaching//开启缓存
public class Springboot01chacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot01chacheApplication.class, args);
    }

}
