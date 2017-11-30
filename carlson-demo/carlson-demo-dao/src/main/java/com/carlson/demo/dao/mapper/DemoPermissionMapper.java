package com.carlson.demo.dao.mapper;

import com.carlson.demo.dao.model.DemoPermission;

import java.util.List;

public interface DemoPermissionMapper {
    DemoPermission getDemoPermissionById(Integer id);

    List<DemoPermission> getDemoPermissionByRoleId(Integer id);
}
