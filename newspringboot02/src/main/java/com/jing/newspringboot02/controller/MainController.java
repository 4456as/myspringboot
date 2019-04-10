package com.jing.newspringboot02.controller;

import com.jing.newspringboot02.exception.UserNotExistException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Map;


@Controller/*@Controller+@ResponseBody相当于RestController*/
//@RestController
public class MainController {

    @Value("${person.lastName}")
    private String name;

    @ResponseBody
    @RequestMapping("/sendToPage")
    public String sendToPage(@RequestParam String user) {
        if (user.equals("aaa")) {
            throw new UserNotExistException();
        }
        return "ok    " + name;
    }

    @RequestMapping("/gosuccess")
    public String success(Map<String, Object> map) {
        map.put("msg", "welcome");
        map.put("msg02", "<h2>欢迎</h2>");
        map.put("users", Arrays.asList("zhang1", "zhang2", "zhang3"));

//        classpath:/templates/success.html
        return "success";
    }
//作用相同 见MyMvcConfig
//    @RequestMapping({"/","/index"})//强制改变默认的index映射
//    public String index(){
//        return "index";//只会返回给/templates/文件夹下的 而不是其他静态资源文件下的
//    }

}
