package com.atguigu.controller;

import com.atguigu.entity.Deptentity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptController_Consumer {
    private static final String REST_URL_PREFIX="http://MICROSERVICE-PROVICER-DEPT";

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/consumer/dept/add")
    public boolean add(@RequestBody Deptentity deptentity)
    {
        return  restTemplate.postForObject(REST_URL_PREFIX+"/dept/add",deptentity,Boolean.class);
    }
    @GetMapping("/consumer/dept/findByid/{id}")
    public Deptentity findByid(@PathVariable("id") Integer id)
    {
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/findByid/"+id,Deptentity.class);
    }
    @GetMapping("/consumer/dept/findAll")
    public List<Deptentity> findAll()
    {
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/findAll",List.class);
    }
    @GetMapping("/consumer/dept/discovery")
    public Object discovery(){
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/discovery",Object.class);
    }
}
