package com.yanzhen.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yanzhen.dao.IUserDao;
import com.yanzhen.pojo.User;
import com.yanzhen.pojo.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
public class IUserServiceImpl implements IUserService{

    @Autowired
    IUserDao userDao;

    @Override
    @ResponseBody
    @RequestMapping("user/")
    public PageInfo<User> findUserAll(int page, int pageSize, User user) {
        PageHelper.startPage(page, pageSize);//使用分页插件
        //查询所有的用户信息
        List<User> list = userDao.queryUserAll(user);
        PageInfo<User> pageInfoList = new PageInfo<>(list);
        return pageInfoList;
    }

    @Override
    public void updateUserSubmit(User user) {

    }

    @Override
    public void addUser(User user) {
        //获取user对象中的角色ID集合
        List<Integer> roleIdList = user.getRoleIdList();
        userDao.addUser(user);
        //获取用户id
        Integer id = user.getId();
        List<UserRole> userRoles = new ArrayList<>();
        for (Integer s : roleIdList) {
            userRoles.add(new UserRole(s,id));
        }
        //用户关联角色
        userDao.addUserRole(userRoles);
    }

    @Override
    public void deleteUserInfoByIds(List list) {

    }

    @Override
    public User queryUserById(Integer id) {
        return null;
    }



}
