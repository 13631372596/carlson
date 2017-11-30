package com.carlson.demo.dao.mapper;

import com.carlson.demo.dao.model.DemoRole;

import java.util.List;

public interface DemoRoleMapper {
    DemoRole getDemoRoleById(Integer id);

    List<DemoRole> getDemoRoleByUserId(Integer id);
}
