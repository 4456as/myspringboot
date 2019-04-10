package com.jing.newspringboot02;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;


//@ImportResource(locations = {"classpath:beans.xml"})不推荐
@SpringBootApplication
public class Newspringboot02Application {

    public static void main(String[] args) {

        SpringApplication.run(Newspringboot02Application.class, args);
        Logger logger = LoggerFactory.getLogger(Newspringboot02Application.class);
        logger.info("logbackinfo");
    }

}
