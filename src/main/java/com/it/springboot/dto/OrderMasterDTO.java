package com.it.springboot.dto;/**
 * Created by sunrise on 2018/9/4.
 */

import com.it.springboot.enums.OrderStatusEnum;
import com.it.springboot.pojo.OrderDetail;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @ClassName OrderMasterDTO
 * @Description 订单数据传输对象
 * @Author sunrise
 * @Date 2018/9/4 15:39
 * @Version 1.0
 */
@Data
public class OrderMasterDTO {

    /*买家ID*/
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

    List<OrderDetail>  orderDetails;
}
