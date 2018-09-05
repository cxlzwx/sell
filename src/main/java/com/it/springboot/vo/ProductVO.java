package com.it.springboot.vo;/**
 * Created by sunrise on 2018/9/3.
 */

import lombok.Data;

import java.util.List;

/**
 * @ClassName ProductVO
 * @Description 商品信息相关vo
 * @Author sunrise
 * @Date 2018/9/3 19:23
 * @Version 1.0
 */
@Data
public class ProductVO {

    String name;

    Integer type;

    List<ProductInfoVO> foods;
}
