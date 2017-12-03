package com.carlson.demo.server.controller;

import com.carlson.common.util.RedisUtil;
import com.carlson.demo.rpc.api.IDemoService;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/demo")
public class DemoController {
    @Autowired
    private IDemoService demoService;
    // 全局会话key列表
    private final static String DEMO_SERVER_SESSIONID = "xxx";

    @RequestMapping("/index")
    public String login(){
        return "redirect:/demo/login?backurl=";
    }

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(String backUrl){
        if(StringUtils.isBlank(backUrl)){
            backUrl = "/";
        }
        return "/sso/login";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public String login(String username,String password){
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, password);
        subject.login(usernamePasswordToken);
        RedisUtil.lpush(DEMO_SERVER_SESSIONID, session.getId().toString());
        return "SUCCESS";
    }

}
