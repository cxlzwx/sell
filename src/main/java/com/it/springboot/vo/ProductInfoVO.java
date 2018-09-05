package com.it.springboot.vo;/**
 * Created by sunrise on 2018/9/3.
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @ClassName ProductInfoVO
 * @Description 前端需要的商品信息
 * @Author sunrise
 * @Date 2018/9/3 19:26
 * @Version 1.0
 */
@Data
public class ProductInfoVO {

    @JsonProperty(value = "id")
    private String productId;

    @JsonProperty(value = "name")
    private String productName;

    @JsonProperty(value = "price")
    private BigDecimal productPrice;

    @JsonProperty(value = "description")
    private String productDescription;

    @JsonProperty(value = "icon")
    private String productIcon;


}
