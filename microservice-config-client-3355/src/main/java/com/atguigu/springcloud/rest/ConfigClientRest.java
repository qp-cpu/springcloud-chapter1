package com.atguigu.springcloud.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigClientRest {
    @Value("${spring.application.name:default_name}")
    private String applicationName;
    @Value("${eureka.client.service-url.defaultZone:default_name}")
    private String eurekaService;
    @Value("${service.port:default_name}")
    private String port;

    @GetMapping("/config")
    public String getconfig()
    {
        String Str="applicationName:" +applicationName+"\t eurekaServices:"+eurekaService+"\t port"+port;
        System.out.println("**********str"+Str);
        return  Str;
    }
}
