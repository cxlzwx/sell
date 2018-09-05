package com.it.springboot.enums;

import lombok.Getter;

/**
 * Created by sunrise on 2018/9/4.
 */
@Getter
public enum ResultEnum {

    PRODUCT_NOT_EXIST(10,"商品不存在"),

    PRODUCT_STOCK_ERROR(20,"库存不足"),

    ORDER_NOT_EXIST(30,"订单不存在"),

    ORDER_STATUS_ERROR(40,"订单状态不正确"),

    ORDERDETAIL_NOT_EXIST(40,"商品详情不存在"),

    ORDERMASTER_UPDATE_ERROR(50,"订单更新失败"),

    ORDER_DETAIL_EMPTY(60,"订单项为空");

    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
