package com.it.springboot.vo;/**
 * Created by sunrise on 2018/9/3.
 */

import lombok.Data;

/**
 * @ClassName Result
 * @Description 统一结果集
 * @Author sunrise
 * @Date 2018/9/3 19:17
 * @Version 1.0
 */
@Data
public class Result<T> {
    private Integer code;

    private String msg;

    private T data;
}












