package com.it.springboot.pojo;/**
 * Created by sunrise on 2018/9/4.
 */

import com.it.springboot.enums.OrderStatusEnum;
import lombok.Data;
import lombok.experimental.var;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @ClassName OrderMaster
 * @Description 订单
 * @Author sunrise
 * @Date 2018/9/4 14:08
 * @Version 1.0
 */
@Data
@Entity
@DynamicUpdate
public class OrderMaster {

    /*买家ID*/
    @Id
    private String orderId;

    /*买家名字*/
    private String buyerName;

    /*买家电话*/
    private String buyerPhone;

    /*买家地址*/
    private String buyerAddress;

    /*买家微信openid*/
    private String buyerOpenid;

    /*订单金额*/
    private BigDecimal orderAmount;

    /*订单状态,默认为0新建*/
    private Integer orderStatus = OrderStatusEnum.NEW.getCode();

    /*支付状态*/
    private Integer payStatus;

    private Date createTime;

    private Date updateTime;

    public OrderMaster() {
    }

    public OrderMaster(String orderId, String buyerName, String buyerPhone, String buyerAddress, String buyerOpenid, BigDecimal orderAmount, Integer orderStatus, Integer payStatus) {
        this.orderId = orderId;
        this.buyerName = buyerName;
        this.buyerPhone = buyerPhone;
        this.buyerAddress = buyerAddress;
        this.buyerOpenid = buyerOpenid;
        this.orderAmount = orderAmount;
        this.orderStatus = orderStatus;
        this.payStatus = payStatus;
    }
}
