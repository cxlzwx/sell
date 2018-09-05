package com.it.springboot.service;

import com.it.springboot.dto.OrderMasterDTO;

/**
 * Created by sunrise on 2018/9/5.
 */
public interface BuyerService {
    OrderMasterDTO findOneOrder(String openid,String orderId);

    OrderMasterDTO canceOneOrder(String openid,String orderId);
}
