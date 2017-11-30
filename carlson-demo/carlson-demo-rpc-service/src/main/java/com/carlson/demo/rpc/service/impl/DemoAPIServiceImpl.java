package com.carlson.demo.rpc.service.impl;

import com.carlson.demo.dao.mapper.DemoPermissionMapper;
import com.carlson.demo.dao.mapper.DemoRoleMapper;
import com.carlson.demo.dao.mapper.DemoUserMapper;
import com.carlson.demo.dao.model.DemoPermission;
import com.carlson.demo.dao.model.DemoRole;
import com.carlson.demo.dao.model.DemoUser;
import com.carlson.demo.rpc.api.IDemoAPIService;
import com.carlson.demo.rpc.api.IDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemoAPIServiceImpl implements IDemoAPIService {

    @Autowired
    DemoUserMapper demoUserMapper;
    @Autowired
    DemoRoleMapper demoRoleMapper;
    @Autowired
    DemoPermissionMapper demoPermissionMapper;

    public DemoUser getDemoUserByUsername(String username) {
        return demoUserMapper.getDemoUserByUsername(username);
    }

    public List<DemoRole> getDemoRoleByUserId(Integer id) {
        return demoRoleMapper.getDemoRoleByUserId(id);
    }

    public List<DemoPermission> getDemoPermissionByRoleId(Integer id) {
        return demoPermissionMapper.getDemoPermissionByRoleId(id);
    }
}
