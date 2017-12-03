package com.carlson.demo.server.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/manage")
public class DemoManageController {
    @RequestMapping("/index")
    public String index(){
        return "/manage/index";
    }

    @RequestMapping("/add")
    @RequiresPermissions("add")
    @ResponseBody
    public String add(){
        return "SUCCESS";
    }

}
