package com.yanzhen.dao;

import com.yanzhen.pojo.User;
import com.yanzhen.pojo.UserRole;
import org.apache.ibatis.annotations.Param;
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

    /**
     * 用户的批量删除
     */
    void deleteUserByIds(List<Integer> list );
    /**
     * 用户删除---->用户关联的角色也应该删除掉
     */
    void deleteUserRoleByUserIds(List<Integer> list);

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
    User queryInfoByUsernameAndPassword(@Param("username") String username, @Param("password")String password);
}
