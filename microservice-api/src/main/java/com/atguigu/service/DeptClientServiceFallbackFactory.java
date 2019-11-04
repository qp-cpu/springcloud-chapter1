package com.atguigu.service;

import com.atguigu.entity.Deptentity;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService> {
    public DeptClientService create(Throwable cause) {
        return new DeptClientService() {
            public boolean addDept(Deptentity deptentity) {
                return false;
            }

            public Deptentity findByid(Integer id) {
                Deptentity deptentity=new Deptentity();
                deptentity.setDeptno(id);
                deptentity.setDname("该ID:"+id+" 没有对应的信息，null--@HystrixCommand");
                deptentity.setDb_source("no this database in mysql");
                return deptentity;
            }
            public List<Deptentity> findAll() {
                return null;
            }
        };
    }
}
