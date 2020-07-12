package com.yanzhen.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Dept implements Serializable {
    private Integer id;
    private Integer parentId;   //父级部门
    private String name;        //部门名称
    private Integer type;       //类型0公司,1部门,2科室/小组
    private Integer sort;
    private String status;      //0正常,1禁用
    private Integer createBy;
    private Date createTime;
    private Date dateTime;
}
