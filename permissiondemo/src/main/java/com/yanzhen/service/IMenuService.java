package com.yanzhen.service;

import com.yanzhen.pojo.Menu;

import java.util.List;

public interface IMenuService {
    /**
     * 查询菜单
     */
    List<Menu> queryAllMenu();

    /**
     * 添加菜单
     */
    void addMenuSubmit(Menu menu);

    /**
     * 根据菜单Id删除菜单
     * @param id
     */
    void deleteMenuById(Integer id);

    /**
     * 根据id查询菜单信息
     * @return
     */
    Menu selectMenuById(Integer id);
    /**
     * 修改菜单信息
     */
    void updateMenuSubmit(Menu menu);
}
