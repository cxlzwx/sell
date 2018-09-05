package com.it.springboot.utils;/**
 * Created by sunrise on 2018/9/5.
 */

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.it.springboot.dto.OrderMasterDTO;
import com.it.springboot.enums.ResultEnum;
import com.it.springboot.exception.SellException;
import com.it.springboot.form.OrderForm;
import com.it.springboot.pojo.OrderDetail;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName OrderForm2OrderDTOConverter
 * @Description TODO
 * @Author sunrise
 * @Date 2018/9/5 15:00
 * @Version 1.0
 */
@Slf4j
public class OrderForm2OrderMasterDTOConverter {
    public static OrderMasterDTO converter(OrderForm orderForm) {
        OrderMasterDTO masterDTO = new OrderMasterDTO();
        masterDTO.setBuyerName(orderForm.getName());
        masterDTO.setBuyerPhone(orderForm.getPhone());
        masterDTO.setBuyerAddress(orderForm.getAddress());
        masterDTO.setBuyerOpenid(orderForm.getOpenid());

        List<OrderDetail> orderDetails =new ArrayList<>();
        try {
                ObjectMapper mapper = new ObjectMapper();
                orderDetails = mapper.readValue(orderForm.getItems(),new TypeReference<List<OrderDetail>>() { });
        } catch (Exception e) {
            log.error("【对象转换错误】" + orderForm.getItems());
            throw new SellException(ResultEnum.ORDER_FORM_ERROR);
        }
        masterDTO.setOrderDetails(orderDetails);
        return masterDTO;
    }
}
