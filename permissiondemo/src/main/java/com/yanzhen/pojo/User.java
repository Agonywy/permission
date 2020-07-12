package com.yanzhen.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class User implements Serializable {
    private Integer id;
    private Integer deptId;    //部门id
    private String username;    //登录用户名
    private String password;    //登录密码
    private String realname;    //真实姓名
    private String sex;        //性别
    private String tel;         //电话
    private String email;       //邮箱
    private String avatar;      //头像
    private String jobTitle;   //职务名称
    private Integer status;     //0正常,1禁用
    private Integer sort;
    private Integer delFlag;   //删除标识,0未删除,1已删除
    private Integer createBy;
    private Date createTime;
    private Date updateTime;
}
