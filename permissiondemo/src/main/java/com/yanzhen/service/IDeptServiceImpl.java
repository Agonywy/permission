package com.yanzhen.service;

import com.yanzhen.dao.IDeptDao;
import com.yanzhen.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("deptService")
public class IDeptServiceImpl implements IDeptService
{
    @Autowired
    private IDeptDao iDeptDao;

    @Override
    public List<Dept> queryDeptAll() {
        return iDeptDao.queryDeptAll();
    }

    @Override
    public void addDept(Dept dept) {
        iDeptDao.addDept(dept);
    }
}
