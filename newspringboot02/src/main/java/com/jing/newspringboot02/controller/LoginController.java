package com.jing.newspringboot02.controller;

import javafx.beans.binding.ObjectExpression;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {
    //    @DeleteMapping
//    @GetMapping
//    @PostMapping
    @RequestMapping(value = "/user/login", method = RequestMethod.POST)
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String, Object> map, HttpSession session) {
        if (!StringUtils.isEmpty(username) && "123456".equals(password)) {
            session.setAttribute("loginuser", username);
            return "redirect:/vice-dashboard.html";//避免表单重复提交
        } else {
            map.put("msgerror", "用户名或密码错误");
            return "index";
        }
    }
}
