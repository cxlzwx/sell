package com.it.springboot.service;

import com.it.springboot.dto.OrderMasterDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by sunrise on 2018/9/4.
 */
public interface OrderMasterService {
    /*创建订单*/
    OrderMasterDTO create(OrderMasterDTO orderMasterDTO);

    /* 分页查询订单*/
    Page<OrderMasterDTO> findList(String buyerOpenid,Pageable pageable);

    /* 查询单个订单 */
    OrderMasterDTO findOne(String orderId);

    /* 完结订单*/
    OrderMasterDTO finish(OrderMasterDTO orderMasterDTO);

    /*取消订单*/
    OrderMasterDTO cancel(OrderMasterDTO orderMasterDTO);

    /*支付订单 */
    OrderMasterDTO paid(OrderMasterDTO orderMasterDTO);
}
