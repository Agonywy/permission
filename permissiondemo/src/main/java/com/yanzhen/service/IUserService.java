package com.yanzhen.service;

import com.github.pagehelper.PageInfo;
import com.yanzhen.pojo.User;

import java.util.List;


public interface IUserService {

    /**
     * 分页查询用户信息
     */
    PageInfo<User> findUserAll(int page,int pageSize,User user);

    void addUser(User user);

    /**
     * 删除用户信息
     * 不仅删除用户信息,还需要删除用户关联的角色信息
     */
    void deleteUserInfoByIds(List list);

    /**
     * 根据用户id查询用户信息
     * 因为监听修改按钮的时候,会弹出一个修改的form框
     * 需要将用户已经有的信息渲染到form框中,所以要用userId查询用户信息
     **/
    User queryUserById(Integer id);
    /**
     * 修改用户信息
     * 只实现了修改用户的基本信息
     * 因此不能修改用户的角色信息和菜单权限信息
     */
    void updateUserSubmit(User user);

    /**根据用户名和密码查询对象信息*/
    User queryInfoByUsernameAndPassword(String username,String password);

}
