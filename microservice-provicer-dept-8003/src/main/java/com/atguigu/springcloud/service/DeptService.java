package com.atguigu.springcloud.service;

import com.atguigu.entity.Deptentity;
import com.atguigu.springcloud.dao.Deptdao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptService {

    @Autowired
    private Deptdao deptdao;

    public boolean addDept(Deptentity deptentity){
        return deptdao.addDept(deptentity);
    }

    public Deptentity findByid(Integer id){
        return deptdao.findByid(id);
    }
    public List<Deptentity> findAll(){
        return deptdao.findAll();
    }
}
