package com.carlson.demo.dao.mapper;

import com.carlson.demo.dao.model.DemoUser;

public interface DemoUserMapper {
    DemoUser getDemoUserByNamePswd(DemoUser demoUser);
}
