package com.yanzhen.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Role implements Serializable {
    private Integer id;
    private Integer parentId;   //角色父结点id
    private Integer type;       //0分类,1角色
    private String name;        //角色名
    private String remarks;     //备注
    private Integer create_by;
    private Date createTime;
    private Date updateTime;
}
