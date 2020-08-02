package com.yanzhen.controller;

import com.yanzhen.pojo.Role;
import com.yanzhen.service.IRoleService;
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
public class RoleController {

    @Autowired
    IRoleService roleService;

    /**
     * 查询所有角色信息
     */
    @RequestMapping("role/roleAll")
    @ResponseBody
    public JsonObject queryRoleAll(){
        List<Role> roles = roleService.queryRoleAll();
        JsonObject<Role> jsonObject = new JsonObject<>();
        jsonObject.setData(roles);
        jsonObject.setCount((long) roles.size());
        jsonObject.setCode(200);
        jsonObject.setMsg("OK");
        return jsonObject;
    }
    /**
     * 添加页面跳转
     */
    @RequestMapping("/addRole")
    String addRole(Integer parentId, Model model){
        model.addAttribute("parentId",parentId);
        return "pages/addRole";
    }
    /**
     * 添加功能实现
     */
    @RequestMapping("role/addRoleSubmit")
    @ResponseBody
    public R addRoleSubmit(Role role){
        role.setCreateTime(new Date());
        roleService.addRoleSubmit(role);
        return R.ok();
    }

    /**
     * 根据id查询角色信息
     */
    @RequestMapping("queryRoleById")
    public String queryRoleById(Integer id,Model model){
        Role role = roleService.queryRoleById(id);
        model.addAttribute("role",role);
        return "pages/updateRole";
    }
    /**
     * 修改功能
     */
    void updateRole(Role role){
        roleService.updateRole(role);
    }
    /**
     * 根据id删除角色
     */
    @RequestMapping("role/deleteRoleById")
    @ResponseBody
    R deleteRoleById(Integer id){
        roleService.deleteRoleById(id);
        return R.ok();
    }
    /**
     * 添加权限
     * @param roleId:角色id
     * @param ids: 选中的菜单权限的id
     */
    @RequestMapping("role/addPermSubmit")
    @ResponseBody
    public R addPermSubmit(int roleId, int[] ids){
        roleService.insertFormEach(roleId,ids);
        return R.ok();
    }

    /**
     * 添加角色关联菜单权限跳转页面
     * id : 角色Id
     */
    @RequestMapping("/addPerm")
    public String addPerm(Integer id, Model model){
        model.addAttribute("roleId",id);
        return "pages/addPram";
    }

    /**
     * 跳转静态页面role.html
     */
    @RequestMapping("/role")
    public String roleMenu(){
        return "pages/role";
    }

    /**
     * 进行角色页面的修改跳转
     */
    @RequestMapping("role/queryRoleById")
    public String queryRoleById(Model model,int id){
        //根据id查询角色信息,返回前台
        Role role = roleService.queryRoleById(id);
        model.addAttribute("role",role);
        return "pages/updateRole";
    }

    @RequestMapping("role/updateRoleSubmit")
    @ResponseBody
    public R updateRoleSubmit(Role role){
        role.setUpdateTime(new Date());
        roleService.updateRole(role);
        return R.ok();
    }


}
