package com.carlson.demo.server.controller;

import com.carlson.demo.dao.model.DemoUser;
import com.carlson.demo.rpc.api.IDemoService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/demo")
public class DemoController {
    @Autowired
    private IDemoService demoService;

    @RequestMapping("/login")
    public String login(){
        return "sso/login";
    }

    @RequestMapping("/getDemoUserByNamePswd")
    @ResponseBody
    public String getDemoUserByNamePswd(String username,String password){
        Subject subject = SecurityUtils.getSubject();
        //DemoUser demoUser = demoService.getDemoUserByNamePswd(username, password);
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, password);
        subject.login(usernamePasswordToken);
        return "/WEB-INF/jsp/manage/index.jsp";
    }

    @RequestMapping("/test")
    @ResponseBody
    public String test(){
        demoService.helloWorld("test");
        return "test";
    }
}
