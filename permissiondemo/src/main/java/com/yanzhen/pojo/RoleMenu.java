package com.yanzhen.pojo;

import lombok.Data;

@Data
public class RoleMenu {
    private Integer id;
    private Integer roleId;
    private Integer menuId;

    public RoleMenu(Integer roleId, Integer menuId) {
        this.roleId = roleId;
        this.menuId = menuId;
    }
}
