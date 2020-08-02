package com.yanzhen.service;

import com.yanzhen.pojo.Role;

import java.util.List;

public interface IRoleService {
    /**
     * 查询所有角色信息
     */
    public List<Role> queryRoleAll();
    /**
     * 添加功能实现
     */
    void addRoleSubmit(Role role);

    /**
     * 根据id查询角色信息
     */
    public Role queryRoleById(Integer id);
    /**
     * 修改功能
     */
    void updateRole(Role role);
    /**
     * 根据id删除角色
     */
    void deleteRoleById(Integer id);

    /**
     * 先根据角色删除原来的关联关系权限
     */
    void deleteRoleById(int id);

    /**
     * 批量进行角色权限关联
     */
    void insertFormEach(List ids);

}
