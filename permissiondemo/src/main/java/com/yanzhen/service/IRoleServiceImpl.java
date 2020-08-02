package com.yanzhen.service;

import com.yanzhen.dao.IRoleDao;
import com.yanzhen.pojo.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("roleService")
public class IRoleServiceImpl implements IRoleService{

    @Autowired
    IRoleDao roleDao;

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
    public void deleteRoleById(int id) {
        roleDao.deleteRoleMenuByRoleId(id);
    }

    @Override
    public void insertFormEach(List roleMenuList) {
        roleDao.insertFormEach(roleMenuList);
    }
}
