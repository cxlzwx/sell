package com.it.springboot.service.impl;/**
 * Created by sunrise on 2018/9/5.
 */

import com.it.springboot.dto.OrderMasterDTO;
import com.it.springboot.enums.ResultEnum;
import com.it.springboot.exception.SellException;
import com.it.springboot.service.BuyerService;
import com.it.springboot.service.OrderMasterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.rmi.runtime.Log;

/**
 * @ClassName BuyerServiceImpl
 * @Description TODO
 * @Author sunrise
 * @Date 2018/9/5 21:46
 * @Version 1.0
 */
@Service
@Slf4j
public class BuyerServiceImpl implements BuyerService{

    @Autowired
    OrderMasterService orderMasterService;

    @Override
    public OrderMasterDTO findOneOrder(String openid, String orderId) {

        return checkOrderOwner(openid, orderId);
    }

    @Override
    public OrderMasterDTO canceOneOrder(String openid, String orderId) {
        OrderMasterDTO masterDTO = checkOrderOwner(openid, orderId);
        if (masterDTO == null){
            log.error("【取消订单】订单不存在");
        }
        return orderMasterService.cancel(masterDTO);
    }

    private OrderMasterDTO checkOrderOwner(String openid, String orderId){
        OrderMasterDTO orderMasterDTO = orderMasterService.findOne(orderId);
        if (orderMasterDTO == null){
            return  null;
        }
        if (!orderMasterDTO.getBuyerOpenid().equalsIgnoreCase(orderId)){
            log.error("【查询订单】查询失败"+openid);
            throw new SellException(ResultEnum.order_owner_error);
        }
        return orderMasterDTO;

    }
}
