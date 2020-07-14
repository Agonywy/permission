package com.yanzhen.dao;

import com.yanzhen.pojo.Dept;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("deptDao")
public interface IDeptDao {
    /**
     * 查询所有部门信息
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
}
