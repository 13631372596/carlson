package com.carlson.demo.server.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/demo")
public class DemoController {

    @RequestMapping("/login")
    public String login(){
        return "sso/login";
    }

    @RequestMapping("/test")
    @ResponseBody
    public String test(){
        System.out.println("test");
        return "test";
    }
}
