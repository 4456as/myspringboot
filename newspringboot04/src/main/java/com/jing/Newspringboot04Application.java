package com.jing;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(value = "com.jing.mapper")
@SpringBootApplication
public class Newspringboot04Application {

    public static void main(String[] args) {
        SpringApplication.run(Newspringboot04Application.class, args);
    }

}
