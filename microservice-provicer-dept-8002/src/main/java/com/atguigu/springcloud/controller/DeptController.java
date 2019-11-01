package com.atguigu.springcloud.controller;



import com.atguigu.entity.Deptentity;
import com.atguigu.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    @Autowired
    private DiscoveryClient discoveryClient;

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

    @GetMapping("/dept/discovery")
    public Object discovery(){
        List<String> list=discoveryClient.getServices();
        System.out.println("**************"+list);
        List<ServiceInstance> serviceInstances=discoveryClient.getInstances("MICROSERVICE-PROVICER-DEPT");
        for(ServiceInstance element:serviceInstances)
        {
            System.out.println(element.getServiceId()+"/t"+element.getHost()+"/t"+element.getUri()+"/t"+element.getPort());
        }
           return this.discoveryClient;
    }
}
