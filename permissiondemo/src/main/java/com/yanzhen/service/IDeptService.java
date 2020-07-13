package com.yanzhen.service;

import com.yanzhen.pojo.Dept;

import java.util.List;


public interface IDeptService {
    /**
     * 查询所有的部门
     */
    List<Dept> queryDeptAll();
}
