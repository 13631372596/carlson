package com.carlson.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class DemoLoginController {

    @RequestMapping("/index")
    public String index(){
        return "index";
    }
}
