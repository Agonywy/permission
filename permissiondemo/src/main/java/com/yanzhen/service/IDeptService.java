package com.yanzhen.service;

import com.yanzhen.pojo.Dept;

import java.util.List;


public interface IDeptService {
    /**
     * 查询所有的部门
     */
    List<Dept> queryDeptAll();
    /**
     * 添加部门信息
     */
    void addDept(Dept dept);
    /**
     * 根据部门id查询部门信息
     */
    Dept queryDeptById(Integer id);
    /**
     * 修改操作
     */
    void updateDept(Dept dept);

    /**
     * 根据id删除部门信息
     */
    void deleteDeptById(Integer id);
}
