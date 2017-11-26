package com.carlson.demo.rpc.application;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ComponentScan(basePackages={"com.carlson.demo"})
//@MapperScan("com.carlson.demo.dao.mapper")
@ImportResource(value = {"classpath:applicationContext-dubbo-provider.xml",
        "classpath:applicationContext-jdbc.xml"})
public class DemoServiceApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(DemoServiceApplication.class);

    public static void main(String[] args) throws Exception{
        LOGGER.info(">>>>> 正在启动 <<<<<");
        SpringApplication.run(DemoServiceApplication.class, args);
        LOGGER.info(">>>>> 启动完成 <<<<<");
    }
}
