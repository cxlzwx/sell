package com.it.springboot.utils;/**
 * Created by sunrise on 2018/9/4.
 */

import com.it.springboot.dto.OrderMasterDTO;
import com.it.springboot.pojo.OrderMaster;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName OrderMaster2OrderMasterDTOConverter
 * @Description 转换实体类
 * @Author sunrise
 * @Date 2018/9/4 22:30
 * @Version 1.0
 */
public class OrderMaster2OrderMasterDTOConverter<T> {
    public static OrderMasterDTO converter(OrderMaster orderMaster){
        OrderMasterDTO orderMasterDTO = new OrderMasterDTO();
        BeanUtils.copyProperties(orderMaster,orderMasterDTO);
        return orderMasterDTO;
    }

    public static List<OrderMasterDTO> converter(List<OrderMaster> orderMasterList){
        return orderMasterList.stream().map(o -> converter(o)).collect(Collectors.toList());

    }
}
