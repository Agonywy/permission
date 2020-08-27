package com.yanzhen.service;

import com.yanzhen.dao.IDeptDao;
import com.yanzhen.pojo.Dept;
import com.yanzhen.pojo.Node;
import com.yanzhen.util.TreeBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("deptService")
public class IDeptServiceImpl implements IDeptService {
    @Autowired
    private IDeptDao deptDao;

    @Autowired
    private TreeBuilder treeBuilder;

    /**查询所有的部门信息*/
    @Override
    public List<Dept> queryDeptAll() {
        return deptDao.queryDeptAll();
    }

    @Override
    public void addDept(Dept dept) {
        deptDao.addDept(dept);
    }

    @Override
    public Dept queryDeptById(Integer id) {
        return deptDao.queryDeptById(id);
    }

    @Override
    public void updateDept(Dept dept) {
        deptDao.updateDept(dept);
    }

    @Override
    public void deleteDeptById(Integer id) {
        deptDao.deleteDeptById(id);
    }

    @Override
    public List<Node> queryDeptTree() {
        List<Node> nodeList = deptDao.queryDeptTree();
        //构建树结构
        treeBuilder.buildTree(nodeList);
        return nodeList;
    }
}
