package com.carlson.demo.dao.model;

import java.io.Serializable;

public class DemoRole implements Serializable{
    private Integer id;
    private String  roleName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
