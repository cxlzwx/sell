package com.it.springboot.dto;/**
 * Created by sunrise on 2018/9/4.
 */

import lombok.Data;

/**
 * @ClassName CartDTO
 * @Description 购物车
 * @Author sunrise
 * @Date 2018/9/4 16:56
 * @Version 1.0
 */
@Data
public class CartDTO {

    //商品id
    private String productId;

    //商品数量
    private Integer productQuantity;

    public CartDTO() {
    }

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
