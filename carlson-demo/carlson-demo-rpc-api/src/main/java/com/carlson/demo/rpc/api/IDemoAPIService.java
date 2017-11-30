package com.carlson.demo.rpc.api;


import com.carlson.demo.dao.model.DemoPermission;
import com.carlson.demo.dao.model.DemoRole;
import com.carlson.demo.dao.model.DemoUser;

import java.util.List;

public interface IDemoAPIService {
    DemoUser getDemoUserByUsername(String username);

    List<DemoRole> getDemoRoleByUserId(Integer id);

    List<DemoPermission> getDemoPermissionByRoleId(Integer id);
}
