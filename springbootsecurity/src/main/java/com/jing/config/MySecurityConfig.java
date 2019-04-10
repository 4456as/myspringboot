package com.jing.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity//自带@Configuration，不用加@Configuration了
public class MySecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //super.configure(http);
        //定制请求授权规则
        http.authorizeRequests().antMatchers("/").permitAll()
                .antMatchers("/level1/**").hasRole("VIP1")
                .antMatchers("/level2/**").hasRole("VIP2")
                .antMatchers("/level3/**").hasRole("VIP3");
        //开启自动配置登录功能
        //http.formLogin();// /login来到登录页     重定向到/login?error表示登陆失败
        //定制登录页
        http.formLogin().usernameParameter("user").passwordParameter("pwd")
                .loginPage("/userlogin");

        //开启自动配置的注销功能
        //http.logout();//访问/logout表示用户注销，清空session，返回login?logout
        //定制
        http.logout().logoutSuccessUrl("/");//注销后回首页


        //http.rememberMe();//cookie

        //定制
        http.rememberMe().rememberMeParameter("remember01");


    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //super.configure(auth);
        //定制认证规则

        //从内存中
        auth.inMemoryAuthentication()
                .withUser("zhangsan").password("123").roles("VIP1","VIP2")
                .and()
                .withUser("lisi").password("123").roles("VIP2","VIP3")
                .and()
                .withUser("wangwu").password("123").roles("VIP1","VIP3");
    }
}
