package com.it.springboot.pojo;/**
 * Created by sunrise on 2018/9/3.
 */

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * @ClassName ProductInfo
 * @Description 商品信息
 * @Author sunrise
 * @Date 2018/9/3 17:13
 * @Version 1.0
 */
@Data
@Entity
public class ProductInfo {
    @Id
    private String productId;

    /*
    商品名称
     */
    private String productName;

    /*
     单价
     */
    private BigDecimal productPrice;

    /*
    库存
     */
    private Integer productStock;

    /*
    描述
     */
    private String productDescription;

    /*
    小图
     */
    private String productIcon;

    /*
    '商品状态,0正常1下架'
     */
    private Integer productStatus;

    /*
    '类目编号'
     */
    private Integer categoryType;

    public ProductInfo() {
    }

    public ProductInfo(String productId,String productName, BigDecimal productPrice, Integer productStock, String productDescription, String productIcon, Integer productStatus, Integer categoryType) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productStock = productStock;
        this.productDescription = productDescription;
        this.productIcon = productIcon;
        this.productStatus = productStatus;
        this.categoryType = categoryType;
    }
}
