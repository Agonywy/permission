package com.yanzhen.util;

import lombok.Data;

import java.util.List;

/**
 * 将后台对象信息处理成json对象返回给前台
 * @param <T>
 */
@Data
public class JsonObject<T> {
    private Integer code;
    private String msg;
    private Long count;
    private List<T> data;
}
