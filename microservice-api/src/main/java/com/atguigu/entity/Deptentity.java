package com.atguigu.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class Deptentity implements Serializable {
    private Integer  deptno;
    private String dname;
    private String db_source;
}
