package com.jing.config;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;
import java.util.Arrays;

//自定义指定key生成器
@Configuration
public class MyCacheConfig {
    @Bean("myKeyGenerator")
    public KeyGenerator keyGenerator(){
        return new KeyGenerator(){

            @Override
            public Object generate(Object o, Method method, Object... objects) {
                return method.getName()+"["+Arrays.asList(objects).toString()+"]";
            }
        };
    }
}
