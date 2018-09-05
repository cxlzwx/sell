package com.it.springboot.service.impl;

import com.it.springboot.dto.OrderMasterDTO;
import com.it.springboot.enums.OrderStatusEnum;
import com.it.springboot.pojo.OrderDetail;
import com.it.springboot.service.OrderMasterService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by sunrise on 2018/9/4.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OrderMasterServiceImplTest {

    @Autowired
    OrderMasterService orderMasterService;

    @Test
    public void create() throws Exception {
        OrderMasterDTO masterDTO = new OrderMasterDTO();
        masterDTO.setBuyerAddress("杭州西湖");
        masterDTO.setBuyerName("程序员4");
        masterDTO.setBuyerOpenid("111");
        masterDTO.setBuyerPhone("12323232678");

        ArrayList<OrderDetail> orderDetails = new ArrayList<>();
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setProductId("123456");
        orderDetail.setProductQuantity(2);
        orderDetails.add(orderDetail);

        masterDTO.setOrderDetails(orderDetails);

        OrderMasterDTO orderMasterDTO = orderMasterService.create(masterDTO);
        Assert.assertNotNull(orderMasterDTO);

    }

    @Test
    public void findList() throws Exception {
        PageRequest request = new PageRequest(0, 2);
        Page<OrderMasterDTO> list = orderMasterService.findList("111", request);
        Assert.assertNotNull(list);
    }

    @Test
    public void findOne() throws Exception {
        OrderMasterDTO masterDTO = orderMasterService.findOne("1536067805176111708");
        log.info("[订单结果] masterDTO{}"+masterDTO);
        Assert.assertNotNull(masterDTO);
    }

    @Test
    public void cancel() throws Exception {
        OrderMasterDTO masterDTO = orderMasterService.findOne("1536067805176111708");
        OrderMasterDTO orderMasterDTO = orderMasterService.cancel(masterDTO);
        Assert.assertNotEquals(OrderStatusEnum.CANCEL.getCode(),orderMasterDTO.getOrderStatus());
    }

    @Test
    public void finish() throws Exception {
    }

    @Test
    public void paid() throws Exception {
    }

}