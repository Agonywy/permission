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
}
