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
     * 修改功能
     * @return
     */
    @ResponseBody
    @RequestMapping("user/updateUserSubmit")
    public R updateUserSubmit(@RequestBody User user){
        System.out.println(user);
        userService.updateUserSubmit(user);
        return R.ok();
    }

    /**
     * 删除功能
     * @return
     */
    @ResponseBody
    @RequestMapping("user/deleteUserByIds")
    public R deleteUserByIds(String ids){
        List list= Arrays.asList(ids.split(","));
        userService.deleteUserInfoByIds(list);
        return R.ok();
    }

    /**
     * 跳转到添加用户页面
     */
    @RequestMapping("/addUser")
    public String addUser(){
        return "pages/addUser";
    }

    /**
     * 修改菜单的映射
     */
    @RequestMapping("/updateUser")
    public String updateUser(Integer id,Model model){
        //根据用户的id查询用户信息
        User user=userService.queryUserById(id);
        model.addAttribute("user",user);
        System.out.println(user);
        return "pages/updateUser";
    }


    /**用户主页*/
    @RequestMapping("/user")
    public String userIndex(){
        return "pages/user";
    }
}
