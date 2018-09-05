package com.it.springboot.enums;

import lombok.Getter;

/**
 * Created by sunrise on 2018/9/4.
 */

/**
 * 支付状态枚举
 */
@Getter
public enum PayStatusEnum {
    WAIT(0,"等待支付"),
    SUCCECC(1,"支付成功")
    ;

    private Integer code;
    private String msg;

     PayStatusEnum(Integer code, String msg){
        this.code = code;
        this.msg = msg;
    }
}
