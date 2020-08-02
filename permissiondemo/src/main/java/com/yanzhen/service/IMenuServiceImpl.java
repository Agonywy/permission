package com.yanzhen.service;

import com.yanzhen.dao.IMenuDao;
import com.yanzhen.pojo.Menu;
import com.yanzhen.pojo.Node;
import com.yanzhen.pojo.RoleMenu;
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

    @Override
    public void deleteMenuById(Integer id) {
        menuDao.deleteMenuById(id);
    }

    @Override
    public Menu selectMenuById(Integer id) {
        Menu menu = menuDao.selectMenuById(id);
        return menu;
    }

    @Override
    public void updateMenuSubmit(Menu menu) {
        menuDao.updateMenuSubmit(menu);
    }

    @Override
    public List<RoleMenu> queryMenuByRoleId(Integer roleId) {
        return menuDao.queryMenuByRoleId(roleId);
    }

    @Override
    public List<Node> queryMenuTree() {
        return menuDao.queryMenuTree();
    }


}
