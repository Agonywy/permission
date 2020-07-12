package com.yanzhen.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class Menu {
    private Integer id;
    private Integer parentId;   //父级菜单
    private String name;        //菜单名称
    private String url;         //菜单url
    private String permission;  //授权标识,多个用逗号分隔
    private Integer type;       //类型0目录,1菜单,2按钮,3导航菜单
    private String icon;        //图标
    private Integer sort;
    private String status;      //0正常,1禁用
    private Integer delFlag;    //删除标识,0未删除,1已删除
    private Integer createBy;
    private Date createTime;
    private Date dateTime;
}
