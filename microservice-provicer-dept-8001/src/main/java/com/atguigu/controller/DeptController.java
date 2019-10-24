package com.atguigu.controller;

import com.atguigu.entity.Deptentity;
import com.atguigu.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeptController {
    @Autowired
    private DeptService deptService;

    @PostMapping("/dept/add")
     public boolean addDept(@RequestBody Deptentity deptentity)
     {
         return deptService.addDept(deptentity);
     }

    @GetMapping("/dept/findByid/{id}")
    public Deptentity findByid(@PathVariable("id") Integer id)
    {
        return deptService.findByid(id);
    }

    @GetMapping("/dept/findAll")
    public List<Deptentity> findAll()
    {
        return deptService.findAll();
    }
}
