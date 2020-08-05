package com.yanzhen.service;

import com.yanzhen.dao.IRoleDao;
import com.yanzhen.pojo.Node;
import com.yanzhen.pojo.Role;
import com.yanzhen.pojo.RoleMenu;
import com.yanzhen.util.TreeBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("roleService")
public class IRoleServiceImpl implements IRoleService{

    @Autowired
    IRoleDao roleDao;

    @Autowired
    TreeBuilder treeBuilder;
    @Override
    public List<Role> queryRoleAll() {
        return roleDao.queryRoleAll();
    }

    @Override
    public void addRoleSubmit(Role role) {
        roleDao.addRoleSubmit(role);
    }

    @Override
    public Role queryRoleById(Integer id) {
        return roleDao.queryRoleById(id);
    }

    @Override
    public void updateRole(Role role) {
        roleDao.updateRole(role);
    }

    @Override
    public void deleteRoleById(Integer id) {
        roleDao.deleteRoleById(id);
    }

    @Override
    public void deleteRoleMenuByRoleId(int id) {
        roleDao.deleteRoleMenuByRoleId(id);
    }

    @Override
    @Transactional
    public void insertFormEach(int roleId,int[] ids) {
        this.deleteRoleMenuByRoleId(roleId);
        List<RoleMenu> list = new ArrayList<>();
        for (int id : ids) {
            RoleMenu roleMenu = new RoleMenu(roleId,id);
            list.add(roleMenu);
        }
        roleDao.insertFormEach(list);
    }

    @Override
    public List<Node> queryRoleTree() {
        List<Node> nodes = roleDao.queryRoleTree();
        //构建树结构
        treeBuilder.buildTree(nodes);
        return nodes;
    }
}
