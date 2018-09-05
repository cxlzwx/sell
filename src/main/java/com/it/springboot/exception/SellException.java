package com.it.springboot.exception;/**
 * Created by sunrise on 2018/9/4.
 */

import com.it.springboot.enums.ResultEnum;

/**
 * @ClassName SellException
 * @Description 系统异常处理
 * @Author sunrise
 * @Date 2018/9/4 16:06
 * @Version 1.0
 */
public class SellException extends RuntimeException {
    private Integer code;

    public SellException(ResultEnum resultEnum){
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public SellException(ResultEnum resultEnum, String message) {
        super(message);
        this.code = code;
    }
}








