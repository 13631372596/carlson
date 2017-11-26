package com.carlson.demo.rpc.api;

import com.carlson.demo.dao.model.DemoUser;

public interface IDemoService {

    void helloWorld(String helloWorld);

    DemoUser getDemoUserByNamePswd(String username,String password);
}
