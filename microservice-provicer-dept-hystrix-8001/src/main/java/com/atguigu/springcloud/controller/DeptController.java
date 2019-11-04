package com.atguigu.springcloud.controller;

import com.atguigu.entity.Deptentity;
import com.atguigu.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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
    @HystrixCommand(fallbackMethod = "processHystrix_Get")
    public Deptentity findByid(@PathVariable("id") Integer id)
    {
        Deptentity deptentity=this.deptService.findByid(id);
        if(null == deptentity)
        {
            throw new RuntimeException("该ID"+id+"没有对应的信息");
        }
        return deptentity;
    }
    public Deptentity processHystrix_Get(@PathVariable("id") Integer id)
    {
        Deptentity deptentity=new Deptentity();
        deptentity.setDeptno(id);
        deptentity.setDname("该ID:"+id+" 没有对应的信息，null--@HystrixCommand");
        deptentity.setDb_source("no this database in mysql");
        return deptentity;
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
