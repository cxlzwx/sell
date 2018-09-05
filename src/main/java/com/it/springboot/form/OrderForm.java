package com.it.springboot.form;/**
 * Created by sunrise on 2018/9/5.
 */

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @ClassName OrderForm
 * @Description TODO
 * @Author sunrise
 * @Date 2018/9/5 14:27
 * @Version 1.0
 */
@Data
public class OrderForm {

    @NotEmpty(message = "姓名不能为空")
    private String name;

    @NotEmpty(message = "手机号不能为空")
    private String phone;

    @NotEmpty(message = "地址不能为空")
    private String address;

    @NotEmpty(message = "openid不能为空")
    private String openid;

    @NotEmpty(message = "购物项不能为空")
    private String items;
}
