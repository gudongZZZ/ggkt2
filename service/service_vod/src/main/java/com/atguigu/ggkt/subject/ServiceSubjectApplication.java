package com.atguigu.ggkt.subject;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.atguigu")
@MapperScan(value = "com.atguigu.ggkt.subject.mapper")
public class ServiceSubjectApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceSubjectApplication.class,args);
    }
}
