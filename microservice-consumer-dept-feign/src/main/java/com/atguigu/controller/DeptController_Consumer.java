package com.atguigu.controller;

import com.atguigu.entity.Deptentity;
import com.atguigu.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


import java.util.List;

@RestController
public class DeptController_Consumer {

    @Autowired
    private DeptClientService service;

    @PostMapping("/consumer/dept/add")
    public boolean add(@RequestBody Deptentity deptentity)
    {
        return  this.service.addDept(deptentity);

    }
    @GetMapping("/consumer/dept/findByid/{id}")
    public Deptentity findByid(@PathVariable("id") Integer id)
    {
        return this.service.findByid(id);
    }

    @GetMapping("/consumer/dept/findAll")
    public List<Deptentity> findAll()
    {
        return this.service.findAll();
    }

}
