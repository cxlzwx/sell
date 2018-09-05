package com.it.springboot.dao;

import com.it.springboot.pojo.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by sunrise on 2018/9/4.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {

    @Autowired
    private OrderDetailRepository detailRepository;


    @Test
    public void save (){
        OrderDetail detail = new OrderDetail("11111", "12345", "123456", "黄焖鸡", new BigDecimal(22.0), 2, "http://xxx.jpg");
        OrderDetail orderDetail = detailRepository.save(detail);
        Assert.assertNotNull(orderDetail);

    }

    @Test
    public void findByOrderId() throws Exception {

        List<OrderDetail> detailList = detailRepository.findByOrderId("1536067805176111708");
        Assert.assertNotNull(detailList);
    }

}