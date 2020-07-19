package com.yanzhen.dao;

import com.yanzhen.pojo.Menu;
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
}
