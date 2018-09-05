package com.it.springboot.pojo;/**
 * Created by sunrise on 2018/9/4.
 */

import lombok.Data;
import lombok.experimental.var;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @ClassName OrderDetail
 * @Description 订单详情
 * @Author sunrise
 * @Date 2018/9/4 14:23
 * @Version 1.0
 */
@Data
@Entity
@DynamicUpdate
public class OrderDetail {

    @Id
    private String detailId;

    /* 买家ID */
    private String orderId;

    /* 商品id*/
    private String productId;

    /*商品名称 */
    private String productName;

    /* 当前价格,单位分*/
    private BigDecimal productPrice;

    /*数量 */
    private Integer productQuantity;

    /*小图 */
    private String productIcon;

    private Date createTime;

    private Date updateTime;


    public OrderDetail() {
    }

    public OrderDetail(String detailId, String orderId, String productId, String productName, BigDecimal productPrice, Integer productQuantity, String productIcon) {
        this.detailId = detailId;
        this.orderId = orderId;
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
        this.productIcon = productIcon;
    }
}
