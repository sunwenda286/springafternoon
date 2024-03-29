package com.baizhi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(value="com.baizhi.dao")
public class SpringafternoonApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringafternoonApplication.class, args);
    }

}
