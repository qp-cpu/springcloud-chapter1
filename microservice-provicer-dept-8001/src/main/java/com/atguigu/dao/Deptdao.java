package com.atguigu.dao;

import com.atguigu.entity.Deptentity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface Deptdao {
    public boolean addDept(Deptentity deptentity);
    public Deptentity findByid(@Param("id") Integer id);
    public List<Deptentity> findAll();
}
