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
}
