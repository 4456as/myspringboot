package com.jing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class MainController {
    @ResponseBody
    @RequestMapping("/toHomepage")
    public String toHomePage() {
        return "homepage";
    }
}
