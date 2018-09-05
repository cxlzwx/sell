package com.it.springboot.enums;

import lombok.Data;
import lombok.Getter;

/**
 * 订单状态枚举
 */
@Getter
public enum OrderStatusEnum {
    NEW(0,"新订单"),
    FINISHED(1,"已完结"),
    CANCEL(2,"已取消")
    ;

    private Integer code;
    private String msg;

     OrderStatusEnum(Integer code, String msg){
        this.code = code;
        this.msg = msg;
    }
}
