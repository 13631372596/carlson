package com.carlson.demo.rpc.service.impl;

import com.carlson.demo.dao.mapper.DemoPermissionMapper;
import com.carlson.demo.dao.mapper.DemoRoleMapper;
import com.carlson.demo.dao.mapper.DemoUserMapper;
import com.carlson.demo.dao.model.DemoPermission;
import com.carlson.demo.dao.model.DemoUser;
import com.carlson.demo.rpc.api.IDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl implements IDemoService {

    @Autowired
    DemoUserMapper demoUserMapper;
    @Autowired
    DemoRoleMapper demoRoleMapper;
    @Autowired
    DemoPermissionMapper DemoPermissionMapper;

    public void helloWorld(String helloWorld){
        System.out.println(helloWorld);
    }

    public DemoUser getDemoUserByNamePswd(String username, String password) {
        DemoUser demoUser = new DemoUser();
        demoUser.setUsername(username);
        demoUser.setPassword(password);
        return demoUserMapper.getDemoUserByNamePswd(demoUser);
    }
}
