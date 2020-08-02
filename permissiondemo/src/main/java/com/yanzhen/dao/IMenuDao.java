package com.yanzhen.dao;

import com.yanzhen.pojo.Menu;
import com.yanzhen.pojo.Node;
import com.yanzhen.pojo.RoleMenu;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("menuDao")
public interface IMenuDao {
    /**
     * 查询所有的菜单信息
     */
    List<Menu> queryMenuAll();

    void addMenu(Menu menu);

    void deleteMenuById(Integer id);

    /**
     * 根据菜单id查询菜单详情
     */
    Menu selectMenuById(Integer id);
    /**
     * 修改菜单信息
     */
    void updateMenuSubmit(Menu menu);
    /**
     * 根据角色查询关联到的菜单
     */
    List<RoleMenu> queryMenuByRoleId(Integer roleId);

    /**
     * 查询获取树状结构的菜单
     */
    List<Node> queryMenuTree();
}
