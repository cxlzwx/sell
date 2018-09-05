package com.it.springboot.enums;

import lombok.Getter;

/**
 * Created by sunrise on 2018/9/4.
 */
@Getter
public enum ResultEnum {

    PRODUCT_NOT_EXIST(10,"商品不存在"),

    PRODUCT_STOCK_ERROR(12,"库存不足"),

    ORDER_NOT_EXIST(13,"订单不存在"),

    ORDER_STATUS_ERROR(14,"订单状态不正确"),

    ORDERDETAIL_NOT_EXIST(15,"商品详情不存在"),

    ORDERMASTER_UPDATE_ERROR(16,"订单更新失败"),

    ORDER_DETAIL_EMPTY(17,"订单项为空"),

    order_payStatus_error(18,"支付状态不正确"),

    ORDER_FORM_ERROR(19,"订单参数错误"),

    cart_isempty_error(20,"购物车为空"),

    order_owner_error(21,"该订单不属于当前用户");

    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
