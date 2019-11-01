package com.atguigu.service;


import com.atguigu.entity.Deptentity;
import feign.Param;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(value = "MICROSERVICE-PROVICER-DEPT")
public interface DeptClientService {

    @PostMapping("/dept/add")
    public boolean addDept(Deptentity deptentity);
    @GetMapping("/dept/findByid/{id}")
    public Deptentity findByid(@Param("id") Integer id);
    @GetMapping("/dept/findAll")
    public List<Deptentity> findAll();
}
