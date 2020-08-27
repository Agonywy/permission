package com.yanzhen.controller;

import com.github.pagehelper.PageInfo;
import com.yanzhen.pojo.User;
import com.yanzhen.service.IUserService;
import com.yanzhen.util.JsonObject;
import com.yanzhen.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private IUserService userService;


    /**
     * 查询所有用户信息并进行分页处理
     */
    @RequestMapping("user/userAll")
    @ResponseBody
    public JsonObject queryUserAll(Model model, @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10")Integer pageSize, User user){
        JsonObject jsonObject = new JsonObject();
        PageInfo<User> userAll = userService.findUserAll(page, pageSize, user);
        jsonObject.setCode(0);
        jsonObject.setCount(userAll.getTotal());
        jsonObject.setData(userAll.getList());
        jsonObject.setMsg("ok");
        model.addAttribute("userAll",userAll);
        return jsonObject;

    }
    /**
     * 跳转到添加用户页面
     */
    @RequestMapping("/addUser")
    public String addUser(){
        return "pages/addUser";
    }

    /**
     * 添加用户功能
     * @return
     */
    @ResponseBody
    @RequestMapping("user/addUserSubmit")
    public R addUserSubmit(@RequestBody User user){
        userService.addUser(user);
        return R.ok();
    }


    /**
     * 批量删除功能
     * 这里批量删除选中的用户信息
     * 还需要顺带删除掉这些用户所关联的角色信息
     */
    @ResponseBody
    @RequestMapping("user/deleteUserByIds")
    public R deleteUserByIds(String ids){
        List list= Arrays.asList(ids.split(","));
        userService.deleteUserInfoByIds(list);
        return R.ok();
    }



    /**
     * 修改菜单的映射
     */
    @RequestMapping("/updateUser")
    public String updateUser(Integer id,Model model){
        //根据用户的id查询用户信息
        User user=userService.queryUserById(id);
        //把查询出来的user对象放到model中去传给前台页面
        //前台页面可以将用户信息进行渲染
        model.addAttribute("user",user);
        System.out.println(user);
        return "pages/updateUser";
    }

    /**
     * 修改功能
     * @return
     */
    @ResponseBody
    @RequestMapping("user/updateUserSubmit")
    /**@RequestBody: 作用是将HTTP请求体中的数据写入到某个对象中去*/
    public R updateUserSubmit(@RequestBody User user){
        System.out.println(user);
        userService.updateUserSubmit(user);
        return R.ok();
    }
    /**用户主页*/
    @RequestMapping("/user")
    public String userIndex(){
        return "pages/user";
    }
}
