package com.yanzhen.service;

import com.github.pagehelper.PageInfo;
import com.yanzhen.pojo.User;

import java.util.List;


public interface IUserService {

    /**
     * 分页查询用户信息
     */
    PageInfo<User> findUserAll(int page,int pageSize,User user);

    void updateUserSubmit(User user);

    void addUser(User user);

    void deleteUserInfoByIds(List list);

    User queryUserById(Integer id);

}
