package com.yanzhen;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.yanzhen.dao")
public class PermissiondemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(PermissiondemoApplication.class, args);
    }

}
