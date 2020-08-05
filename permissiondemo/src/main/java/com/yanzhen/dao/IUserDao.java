package com.yanzhen.dao;

import com.yanzhen.pojo.User;
import com.yanzhen.pojo.UserRole;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userDao")
public interface IUserDao {

    /**
     * 查询所有用户信息(普通查询)
     * 通过where标签和if标签来添加模糊查询,这样实现高级查询
     */
    List<User> queryUserAll(User user);


    void addUser(User user);

    void addUserRole(List<UserRole> userRoleList);
}
