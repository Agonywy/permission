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
}
