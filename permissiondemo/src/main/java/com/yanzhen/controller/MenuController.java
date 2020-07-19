package com.yanzhen.controller;

import com.yanzhen.pojo.Menu;
import com.yanzhen.service.IMenuService;
import com.yanzhen.util.JsonObject;
import com.yanzhen.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

@Controller
public class MenuController {

    @Autowired
    IMenuService menuService;

    /**
     * 查询所有菜单信息
     */
    @RequestMapping("menu/menuAll")
    @ResponseBody
    public JsonObject queryAllMenu(){
        List<Menu> menus = menuService.queryAllMenu();
        JsonObject jsonObject = new JsonObject();
        jsonObject.setData(menus);
        jsonObject.setCount((long) menus.size());
        jsonObject.setCode(200);
        jsonObject.setMsg("OK");
        return jsonObject;
    }

    /**
     * 添加菜单方法
     */
    @RequestMapping("menu/addMenuSubmit")
    @ResponseBody
    public R addMenuSubmit(Menu menu){
        menu.setCreateTime(new Date());
        menuService.addMenuSubmit(menu);
        return R.ok();
    }
    /**
     * 根据菜单Id删除菜单及其子节点
     */
    @RequestMapping("menu/deleteMenuById")
    @ResponseBody
    public R deleteMenuById(Integer id){
        menuService.deleteMenuById(id);
        return R.ok();
    }
    /**
     * 根据菜单Id查询菜单信息
     */
    @RequestMapping("menu/selectMenuById")
    public String selectMenuById(Integer id, Model model){
        Menu menu = menuService.selectMenuById(id);
        //逐个设定值信息
        model.addAttribute("menu",menu);
        return "pages/updateMenu";
    }

    /**
     * 更改菜单信息
     */
    @ResponseBody
    @RequestMapping("menu/updateMenuSubmit")
    public R updateMenuSubmit(Menu menu){
        menuService.updateMenuSubmit(menu);
        return R.ok();
    }

    /**
     * 静态页面的跳转菜单页面
     */
    @RequestMapping("/menu")
    public String menuIndex(){
        return "pages/menu";
    }

    /**
     * 添加页面
     */
    @RequestMapping("addMenu")
    public String addMenu(Integer type, Integer parentId, Model model){
        /**
         * 如果是头部的话,前台传过来的值是-1
         */
        if(type == -1){
            type = 0;
            parentId = -1;
        }else{
            type += 1;
        }
        //上级类型只能添加下级类型
        model.addAttribute("type",type);
        model.addAttribute("parentId",parentId);
        return "pages/addMenu";
    }
}
