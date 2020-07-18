package com.yanzhen.service;

import com.yanzhen.dao.IMenuDao;
import com.yanzhen.pojo.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("menuService")
public class IMenuServiceImpl implements IMenuService{

    @Autowired
    IMenuDao menuDao;

    @Override
    public List<Menu> queryAllMenu() {
        return menuDao.queryMenuAll();
    }

    @Override
    public void addMenuSubmit(Menu menu) {
        menuDao.addMenu(menu);
    }
}
