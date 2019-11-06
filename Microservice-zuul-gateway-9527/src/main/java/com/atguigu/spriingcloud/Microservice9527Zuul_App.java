package com.atguigu.spriingcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class Microservice9527Zuul_App {
    public static void main(String[] args) {
        SpringApplication.run(Microservice9527Zuul_App.class,args);
    }
}
