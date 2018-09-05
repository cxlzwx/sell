package com.it.springboot.enums;/**
 * Created by sunrise on 2018/9/3.
 */

import lombok.Getter;

/**
 * @ClassName ProductStatusEnum
 * @Description 商品状态枚举类
 * @Author sunrise
 * @Date 2018/9/3 17:58
 * @Version 1.0
 */
@Getter
public enum  ProductStatusEnum {
    UP(0 ,"上架"),DOWN(1,"下架");

    private Integer code;
    private String msg;

    ProductStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
