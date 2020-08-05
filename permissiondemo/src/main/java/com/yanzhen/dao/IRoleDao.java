package com.yanzhen.dao;

import com.yanzhen.pojo.Node;
import com.yanzhen.pojo.Role;
import com.yanzhen.pojo.RoleMenu;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("roleDao")
public interface IRoleDao {
    /**
     * 查询所有角色信息
     */
    List<Role> queryRoleAll();
    /**
     * 添加功能实现
     */
    void addRoleSubmit(Role role);

    /**
     * 根据id查询角色信息
     */
    Role queryRoleById(Integer id);
    /**
     * 修改功能
     */
    void updateRole(Role role);
    /**
     * 根据id删除角色
     */
    void deleteRoleById(Integer id);

    /**
     * 删除角色id关联到的菜单内容
     */
    void deleteRoleMenuByRoleId(int roleId);
    /**
     * 批量的添加权限关联
     */
    void insertFormEach(List<RoleMenu> roleMenuList);

    List<Node> queryRoleTree();
}
